package com.dhavalsheth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingBasketTests {
    @Test
    @DisplayName("checkout test with no taxes")
    void checkOutWithNoTaxes() {
        SaleItem item1 = new SaleItem.SaleItemBuilder("book")
                .price(12.49)
                .saleTaxApplicable(false)
                .importTaxApplicable(false)
                .build();
        ArrayList<SaleItem> input1 = new ArrayList<>();
        input1.add(item1);

        ShoppingBasket basket = new ShoppingBasket();
        basket.setItems(input1);
        basket.checkout();

        assertEquals(basket.getTotalTaxes(), 0.0);
    }

    @Test
    @DisplayName("checkout test with sales tax")
    void checkOutWithSalesTaxes() {
        SaleItem item1 = new SaleItem.SaleItemBuilder("book")
                .price(12.49)
                .saleTaxApplicable(true)
                .importTaxApplicable(false)
                .build();
        ArrayList<SaleItem> input1 = new ArrayList<>();
        input1.add(item1);

        ShoppingBasket basket = new ShoppingBasket();
        basket.setItems(input1);
        basket.checkout();
        // 10% of 12.49 is 1.249 and rounding to nearest nickel is 1.25
        assertEquals(basket.getTotalTaxes(), 1.25);
    }

    @Test
    @DisplayName("checkout test with import duty")
    void checkOutWithImportDuty() {
        SaleItem item1 = new SaleItem.SaleItemBuilder("book")
                .price(12.49)
                .saleTaxApplicable(false)
                .importTaxApplicable(true)
                .build();
        ArrayList<SaleItem> input1 = new ArrayList<>();
        input1.add(item1);

        ShoppingBasket basket = new ShoppingBasket();
        basket.setItems(input1);
        basket.checkout();
        // 5% of 12.49 is .62 and rounding up to nearest nickel is .60
        assertEquals(basket.getTotalTaxes(), 0.65);
    }

    @Test
    @DisplayName("checkout test with sales tax & import duty")
    void checkOutWithSalesTaxAndImportDuty() {
        SaleItem item1 = new SaleItem.SaleItemBuilder("book")
                .price(12.49)
                .saleTaxApplicable(true)
                .importTaxApplicable(true)
                .build();
        ArrayList<SaleItem> input1 = new ArrayList<>();
        input1.add(item1);

        ShoppingBasket basket = new ShoppingBasket();
        basket.setItems(input1);
        basket.checkout();

        assertEquals(basket.getTotalTaxes(), 1.90);
    }

    @Test
    @DisplayName("checkout test with multiple items")
    void checkOutMultipleItems() {
        SaleItem item1 = new SaleItem.SaleItemBuilder("book")
                .price(12.49)
                .saleTaxApplicable(false)
                .importTaxApplicable(false)
                .build();
        SaleItem item2 = new SaleItem.SaleItemBuilder("music CD")
                .price(14.99)
                .saleTaxApplicable(true)
                .importTaxApplicable(false)
                .build();
        SaleItem item3 = new SaleItem.SaleItemBuilder("chocolate bar")
                .price(0.85)
                .saleTaxApplicable(false)
                .importTaxApplicable(false)
                .build();
        ArrayList<SaleItem> input1 = new ArrayList<>();
        input1.add(item1);
        input1.add(item2);
        input1.add(item3);

        ShoppingBasket basket = new ShoppingBasket();
        basket.setItems(input1);
        basket.checkout();
        // 5% of 12.49 is .62 and rounding to nearest nickel is .60
        assertEquals(basket.getTotalTaxes(), 1.50);
        assertEquals(basket.getTotalPriceAndTaxes(), 29.83);
    }

}
