package ru.home.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.home.application.dto.ItemDto;

@Service
public class KafkaListenerService {
    private final ItemService itemService;

    @Autowired
    public KafkaListenerService(ItemService itemService) {
        this.itemService = itemService;
    }

    @KafkaListener(
            topics = "${spring.kafka.consumer.topics-title}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void receive(ItemDto itemDto) {
        itemService.save(itemDto);
    }
}
