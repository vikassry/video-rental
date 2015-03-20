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

    public String getStatement(Billable customer) {
        String result = getHeader(customer);
        List<Rental> rentalList = customer.getRentalList();
        for (Rental rental : rentalList)
            result += rental.addFiguresInText(rental.getRentalAmount());
        result += addFooter(calculateTotalAmount(rentalList), customer.getTotalRenterPoints(rentalList));
        return result;
    }
}

