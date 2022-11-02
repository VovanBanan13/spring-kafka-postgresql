package ru.home.application.mappers;

import org.springframework.stereotype.Component;
import ru.home.application.dto.ItemDto;
import ru.home.application.models.Item;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemMapper {

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
