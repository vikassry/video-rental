package com.twu.refactor;

import java.util.ArrayList;

public class Customer {
	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentalList){
            double rentalAmount = rental.getRentalAmount();
            frequentRenterPoints += getFrequentRentalPoints(rental);
            result += rental.addFigures(rentalAmount);
            totalAmount += rentalAmount;
		}
        result += getSummary(totalAmount, frequentRenterPoints);
		return result;
	}

    private int getFrequentRentalPoints(Rental rental) {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        if (isNewRelease(rental) && rental.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private boolean isNewRelease(Rental rental) {
        return (rental.getMovie().getPriceCode() == MoviePricingCategory.NEW_RELEASE);
    }

    private String getSummary(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + String.valueOf(totalAmount) + "\n"
                +"You earned " + String.valueOf(frequentRenterPoints)
                +" frequent renter points";
    }

    public String htmlStatement() {
        double totalAmount = 0.0;
        int extraRentalPoints = 0;
        String htmlStatement = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>";
        for (Rental rental : rentalList){
            extraRentalPoints += getFrequentRentalPoints(rental);
            totalAmount += rental.getRentalAmount();
            htmlStatement += rental.getMovie().getTitle()+": "+
                            rental.getRentalAmount()+ "<BR>";
        }
        htmlStatement += "<P>You owe <EM>"+totalAmount+"</EM>" +
                         "<P>On this rental you earned <EM>"+
                        extraRentalPoints+"</EM> frequent renter points<P>";
        return htmlStatement;
    }
}