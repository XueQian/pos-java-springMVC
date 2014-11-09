package com.thoughtworks.service;

import com.thoughtworks.entity.Item;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    Item getItem(String barcode);
}
