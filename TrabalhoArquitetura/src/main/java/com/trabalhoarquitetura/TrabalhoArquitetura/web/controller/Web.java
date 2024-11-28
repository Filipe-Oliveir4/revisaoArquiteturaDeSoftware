package com.trabalhoarquitetura.TrabalhoArquitetura.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Web {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
