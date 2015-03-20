package com.twu.refactor;

import java.util.List;

public class HtmlStatement {
    private Statement s = new Statement();
    public String addFooter(double totalAmount, int frequentRenterPoints) {
        return "<P>You owe <EM>"+totalAmount+
                "</EM><P>On this rental you earned <EM>"+
                frequentRenterPoints+"</EM> frequent renter points<P>";
    }
    public String getHeader (Billable customer){
        return "<H1>Rentals for <EM>"+customer.getName()+"</EM></H1><P>";
    }

    public String htmlStatement(Billable customer) {
        String htmlStatement = getHeader(customer);
        List<Rental> rentalList = customer.getRentalList();
        for (Rental rental : rentalList)
            htmlStatement += rental.addFiguresInHtml(rental.getRentalAmount());
        htmlStatement += addFooter(s.calculateTotalAmount(rentalList),
                customer.getTotalRenterPoints(rentalList));
        return htmlStatement;
    }
}
