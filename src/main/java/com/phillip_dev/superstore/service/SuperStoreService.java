package com.phillip_dev.superstore.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.phillip_dev.superstore.Constatnts;
import com.phillip_dev.superstore.Item;
import com.phillip_dev.superstore.repository.SuperStoreRepository;

public class SuperStoreService {
    SuperStoreRepository superStoreRepository = new SuperStoreRepository();
    public List<Item> getItems(){
        return superStoreRepository.getItems();
    }
    // Create
    public void addItem(Item item){
        superStoreRepository.addItem(item);;
    }
    // Update
    public void updateItem(int index, Item item){
        superStoreRepository.updateItem(index, item);
    }
    // Read
    public Item getItem(int index){
        return superStoreRepository.getItem(index);
    }
    public int getIndex(String id){
        if(id != ""){
            for(int x = 0; x < getItems().size(); x++){
                if(getItems().get(x).getId().equals(id)){
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
    public Item getItemById(String id){
        int index = getIndex(id);
        return index == Constatnts.NOT_FOUND ?  new Item(): getItem(index);
    }
    public String submitItem(Item item){
        int index = getIndex(item.getId());
        String status =Constatnts.SUCCESS_STATUS;
            if(index == Constatnts.NOT_FOUND){
                addItem(item); 
            }else if(within5Days(item.getDate(), getItem(index).getDate())){
                updateItem(index, item);
            }else{
                status = Constatnts.FAILED_STATUS;
            } 
            return status;
    }
    
}
