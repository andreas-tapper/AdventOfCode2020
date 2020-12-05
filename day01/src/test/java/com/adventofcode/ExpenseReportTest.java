package com.adventofcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class ExpenseReportTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ExpenseReportTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ExpenseReportTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testReportPartOne()
    {
        var report = new ExpenseReport(List.of(1721, 979, 366, 299, 675, 1456));

        assertEquals(514579, report.getResultPartOne());
    }

    public void testReportPartTwo()
    {
        var report = new ExpenseReport(List.of(1721, 979, 366, 299, 675, 1456));

        assertEquals(241861950, report.getResultPartTwo());
    }
}
