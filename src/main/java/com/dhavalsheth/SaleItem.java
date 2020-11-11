package com.dhavalsheth;

import java.io.PrintStream;

public class SaleItem {

    private final String name;
    private final double price;
    private final boolean salesTaxApplicable;
    private final boolean importTaxApplicable;
    private double pricePlusTax;

    private SaleItem (SaleItemBuilder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.salesTaxApplicable = builder.salesTaxApplicable;
        this.importTaxApplicable = builder.importTaxApplicable;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public boolean isSalesTaxApplicable() { return salesTaxApplicable;}
    public boolean isImportTaxApplicable() { return importTaxApplicable;}
    public double getPricePlusTax() { return pricePlusTax;}

    public void setPricePlusTax(double pricePlusTax) {
        // to round up to second decimal point we multiply by 100, do Math.round() and divide it back by 100.0.
        this.pricePlusTax = Math.round(pricePlusTax * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f\n", this.getName(), this.getPricePlusTax());
    }

    public static class SaleItemBuilder
    {
        private final String name;
        private double price;
        private boolean salesTaxApplicable;
        private boolean importTaxApplicable;

        public SaleItemBuilder(String name) {
            this.name = name;
        }
        public SaleItem.SaleItemBuilder price(double price) {
            this.price = price;
            return this;
        }
        public SaleItem.SaleItemBuilder saleTaxApplicable(boolean flag) {
            this.salesTaxApplicable = flag;
            return this;
        }

        public SaleItem.SaleItemBuilder importTaxApplicable(boolean flag) {
            this.importTaxApplicable = flag;
            return this;
        }
        //Return the finally constructed SalesItem object
        public SaleItem build() {
            SaleItem item =  new SaleItem(this);
            return item;
        }
    }
}