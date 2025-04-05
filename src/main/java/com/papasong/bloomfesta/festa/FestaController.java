package com.papasong.bloomfesta.festa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FestaController {

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }
}
