package com.wjy.learn.cloud.bizconsumer;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients
public class BizConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    // restTemplate整合sentinel
    // @SentinelRestTemplate
    RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

}
