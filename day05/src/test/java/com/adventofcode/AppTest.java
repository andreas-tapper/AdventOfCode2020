package com.adventofcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import static java.util.stream.Collectors.toList;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testExamplePartOne() throws Exception {
        var example1 = Seat.of("BFFFBBFRRR");
        assertEquals(70, example1.getRow());
        assertEquals(7, example1.getColumn());
        assertEquals(567, example1.getId());

        var example2 = Seat.of("FFFBBBFRRR");
        assertEquals(14, example2.getRow());
        assertEquals(7, example2.getColumn());
        assertEquals(119, example2.getId());

        var example3 = Seat.of("BBFFBBFRLL");
        assertEquals(102, example3.getRow());
        assertEquals(4, example3.getColumn());
        assertEquals(820, example3.getId());

        var example4 = Seat.of("FBFBBFFRLR");
        assertEquals(44, example4.getRow());
        assertEquals(5, example4.getColumn());
        assertEquals(357, example4.getId());
    }

    public void testProblemPartOne() throws Exception {
        var file = getClass().getClassLoader().getResource("problem.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var maxId = reader.lines()
                    .map(Seat::of)
                    .map(Seat::getId)
                    .max(Integer::compareTo);
            assertEquals(938, (int)maxId.orElse(-1));
        }
    }

    public void testProblemPartTwo() throws IOException {
        var file = getClass().getClassLoader().getResource("problem.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var seats = reader.lines()
                    .map(Seat::of)
                    .collect(toList());
            var maxRow = seats.stream()
                    .map(Seat::getRow)
                    .max(Integer::compareTo)
                    .orElse(Integer.MAX_VALUE);
            var minRow = seats.stream()
                    .map(Seat::getRow)
                    .min(Integer::compareTo)
                    .orElse(Integer.MIN_VALUE);

            var searchSpace = seats.stream()
                    .filter(x -> x.getRow() > minRow && x.getRow() < maxRow)
                    .map(Seat::getId)
                    .sorted()
                    .collect(toList());

            var id = 0;
            for(var i=1; i < searchSpace.size(); i += 1) {
                var below = searchSpace.get(i - 1);
                var above = searchSpace.get(i);

                if(above - below == 2) {
                    id = searchSpace.get(i) - 1;
                    break;
                }
            }

            assertEquals(696, id);
        }
    }
}
