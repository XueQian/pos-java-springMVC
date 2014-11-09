package com.thoughtworks.service.impl;

import com.thoughtworks.dao.ItemDao;
import com.thoughtworks.dao.PromotionDao;
import com.thoughtworks.entity.Promotion;
import com.thoughtworks.service.PromotionService;

import java.util.List;

public class PromotionServiceImpl implements PromotionService {

    private PromotionDao promotionDaoImpl;
    private ItemDao itemDaoImpl;

    public PromotionServiceImpl(PromotionDao promotionDaoImpl, ItemDao itemDaoImpl) {
        this.promotionDaoImpl = promotionDaoImpl;
        this.itemDaoImpl = itemDaoImpl;
    }

    @Override
    public List<Promotion> getItemPromotions(String barcode) {

        if (promotionDaoImpl.getPromotionBarcodes().contains(barcode)) {
            return itemDaoImpl.getItemPromotions(barcode);
        } else {
            return null;
        }
    }
}
