package com.thoughtworks.service.impl;

import com.thoughtworks.dao.ItemDao;
import com.thoughtworks.dao.PromotionDao;
import com.thoughtworks.entity.Promotion;
import com.thoughtworks.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    public PromotionServiceImpl() {

    }

    @Autowired
    private PromotionDao promotionDaoImpl;
    @Autowired
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
