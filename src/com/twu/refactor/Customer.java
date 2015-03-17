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
            double rentalAmount = rental.getAmount();
            frequentRenterPoints += addFrequentRentalPoints(rental);
            result += addFigures(rentalAmount, rental);
            totalAmount += rentalAmount;
		}
        result += getSummary(totalAmount, frequentRenterPoints);
		return result;
	}

    private int addFrequentRentalPoints(Rental rental) {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)&& rental.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private String addFigures(double thisAmount, Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t"
                + String.valueOf(thisAmount) + "\n";
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
            extraRentalPoints += addFrequentRentalPoints(rental);
            totalAmount += rental.getAmount();
            htmlStatement += rental.getMovie().getTitle()+": "+
                            rental.getAmount()+ "<BR>";
        }
        htmlStatement += "<P>You owe <EM>"+totalAmount+"</EM>" +
                         "<P>On this rental you earned <EM>"+
                        extraRentalPoints+"</EM> frequent renter points<P>";
        return htmlStatement;
    }
}