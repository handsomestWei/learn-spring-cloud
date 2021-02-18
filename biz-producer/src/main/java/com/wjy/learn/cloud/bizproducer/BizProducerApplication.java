package com.wjy.learn.cloud.bizproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// 使用cloud原生注解@EnableDiscoveryClient替代@EnableEurekaClient支持连接更多服务注册中心
@EnableDiscoveryClient
public class BizProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizProducerApplication.class, args);
    }

}
