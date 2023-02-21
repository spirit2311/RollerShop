package com.example.rollerShop.db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashController {

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }
}