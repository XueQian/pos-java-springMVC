package com.thoughtworks.service.impl;

import com.thoughtworks.dao.ItemDao;
import com.thoughtworks.entity.Item;
import com.thoughtworks.service.ItemService;
import com.thoughtworks.service.PromotionService;

public class ItemServiceImpl implements ItemService {

    private PromotionService promotionService;
    private ItemDao itemDaoImpl;

    public ItemServiceImpl(PromotionService promotionService, ItemDao itemDaoImpl) {
        this.promotionService = promotionService;
        this.itemDaoImpl = itemDaoImpl;
    }

    @Override
    public Item getItem(String barcode) {

        Item item = itemDaoImpl.getItem(barcode);
        item.setPromotions(promotionService.getItemPromotions(barcode));
        return item;
    }

}
