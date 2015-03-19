package com.twu.refactor;

import java.util.List;

public class Statement {

    public String addFooter(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + totalAmount +"\n" +"You earned "
                + frequentRenterPoints +" frequent renter points";
    }

    public double calculateTotalAmount(List<Rental> rentalList) {
        double total = 0.0;
        for (Rental rental : rentalList) {
            total += rental.getRentalAmount();
        }
        return total;
    }

    public String getHeader (Billable customer){
        return "Rental Record for " +customer.getName() + "\n";
    }

    public String getStatement(Billable customer, List<Rental> rentalList) {
        String result = getHeader(customer);
        for (Rental rental : rentalList){
            double rentalAmount = rental.getRentalAmount();
            result += rental.addFigures(rentalAmount);
        }
        result += addFooter(calculateTotalAmount(rentalList), customer.getTotalRenterPoints(rentalList));
        return result;
    }

}
