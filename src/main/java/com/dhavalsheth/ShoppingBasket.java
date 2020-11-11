package com.dhavalsheth;

import java.util.ArrayList;

public class ShoppingBasket {
    ArrayList<SaleItem> items;

    Tax salesTax = new Tax(10.0, 0.05);
    Tax importDuty = new Tax(5.0, 0.05);

    double totalTaxes;
    double totalPriceAndTaxes;

    void checkout() {
        double totalTaxForShoppingBasket = 0;
        double totalAmountForShoppingBasket = 0;
        for (SaleItem n : items) {
            double salesTaxAmount = 0.0;
            double importDutyAmount = 0.0;
            double price = n.getPrice();
            if (n.isSalesTaxApplicable()) {
                salesTaxAmount = salesTax.calculateTax(price);
                totalTaxForShoppingBasket += salesTaxAmount;
            }
            if (n.isImportTaxApplicable()) {
                importDutyAmount = importDuty.calculateTax(price);
                totalTaxForShoppingBasket += importDutyAmount;
            }
            double pricePlusTaxAmount = price + salesTaxAmount + importDutyAmount;
            n.setPricePlusTax(pricePlusTaxAmount);
            totalAmountForShoppingBasket += pricePlusTaxAmount;
        }
        this.setTotalTaxes(totalTaxForShoppingBasket);
        this.setTotalPriceAndTaxes(totalAmountForShoppingBasket);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        items.forEach(each -> builder.append(each.toString()));
        builder.append(String.format("Sales Taxes: %.2f Total: %.2f\n", this.totalTaxes, this.totalPriceAndTaxes));
        return builder.toString();
    }

    public void setItems(ArrayList<SaleItem> items) {
        this.items = items;
    }

    public double getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(double totalTaxes) {
        this.totalTaxes = Math.round(totalTaxes * 100.0) / 100.0;
    }

    public double getTotalPriceAndTaxes() {
        return totalPriceAndTaxes;
    }

    public void setTotalPriceAndTaxes(double totalPriceAndTaxes) {
        this.totalPriceAndTaxes = Math.round(totalPriceAndTaxes * 100.0) / 100.0;
    }
}
