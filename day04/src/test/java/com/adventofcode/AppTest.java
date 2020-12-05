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
    public void testExamplePartOne() throws IOException {
        var file = getClass().getClassLoader().getResource("inputs.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var passports = PassportParser.Parse(reader);
            assertEquals(2, passports.stream().filter(Passport::isComplete).count());
        }
    }

    public void testProblemPartOne() throws IOException {
        var file = getClass().getClassLoader().getResource("problem.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var passports = PassportParser.Parse(reader);
            assertEquals(202, passports.stream().filter(Passport::isComplete).count());
        }
    }

    public void testExamplePartTwo() throws IOException {
        var file = getClass().getClassLoader().getResource("inputs_parttwo.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var passports = PassportParser.Parse(reader);
            assertEquals(4, passports.stream().filter(Passport::isValid).count());
        }
    }

    public void testProblemPartTwo() throws IOException {
        var file = getClass().getClassLoader().getResource("problem.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var passports = PassportParser.Parse(reader);
            var count = passports.stream().filter(Passport::isValid).count();
            assertEquals(137, count);
        }
    }
}
