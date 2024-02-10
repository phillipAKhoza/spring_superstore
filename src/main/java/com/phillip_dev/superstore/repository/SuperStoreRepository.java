package com.phillip_dev.superstore.repository;

import java.util.ArrayList;
import java.util.List;

import com.phillip_dev.superstore.Item;

public class SuperStoreRepository {
    private List<Item> items = new ArrayList<Item>();

    public List<Item> getItems(){
        return items;
    }
    public void addItem(Item item){
        items.add(item);
    }
    public void updateItem(int index, Item item){
        items.set(index, item);
    }
    public Item getItem(int index){
        return  items.get(index);
    }
}
