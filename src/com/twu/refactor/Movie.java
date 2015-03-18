package com.twu.refactor;

public class Movie {
    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;
    private String title;
	private MoviePricingCategory priceCode;

	public Movie(String title, MoviePricingCategory priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}
	public MoviePricingCategory getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(MoviePricingCategory arg) {
    	priceCode = arg;
	}

	public String getTitle () {
		return title;
	}
}