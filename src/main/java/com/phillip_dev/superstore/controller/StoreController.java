package com.phillip_dev.superstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phillip_dev.superstore.Item;
import com.phillip_dev.superstore.service.SuperStoreService;

import jakarta.validation.Valid;



@Controller
public class StoreController {
    // @Autowired
    SuperStoreService superStoreService;
    public StoreController(SuperStoreService superStoreService){
        this.superStoreService = superStoreService;
    }

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("item", superStoreService.getItemById(id));
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", superStoreService.getItems());
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid Item item, BindingResult result, RedirectAttributes redirectAttributes) {
        if(item.getDiscount() >= item.getPrice()) result.rejectValue("discount", "", "Discount cannot be more than price");
        if(result.hasErrors()) return "form";

        String status = superStoreService.submitItem(item);
        redirectAttributes.addFlashAttribute("status", status);
     
        return "redirect:/inventory";
    }

    


}
