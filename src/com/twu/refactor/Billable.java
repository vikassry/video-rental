package com.twu.refactor;

import java.util.List;

/**
 * Created by vikass on 3/19/2015.
 */
public interface Billable {
    String getName();

    List<Rental> getRentalList();

    int getTotalRenterPoints(List<Rental> rentalList);
}
