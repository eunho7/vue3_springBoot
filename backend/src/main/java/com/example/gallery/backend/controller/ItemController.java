package com.example.gallery.backend.controller;

import com.example.gallery.backend.entity.Item;
import com.example.gallery.backend.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/api/items")
    public List<Item> getItems() {
        List<Item> items = itemService.findAll();

        return items;
    }
}
