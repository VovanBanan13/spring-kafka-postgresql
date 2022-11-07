package ru.home.application.services;

import ru.home.application.dto.ItemDto;
import ru.home.application.models.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAllItems();
    void save(List<ItemDto> itemDtos);
    void save(ItemDto itemDto);
}
