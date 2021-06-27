package com.example.demo.service;

import com.example.demo.entities.Item;
import com.example.demo.entities.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

}
