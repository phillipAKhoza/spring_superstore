package com.phillip_dev.superstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class StoreController {
    private List<Item> items = new ArrayList<Item>();


    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
      
        int index = getIndex(id);
        model.addAttribute("item", index == Constatnts.NOT_FOUND ?  new Item(): items.get(index));
        model.addAttribute("categories", Constatnts.CATEGORIES);
        return "form";
    }
    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(Item item, RedirectAttributes redirectAttributes) {
        int index = getIndex(item.getId());
        if(index == Constatnts.NOT_FOUND){
           items.add(item); 
        }else{
            items.set(index, item);
        }
        redirectAttributes.addFlashAttribute("status", Constatnts.SUCCESS_STATUS);
        return "redirect:/inventory";
    }

    public int getIndex(String id){
        if(id != ""){
            for(int x = 0; x < items.size(); x++){
                if(items.get(x).getId().equals(id)){
                    return x;
                }
            } 
        }
       
        
        return Constatnts.NOT_FOUND;
       
    }
    
    
}
