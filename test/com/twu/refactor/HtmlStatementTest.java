package com.twu.refactor;

import org.junit.Test;

import static org.junit.Assert.*;

public class HtmlStatementTest {

    @Test
    public void testAddFooterReturnsHtmlStringWithGivenValue(){
        HtmlStatement hs = new HtmlStatement();
        String footer = "<P>You owe <EM>32.4</EM><P>On this rental you earned "+
                        "<EM>5</EM> frequent renter points<P>";
        assertEquals(hs.addFooter(32.4,5),footer);
    }

    @Test
    public void testGetStatement(){

    }
}