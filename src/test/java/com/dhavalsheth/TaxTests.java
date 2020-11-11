package com.dhavalsheth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxTests {
    Tax taxObject = new Tax();

    @BeforeEach
    void setParameters() {
        taxObject.setRoundUp(0.05);
        taxObject.setRate(5);
    }

    @Test
    @DisplayName("rounding disabled")
    void roundingDisabled() {
        taxObject.setRoundUp(0.0);
        assertEquals(taxObject.roundUp(0.34345), 0.34345);
    }

    @Test
    @DisplayName("rounding up to nearest dime")
    void roundingToDime() {
        taxObject.setRoundUp(0.10);
        assertEquals(taxObject.roundUp(0.34), 0.40);
        assertEquals(taxObject.roundUp(0.36), 0.40);
    }

    @ParameterizedTest(name = "round up to nearest nickel {0} = {1}")
    @CsvSource({
            "0.05,   0.05",
            "0.06,   0.10",
            "0.07,   0.10",
            "0.08,   0.10",
            "0.01,   0.05",
            "0.99,   1.00",
    })
    void round(double amount, double expectedResult) {
        assertEquals(expectedResult, taxObject.roundUp(amount),
                () -> amount + " should equal " + expectedResult);
    }

    @ParameterizedTest(name = "tax with rounding up to nickel {0} = {1}")
    @CsvSource({
            "10.05,   0.55",
            "20.06,   1.05",
            "6.07,    0.35",
            "567.08,  28.40",
            "08.01,   0.45",
            "0.99,    0.05"
    })
    void taxFromPrice(double price, double expectedResult) {
        assertEquals(expectedResult, taxObject.calculateTax(price),
                () -> price + " should equal " + expectedResult);
    }

    @ParameterizedTest(name = "sales tax {0} applicable {1} = {2}")
    @CsvSource({
            "10.05, true,   0.55"
    })
    void salesTaxFromSalesItem(double price, boolean flag, double expectedResult) {
        SaleItem item1 = new SaleItem.SaleItemBuilder("box of chocolates")
                .price(price)
                .saleTaxApplicable(flag)
                .importTaxApplicable(false)
                .build();

        assertEquals(expectedResult, taxObject.calculateTax(item1),
                () -> price + " should equal " + expectedResult);
    }

}


