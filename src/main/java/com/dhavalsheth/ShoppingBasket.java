package com.dhavalsheth;

import java.io.PrintStream;
import java.util.ArrayList;

public class ShoppingBasket {
    ArrayList<SaleItem> items;

    Tax salesTax = new Tax(10.0, 0.05);
    Tax importDuty = new Tax(5.0, 0.05);

    double totalTaxes;

    double totalPriceAndTaxes;
    /**
    void calculateTotalTaxes() {
        double totalTax = items.stream().map(n -> {
            double salesTaxAmount = 0.0;
            double importDutyAmount = 0.0;
            double price = n.getPrice();

            if (n.isSalesTaxApplicable()) {
                salesTaxAmount = salesTax.calculateTax(n.getPrice());
            }

            if(n.isImportTaxApplicable()) {
                importDutyAmount = importDuty.calculateTax(n.getPrice());
            }

            double pricePlusTaxAmount = price + salesTaxAmount + importDutyAmount;
            n.setPricePlusTax(pricePlusTaxAmount);
            return salesTaxAmount + importDutyAmount;
        }).reduce(0.0, Double::sum);
        this.setTotalTaxes(totalTax);

        double totalAmount = items.stream().map(n -> {
            return n.getPricePlusTax();
        }).reduce(0.0, Double::sum);
        this.setTotalPriceAndTaxes(totalAmount);
    }**/

    void checkout() {
        double totalTax = 0;
        double totalAmount = 0;
        for(SaleItem n: items) {
            double salesTaxAmount = 0.0;
            double importDutyAmount = 0.0;
            double price = n.getPrice();
            if (n.isSalesTaxApplicable()) {
                salesTaxAmount = salesTax.calculateTax(price);
                totalTax += salesTaxAmount;
            }
            if(n.isImportTaxApplicable()) {
                importDutyAmount = importDuty.calculateTax(price);
                totalTax += importDutyAmount;
            }
            double pricePlusTaxAmount = price + salesTaxAmount + importDutyAmount;
            n.setPricePlusTax(pricePlusTaxAmount);
            totalAmount += pricePlusTaxAmount;
        }
        this.setTotalTaxes(totalTax);
        this.setTotalPriceAndTaxes(totalAmount);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        items.forEach(each -> builder.append(each.toString()));
        builder.append(String.format("Sales Taxes: %.2f Total: %.2f\n", this.totalTaxes, this.totalPriceAndTaxes));
        return builder.toString();
    }

    public ArrayList<SaleItem> getItems() {
        return items;
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
