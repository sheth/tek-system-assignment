package com.dhavalsheth;

public final class Tax {
    double rate; // in percentage
    double roundUp; // 0.05 for rounding up to a nickel

    public Tax() {
        this.rate = 0.0;
        this.roundUp = 0.0;
    }

    public Tax(double rate, double roundUp) {
        this.rate = rate;
        this.roundUp = roundUp;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getRoundUp() {
        return roundUp;
    }

    public void setRoundUp(double roundUp) {
        this.roundUp = roundUp;
    }

    public double calculateTax(SaleItem item) {
        return calculateTax(item.getPrice());
    }

    /**
     * Given a price, will calculate the sales tax and then round up to nearest nickel or dime as case maybe.
     * For example for $100 price the sales tax is $5 if rate is 5%.
     * @param price The value of SaleItem
     * @return sales tax calculated.
     */
    double calculateTax(double price) {
        double tax = (price * this.rate) / 100;
        return round(tax);
    }

    double round(double amount) {
        if ( this.roundUp == 0) {
            return amount;
        }
        double reciprocal = 1/ this.roundUp;
        return Math.ceil(amount * reciprocal) / reciprocal;
    }
}
