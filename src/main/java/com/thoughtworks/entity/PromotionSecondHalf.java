package com.thoughtworks.entity;

public class PromotionSecondHalf extends Promotion {
    @Override
    public double calculate(CartItem cartItem) {
        return cartItem.getCount() * cartItem.getItem().getPrice() - (int) (cartItem.getCount() / 3) * cartItem.getItem().getPrice() / 2;
    }
}
