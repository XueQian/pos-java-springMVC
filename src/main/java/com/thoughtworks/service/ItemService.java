package com.thoughtworks.service;

import com.thoughtworks.entity.Item;

public interface ItemService {

    Item getItem(String barcode);
}
