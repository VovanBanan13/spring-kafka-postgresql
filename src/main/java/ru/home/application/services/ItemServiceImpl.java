package ru.home.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.home.application.dto.ItemDto;
import ru.home.application.exceptions.ObjectNotFound;
import ru.home.application.models.Item;
import ru.home.application.repositories.ItemRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

//    private final KafkaTemplate<Integer, ItemDto> kafkaItemTemplate;
    private final ObjectMapper objectMapper;
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(
//            KafkaTemplate<Integer, ItemDto> kafkaItemTemplate,
            ObjectMapper objectMapper,
            ItemRepository itemRepository
    ) {
//        this.kafkaItemTemplate = kafkaItemTemplate;
        this.objectMapper = objectMapper;
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> findAllItems() {
        List<Item> items = itemRepository.findAll();
        if(items.isEmpty()) {
            throw new ObjectNotFound();
        } else
            return items;
    }

    @Override
    public void save(List<Item> items) {
        this.itemRepository.saveAll(items);
    }

    @Override
    public void consume(ItemDto itemDto) {

    }

    @Override
    public void consume(List<ItemDto> itemDtos) {

    }

}
