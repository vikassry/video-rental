package com.twu.refactor;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentalList.add(rental);
	}

	public String getName() {
		return name;
	}

    public double calculateTotalAmount() {
        double total = 0.0;
        for (Rental rental : rentalList) {
            total += rental.getRentalAmount();
        }
        return total;
    }

	public String statement() {
		String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentalList){
            double rentalAmount = rental.getRentalAmount();
            result += rental.addFigures(rentalAmount);
		}
        result += addFooter(calculateTotalAmount(), getTotalRenterPoints(rentalList));
		return result;
	}

    public int getTotalRenterPoints(List<Rental> rentalList) {
        int frequentRenterPoints = 0;
        for (Rental rental : rentalList)
            frequentRenterPoints += rental.getFrequentRentalPoints();
        return frequentRenterPoints;
    }

    private String addFooter(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + totalAmount +"\n" +"You earned "
                + frequentRenterPoints +" frequent renter points";
    }

    public String htmlStatement() {
        double totalAmount = 0.0;
        int extraRentalPoints = 0;
        String htmlStatement = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>";
        for (Rental rental : rentalList){
            extraRentalPoints += rental.getFrequentRentalPoints();
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