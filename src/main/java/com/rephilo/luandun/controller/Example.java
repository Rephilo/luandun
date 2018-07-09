package com.rephilo.luandun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {

    @RequestMapping("/hello")
    public Object test() {
        return "hello world!";
    }
}
