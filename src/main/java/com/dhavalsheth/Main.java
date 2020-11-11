package com.dhavalsheth;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ShoppingBasket basket1 = createBasketOne();
        basket1.checkout();
        System.out.println(basket1.toString());

        ShoppingBasket basket2 = createBasketTwo();
        basket2.checkout();
        System.out.println(basket2.toString());

        ShoppingBasket basket3 = createBasketThree();
        basket3.checkout();
        System.out.println(basket3.toString());
    }

    /**
     * Input 1:
     * 1 book at 12.49
     * 1 music CD at 14.99
     * 1 chocolate bar at 0.85
     *
     * @return Shopping basket
     */
    static ShoppingBasket createBasketOne() {
        SaleItem item1 = new SaleItem.SaleItemBuilder("1 book")
                .price(12.49)
                .saleTaxApplicable(false)
                .importTaxApplicable(false)
                .build();
        SaleItem item2 = new SaleItem.SaleItemBuilder("1 music CD")
                .price(14.99)
                .saleTaxApplicable(true)
                .importTaxApplicable(false)
                .build();
        SaleItem item3 = new SaleItem.SaleItemBuilder("1 chocolate bar")
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
        return basket;
    }

    /**
     * Input 2:
     * 1 imported box of chocolates at 10.00
     * 1 imported bottle of perfume at 47.50
     *
     * @return Shopping basket
     */
    static ShoppingBasket createBasketTwo() {
        SaleItem item1 = new SaleItem.SaleItemBuilder("1 imported box of chocolates")
                .price(10.00)
                .saleTaxApplicable(false)
                .importTaxApplicable(true)
                .build();
        SaleItem item2 = new SaleItem.SaleItemBuilder("1 imported bottle of perfume")
                .price(47.50)
                .saleTaxApplicable(true)
                .importTaxApplicable(true)
                .build();

        ArrayList<SaleItem> input1 = new ArrayList<>();
        input1.add(item1);
        input1.add(item2);

        ShoppingBasket basket = new ShoppingBasket();
        basket.setItems(input1);
        return basket;
    }

    /**
     * Input 3:
     * 1 imported bottle of perfume at 27.99
     * 1 bottle of perfume at 18.99
     * 1 packet of headache pills at 9.75
     * 1 box of imported chocolates at 11.25
     *
     * @return Shopping basket
     */
    static ShoppingBasket createBasketThree() {
        SaleItem item1 = new SaleItem.SaleItemBuilder("1 imported bottle of perfume")
                .price(27.99)
                .saleTaxApplicable(true)
                .importTaxApplicable(true)
                .build();
        SaleItem item2 = new SaleItem.SaleItemBuilder("1 bottle of perfume")
                .price(18.99)
                .saleTaxApplicable(true)
                .importTaxApplicable(false)
                .build();
        SaleItem item3 = new SaleItem.SaleItemBuilder("1 packet of headache pills")
                .price(9.75)
                .saleTaxApplicable(false)
                .importTaxApplicable(false)
                .build();
        SaleItem item4 = new SaleItem.SaleItemBuilder("1 box of imported chocolates")
                .price(11.25)
                .saleTaxApplicable(false)
                .importTaxApplicable(true)
                .build();
        ArrayList<SaleItem> input1 = new ArrayList<>();
        input1.add(item1);
        input1.add(item2);
        input1.add(item3);
        input1.add(item4);
        ShoppingBasket basket = new ShoppingBasket();
        basket.setItems(input1);
        return basket;
    }

}
