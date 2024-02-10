package com.phillip_dev.superstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;



@Controller
public class StoreController {
    private List<Item> items = new ArrayList<Item>();


    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
      
        int index = getIndex(id);
        model.addAttribute("item", index == Constatnts.NOT_FOUND ?  new Item(): items.get(index));
        return "form";
    }
    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", items);
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid Item item, BindingResult result, RedirectAttributes redirectAttributes) {
        if(item.getDiscount() >= item.getPrice()) result.rejectValue("discount", "", "Discount cannot be more than price");
        if(result.hasErrors()) return "form";

        int index = getIndex(item.getId());
        String status =Constatnts.SUCCESS_STATUS;
            if(index == Constatnts.NOT_FOUND){
                items.add(item); 
            }else if(within5Days(item.getDate(), items.get(index).getDate())){
                items.set(index, item);
            }else{
                status = Constatnts.FAILED_STATUS;
            } 
            redirectAttributes.addFlashAttribute("status", status);
    
        
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
    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

    
    
}
