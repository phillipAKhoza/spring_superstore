package com.phillip_dev.superstore;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.phillip_dev.superstore.service.SuperStoreService;

import jakarta.validation.Valid;



@Controller
public class StoreController {
    
    SuperStoreService superStoreService = new SuperStoreService();


    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
      
        int index = getIndex(id);
        model.addAttribute("item", index == Constatnts.NOT_FOUND ?  new Item(): superStoreService.getItem(index));
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

        int index = getIndex(item.getId());
        String status =Constatnts.SUCCESS_STATUS;
            if(index == Constatnts.NOT_FOUND){
                superStoreService.addItem(item); 
            }else if(within5Days(item.getDate(), superStoreService.getItem(index).getDate())){
                superStoreService.updateItem(index, item);
            }else{
                status = Constatnts.FAILED_STATUS;
            } 
            redirectAttributes.addFlashAttribute("status", status);
    
        
        return "redirect:/inventory";
    }

    public int getIndex(String id){
        if(id != ""){
            for(int x = 0; x < superStoreService.getItems().size(); x++){
                if(superStoreService.getItems().get(x).getId().equals(id)){
                    return x;
                }
            } 
        }
       
        
        return Constatnts.NOT_FOUND;
       
    }
    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

    
    
}
