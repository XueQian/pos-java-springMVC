package com.thoughtworks.dao;

import com.thoughtworks.entity.Promotion;

import java.util.Set;

public interface PromotionDao {
    Promotion getPromotion(int id);

    Set<String> getPromotionBarcodes();
}
