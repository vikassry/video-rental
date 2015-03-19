package com.twu.refactor;

import java.util.List;

public class TextStatement {

    public static String addFooter(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + totalAmount +"\n" +"You earned "
                + frequentRenterPoints +" frequent renter points";
    }

    public static double calculateTotalAmount(List<Rental> rentalList) {
        double total = 0.0;
        for (Rental rental : rentalList) {
            total += rental.getRentalAmount();
        }
        return total;
    }

    public static String statement(Customer customer,List<Rental> rentalList) {
        String result = "Rental Record for " +customer.getName() + "\n";
        for (Rental rental : rentalList){
            double rentalAmount = rental.getRentalAmount();
            result += rental.addFigures(rentalAmount);
        }
        result += addFooter(calculateTotalAmount(rentalList), customer.getTotalRenterPoints(rentalList));
        return result;
    }

}
