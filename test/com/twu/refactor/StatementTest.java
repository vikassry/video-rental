package com.twu.refactor;

import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class StatementTest {
    List<Rental> rentalList;
    private Movie py = new Movie("Monty Python and the Holy Grail", MoviePricingCategory.REGULAR);
    private Movie ra = new Movie("Ran", MoviePricingCategory.REGULAR);
    private static final String GOLD_PATH = "test/data";
    private Customer dinsdale = new Customer("Dinsdale Pirhana");

    private Movie python = new Movie("Monty Python and the Holy Grail", MoviePricingCategory.REGULAR);
    private Movie ran = new Movie("Ran", MoviePricingCategory.REGULAR);
    private Movie la = new Movie("LA Confidential", MoviePricingCategory.NEW_RELEASE);
    private Movie trek = new Movie("Star Trek 13.2", MoviePricingCategory.NEW_RELEASE);
    private Movie wallace = new Movie("Wallace and Gromit", MoviePricingCategory.CHILDREN);

    @Before
    public void setUp (){
        dinsdale.addRental(new Rental (python, 3));
        dinsdale.addRental(new Rental (ran, 1));
        dinsdale.addRental(new Rental (la, 2));
        dinsdale.addRental(new Rental (trek, 1));
        dinsdale.addRental(new Rental (wallace, 6));
        rentalList = new ArrayList<Rental>();
        rentalList.add(new Rental(py, 3));
        rentalList.add(new Rental(ra, 1));
    }

    @Test
    public void addFooterReturnsFooterTextWithGivenAmountAndPoints(){
        Statement statement = new Statement();
        String expectedStatement = "Amount owed is 20.0\n" +"You earned 5 frequent renter points";
        assertEquals(expectedStatement, statement.addFooter(20.0, 5));
    }

    @Test
    public void calculateTotalAmountReturnsSumOfRentalsFromGivenRentalList(){
        Statement statement = new Statement();
        assertEquals(statement.calculateTotalAmount(rentalList),5.5,0.0);
    }

    @Test
    public void getHeaderReturnsTheNameOfTheCustomer (){
        Statement statement = new Statement();
        assertEquals(statement.getHeader(dinsdale),"Rental Record for Dinsdale Pirhana\n");
    }

    @Test
    public void getStatementReturnsStringRepresentationOfCustomer() throws IOException {
        Statement statement = new Statement();
        equalsFile("output1", statement.getStatement(dinsdale));
    }

    protected void equalsFile(String fileName, String actualValue) throws IOException {
        BufferedReader file = new BufferedReader (new FileReader (GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader (new StringReader (actualValue));
        String thisFileLine;
        while  ((thisFileLine = file.readLine()) != null) {
            assertEquals ("in file: " + fileName, thisFileLine, actualStream.readLine());
        }
    }
}