package ru.home.application.services;

import ru.home.application.models.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAllItems();
    void save(List<Item> items);
}
