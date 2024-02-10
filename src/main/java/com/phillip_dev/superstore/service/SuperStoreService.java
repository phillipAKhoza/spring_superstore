package com.phillip_dev.superstore.service;

import java.util.List;

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
    
}
