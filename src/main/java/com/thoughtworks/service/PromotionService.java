package com.thoughtworks.service;

import com.thoughtworks.entity.Promotion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PromotionService {
    List<Promotion> getItemPromotions(String barcode);
}
