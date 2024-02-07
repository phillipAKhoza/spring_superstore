package com.phillip_dev.superstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class StoreController {

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("categories", Constatnts.CATEGORIES);
        return "form";
    }
    @GetMapping("/inventory")
    public String getInventory() {
        
        return "inventory";
    }
    
    
}
