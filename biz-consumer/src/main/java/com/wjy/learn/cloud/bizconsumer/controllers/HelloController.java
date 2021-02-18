package com.wjy.learn.cloud.bizconsumer.controllers;

import com.wjy.learn.cloud.bizconsumer.services.FeignService;
import com.wjy.learn.cloud.bizconsumer.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @Resource
    private FeignService feignService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name)
    {

        return service.hiService(name);
    }

    @RequestMapping(value = "/fhi")
    public String fhi(@RequestParam String name)
    {
        return feignService.getHi(name);
    }
}
