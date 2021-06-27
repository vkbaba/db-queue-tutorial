package com.example.demo.event;

import com.example.demo.entities.Item;
import com.example.demo.service.ItemService;
import com.example.demo.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class ItemEventConsumer {

    private final ItemService itemService;

    public ItemEventConsumer(ItemService itemService) {
        this.itemService = itemService;
    }

    @RabbitListener(queues = RabbitMQConfig.EXAMPLE_QUEUE)
    public void createItem(Item request, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        System.out.println("Message received!");
        itemService.createItem(request);
    }

}
