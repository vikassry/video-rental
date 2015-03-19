package com.twu.refactor;

import java.util.List;

public interface Billable {
    String getName();

    List<Rental> getRentalList();

    int getTotalRenterPoints(List<Rental> rentalList);
}
