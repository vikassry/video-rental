package com.twu.refactor;

public enum MoviePricingCategory {
    CHILDREN(1.5,1.5,3),
    REGULAR(2,1.5,2),
    NEW_RELEASE(0,3,0);
    private double upFrontCost;
    private double normalCost;
    private int upFrontValidity;

    MoviePricingCategory(double upFrontCost, double normalCost, int upFrontValidity) {
        this.upFrontCost = upFrontCost;
        this.normalCost = normalCost;
        this.upFrontValidity = upFrontValidity;
    }

    public double getCostFor(int days) {
        double cost = upFrontCost;
        if (days > upFrontValidity)
            cost += (days - upFrontValidity) * normalCost;
        return cost;
    }
}
