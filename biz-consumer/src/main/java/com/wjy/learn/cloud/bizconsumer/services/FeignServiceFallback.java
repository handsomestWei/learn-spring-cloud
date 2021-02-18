package com.wjy.learn.cloud.bizconsumer.services;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallback implements FeignService {
    @Override
    public String getHi(String name) {
        return "hey " +
                name + ", there is some problem with feignHi page";
    }
}
