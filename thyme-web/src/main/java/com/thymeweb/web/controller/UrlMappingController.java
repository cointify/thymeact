package com.thymeweb.web.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class UrlMappingController {

    @RequestMapping(value = {"/", "/home", "/index"})
    public String getRootView() {
        return "index";
    }
}
