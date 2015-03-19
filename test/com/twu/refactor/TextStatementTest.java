package com.twu.refactor;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TextStatementTest {
    List<Rental> rentalList;
    private Movie python = new Movie("Monty Python and the Holy Grail", MoviePricingCategory.REGULAR);
    private Movie ran = new Movie("Ran", MoviePricingCategory.REGULAR);
    @Before
    public void setUp (){
        rentalList = new ArrayList<Rental>();
        rentalList.add(new Rental(python, 3));
        rentalList.add(new Rental(ran, 1));
    }

    @Test
    public void addFooterReturnsFooterTextWithGivenAmountAndPoints(){
        String expectedStatement = "Amount owed is 20.0\n" +"You earned 5 frequent renter points";
        assertEquals(expectedStatement,TextStatement.addFooter(20.0,5));
    }

    @Test
    public void calculateTotalAmountReturnsSumOfRentalsFromGivenRentalList(){
        assertEquals(TextStatement.calculateTotalAmount(rentalList),5.5,0.0);
    }


}