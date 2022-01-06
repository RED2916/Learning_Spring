package com.tydic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String logInSuccess(Model model){
        String userName = (String) model.getAttribute("userName");
        model.addAttribute("msg",userName);
        return "hello";
    }

}
