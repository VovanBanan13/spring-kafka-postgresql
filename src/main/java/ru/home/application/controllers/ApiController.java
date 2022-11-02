package ru.home.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.application.dto.ItemDto;
import ru.home.application.mappers.ItemMapper;
import ru.home.application.models.Item;
import ru.home.application.services.ItemServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ItemServiceImpl itemService;
    private final ItemMapper itemMapper;

    @Autowired
    public ApiController(ItemServiceImpl itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<ItemDto>> getAllItem() {
        List<Item> items = itemService.findAllItems();

        return new ResponseEntity<>(itemMapper.toItemDtos(items), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<List<ItemDto>> createItems(@RequestBody List<Item> items) {
        itemService.save(items);

        return new ResponseEntity<>(itemMapper.toItemDtos(items), HttpStatus.CREATED);
    }

}
