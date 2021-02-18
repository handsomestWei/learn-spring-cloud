package com.wjy.learn.cloud.bizconsumer.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "biz-producer",fallback=FeignServiceFallback.class)
public interface FeignService {

    @GetMapping("/fhi")
    String getHi(@RequestParam("name") String name);

}
