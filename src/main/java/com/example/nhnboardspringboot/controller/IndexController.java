package com.example.nhnboardspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
public class IndexController {
    @GetMapping(value = { "/", "/index.nhn" })
    public String index() {
        return "index/index";
    }
}
