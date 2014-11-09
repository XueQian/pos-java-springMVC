package com.thoughtworks.service;

import com.thoughtworks.entity.Promotion;

import java.util.List;

public interface PromotionService {
    List<Promotion> getItemPromotions(String barcode);
}
