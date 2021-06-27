package com.example.demo.controller;

import static com.example.demo.config.RabbitMQConfig.EXAMPLE_QUEUE;

import com.example.demo.entities.Item;
import com.example.demo.service.ItemService;
import org.springframework.web.bind.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RestController
@RequestMapping(path = "/items/")
public class ItemController {

    private final ItemService itemService;
    private final RabbitTemplate rabbitTemplate;

    public ItemController(ItemService itemService, RabbitTemplate rabbitTemplate) {
        this.itemService = itemService;
        this.rabbitTemplate = rabbitTemplate;
    }
    
    @GetMapping("/{id}")
    public Item getItem(@PathVariable Integer id) {
        return itemService.getItem(id);
    }
    @PostMapping("/")
    public void queueItem(@RequestBody Item request) {
        rabbitTemplate.convertAndSend(EXAMPLE_QUEUE, request);
    }
}
