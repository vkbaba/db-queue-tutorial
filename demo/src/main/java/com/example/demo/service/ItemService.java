package com.example.demo.service;

import com.example.demo.entities.Item;
import com.example.demo.entities.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    @Cacheable(value = "items", key = "#id")
    public Item getItem(Integer id) {
        Item item = itemRepository.findById(id).orElseThrow(RuntimeException::new);
        logger.info("Loading data from DB {}", item);
        return item;
    }
}
