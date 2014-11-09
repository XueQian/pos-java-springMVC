package com.thoughtworks.dao;

import com.thoughtworks.entity.Item;
import com.thoughtworks.entity.Promotion;

import java.util.List;

public interface ItemDao {

    Item getItem(String barcode);

    List<Promotion> getItemPromotions(String barcode);
}
