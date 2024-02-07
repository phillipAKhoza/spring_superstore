package com.phillip_dev.superstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StoreController {

    @GetMapping("/")
    public String getForm() {

        return "form";
    }
    
    
}
