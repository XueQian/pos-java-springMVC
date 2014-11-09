package com.thoughtworks.util;

import java.math.BigDecimal;

public class DataTransfer {
    public static double transfer(double data) {

        BigDecimal b = new BigDecimal(data);
        return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
