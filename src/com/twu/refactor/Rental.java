package com.twu.refactor;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getRentalAmount() {
        return  movie.getPriceCode().getCostFor(daysRented);
    }

    public String addFigures(double thisAmount) {
        return "\t" + getMovie().getTitle() + "\t"
                + String.valueOf(thisAmount) + "\n";
    }

    public boolean isNewRelease() {
        return (movie.getPriceCode() == MoviePricingCategory.NEW_RELEASE);
    }

    public int getFrequentRentalPoints() {
        int frequentRenterPoints = 1;
        if (isNewRelease() && getDaysRented()> 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}