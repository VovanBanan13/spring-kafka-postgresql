package ru.home.application.mappers;

import org.springframework.stereotype.Component;
import ru.home.application.dto.ItemDto;
import ru.home.application.models.Item;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemMapper {

    public Item toItem(ItemDto itemDto) {
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setFirstName(itemDto.getFirstName());
        item.setLastName(itemDto.getLastName());

        return item;
    }

    public List<Item> toItems(List<ItemDto> itemDtos) {
        List<Item> items = new ArrayList<>();
        for (ItemDto itemDto : itemDtos) {
            Item item = new Item();
            item.setId(itemDto.getId());
            item.setFirstName(itemDto.getFirstName());
            item.setLastName(itemDto.getLastName());
            items.add(item);
        }
        return items;
    }

    public List<ItemDto> toItemDtos(List<Item> items) {
        List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : items) {
            ItemDto itemDto = new ItemDto();
            itemDto.setId(item.getId());
            itemDto.setFirstName(item.getFirstName());
            itemDto.setLastName(item.getLastName());
            itemDtos.add(itemDto);
        }
        return itemDtos;
    }
}
