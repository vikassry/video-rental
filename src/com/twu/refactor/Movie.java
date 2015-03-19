package com.twu.refactor;

public class Movie {
    private String title;
	private MoviePricingCategory priceCode;

	public Movie(String title, MoviePricingCategory priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

    public void setPriceCode(MoviePricingCategory arg) {
    	priceCode = arg;
	}

	public String getTitle () {
		return title;
	}

    public boolean isNewRelease() {
        return (priceCode == MoviePricingCategory.NEW_RELEASE);
    }

    public double getCostFor(int daysRented) {
        return priceCode.getCostFor(daysRented);
    }
}