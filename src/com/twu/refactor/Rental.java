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
        return  movie.getCostFor(daysRented);
    }

    public String addFigures(double amount) {
        return "\t"+ getMovie().getTitle()+"\t"+ String.valueOf(amount)+"\n";
    }

    public int getFrequentRentalPoints() {
        int frequentRenterPoints = 1;
        if (movie.isNewRelease() && getDaysRented()> 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}