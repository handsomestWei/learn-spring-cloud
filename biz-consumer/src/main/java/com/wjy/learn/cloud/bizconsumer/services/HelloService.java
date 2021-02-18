package com.wjy.learn.cloud.bizconsumer.services;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    //@HystrixCommand(fallbackMethod = "hiFallbackMethod")
    @SentinelResource(value = "hiService", fallback = "hiFallbackHandler", blockHandler = "hiBlockHandler")
    public String hiService(String name)
    {
        if ("qwe".equals(name)) {
            throw new RuntimeException("qwe");
        }
        return restTemplate.getForObject("http://biz-producer/hi?name=" + name, String.class);
    }

    public String hiFallbackMethod(String name)
    {
        return "hystrix 熔断 【" +
                name + "】 there is some problem with hi page";
    }

    public String hiFallbackHandler(String name)
    {
        return "sentinel 熔断 【" +
                name + "】 there is some problem with hi page";
    }

    // 需要sentinel规则控制
    public String hiBlockHandler(String name, BlockException ex)
    {
        return "sentinel 限流 【" +
                name + "】 there is limit access hi page";
    }
}
