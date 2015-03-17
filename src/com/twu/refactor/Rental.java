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

    double getAmount() {
        double amount = 0.0;
        switch (movie.getPriceCode()) {
        case Movie.REGULAR:
            amount += 2;
            if (getDaysRented() > 2)
                amount += (getDaysRented() - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE:
            amount += getDaysRented() * 3;
            break;
        case Movie.CHILDREN:
            amount += 1.5;
            if (getDaysRented() > 3)
                amount += (getDaysRented() - 3) * 1.5;
            break;
        }
        return amount;
    }
}