package com.twu.refactor;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MoviePricingCategoryTest extends TestCase {
    @Test
    public void testGetCostForReturnsCostFor4DaysRentedForChildren(){
        assertEquals(MoviePricingCategory.CHILDREN.getCostFor(4),3.0,0.0);
    }
    @Test
    public void testGetCostForReturnsSameCostForDaysRentedLessThan3ForChildren(){
        assertEquals(MoviePricingCategory.CHILDREN.getCostFor(1),1.5,0.0);
        assertEquals(MoviePricingCategory.CHILDREN.getCostFor(2),1.5,0.0);
    }
    @Test
    public void testGetCostForReturnsSameCostForDaysRentedForNewRelease(){
        assertEquals(MoviePricingCategory.NEW_RELEASE.getCostFor(1),3.0,0.0);
        assertEquals(MoviePricingCategory.NEW_RELEASE.getCostFor(5),15.0,0.0);
    }
    @Test
    public void testGetCostForReturns2ForDaysRentedLessThan2ForRegular(){
        assertEquals(MoviePricingCategory.REGULAR.getCostFor(1),2.0,0.0);
        assertEquals(MoviePricingCategory.REGULAR.getCostFor(2),2.0,0.0);
    }
    @Test
    public void testGetCostForReturns3ForDaysRentedFor4DaysForRegular(){
        assertEquals(MoviePricingCategory.REGULAR.getCostFor(4),5.0,0.0);
        assertEquals(MoviePricingCategory.REGULAR.getCostFor(3),3.5,0.0);
    }
}