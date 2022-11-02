package ru.home.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.home.application.exceptions.ObjectNotFound;
import ru.home.application.models.Item;
import ru.home.application.repositories.ItemRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(
            ItemRepository itemRepository) {
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

}
