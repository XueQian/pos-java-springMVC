package com.thoughtworks.dao;

import com.thoughtworks.entity.Promotion;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PromotionDao {
    Promotion getPromotion(int id);

    Set<String> getPromotionBarcodes();
}
