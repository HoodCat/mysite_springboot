package com.github.hoodcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/main")
    public String main() {
        return "main/index";
    }
    
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "안녕하세요";
    }
}
