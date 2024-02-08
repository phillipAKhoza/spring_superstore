package com.phillip_dev.superstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class StoreController {
    private List<Item> items = new ArrayList<Item>();


    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("item", new Item());
        model.addAttribute("categories", Constatnts.CATEGORIES);
        System.err.println(id);
        return "form";
    }
    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(Item item) {

        items.add(item);

        return "redirect:/inventory";
    }

    public int getIndex(String id){
        for(int x = 0; x <= items.size(); x++){
            if(items.get(x).getId().equals(id)){
                return x;
            }
        }
        
        return Constatnts.NOT_FOUND;
       
    }
    
    
}
