package ru.home.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.home.application.dto.ItemDto;
import ru.home.application.exceptions.ObjectNotFound;
import ru.home.application.mappers.ItemMapper;
import ru.home.application.models.Item;
import ru.home.application.repositories.ItemRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(
            ItemRepository itemRepository,
            ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
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
    public void save(ItemDto itemDto) {
        Item item = itemMapper.toItem(itemDto);
        this.itemRepository.save(item);
    }

    @Override
    public void save(List<ItemDto> itemDtos) {
        List<Item> items = itemMapper.toItems(itemDtos);
        this.itemRepository.saveAll(items);
    }
}
