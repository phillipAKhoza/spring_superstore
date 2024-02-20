package com.phillip_dev.superstore.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.phillip_dev.superstore.Item;

@Repository
public class SuperStoreRepository {
    private List<Item> items = new ArrayList<Item>();
    // Read
    public List<Item> getItems(){
        return items;
    }
    // Create
    public void addItem(Item item){
        items.add(item);
    }
    // Update
    public void updateItem(int index, Item item){
        items.set(index, item);
    }
    // Read
    public Item getItem(int index){
        return  items.get(index);
    }
}
