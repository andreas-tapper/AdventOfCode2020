package com.adventofcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

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
    public void testAppPartOne() throws IOException {
        var file = getClass().getClassLoader().getResource("inputs.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var matches = reader.lines()
                    .map(PasswordAndPolicy::withSledRentalPolicy)
                    .filter(PasswordAndPolicy::match)
                    .count();

            assertEquals(2, matches);
        }
    }

    public void testAppPartTwo() throws IOException {
        var file = getClass().getClassLoader().getResource("inputs.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var matches = reader.lines()
                    .map(PasswordAndPolicy::withTobogganCorporate)
                    .filter(PasswordAndPolicy::match)
                    .count();

            assertEquals(1, matches);
        }
    }

    public void testProblem() throws IOException {
        var file = getClass().getClassLoader().getResource("problem.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var matches = reader.lines()
                    .map(PasswordAndPolicy::withTobogganCorporate)
                    .filter(PasswordAndPolicy::match)
                    .count();

            assertEquals(263, matches);
        }
    }
}
