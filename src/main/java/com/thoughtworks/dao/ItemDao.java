package com.thoughtworks.dao;

import com.thoughtworks.entity.Item;
import com.thoughtworks.entity.Promotion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao {

    Item getItem(String barcode);

    List<Promotion> getItemPromotions(String barcode);
}
