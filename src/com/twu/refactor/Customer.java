package com.twu.refactor;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Billable {
	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentalList.add(rental);
	}

	@Override
    public String getName() {
		return name;
	}

    @Override
    public List<Rental> getRentalList(){
        return rentalList;
    }
    @Override
    public int getTotalRenterPoints(List<Rental> rentalList) {
        int frequentRenterPoints = 0;
        for (Rental rental : rentalList)
            frequentRenterPoints += rental.getFrequentRentalPoints();
        return frequentRenterPoints;
    }
}