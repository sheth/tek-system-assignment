package com.dhavalsheth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaleItemTests {
    @Test
    @DisplayName("SaleItemBuilder price check")
    void priceCheck() {
        double price = 10.00;
        SaleItem item1 = new SaleItem.SaleItemBuilder("box of chocolates")
                .price(price)
                .saleTaxApplicable(false)
                .importTaxApplicable(false)
                .build();

        assertEquals(item1.getPrice(), price);
    }

    @Test
    @DisplayName("SaleItemBuilder salesTaxApplicable check")
    void salesTaxApplicableCheck() {
        final double price = 10.00;
        final boolean flag = true;
        SaleItem item1 = new SaleItem.SaleItemBuilder("box of chocolates")
                .price(price)
                .saleTaxApplicable(flag)
                .importTaxApplicable(false)
                .build();

        assertEquals(item1.isSalesTaxApplicable(), flag);
    }

    @Test
    @DisplayName("SaleItemBuilder importTaxApplicable check")
    void importTaxApplicableCheck() {
        final double price = 10.00;
        final boolean flag = true;
        SaleItem item1 = new SaleItem.SaleItemBuilder("box of chocolates")
                .price(price)
                .saleTaxApplicable(false)
                .importTaxApplicable(flag)
                .build();

        assertEquals(item1.isImportTaxApplicable(), flag);
    }
}

