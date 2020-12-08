package com.adventofcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.FileReader;
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
    public void testExamplePartOne() throws Exception {
        var file = getClass().getClassLoader().getResource("inputs.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var set = InstructionSet.parse(reader);
            assertEquals(5, set.findInfiniteLoop());
        }
    }

    public void testProblemPartOne() throws Exception {
        var file = getClass().getClassLoader().getResource("problem.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var set = InstructionSet.parse(reader);
            assertEquals(1337, set.findInfiniteLoop());
        }
    }

    public void testExamplePartTwo() throws Exception {
        var file = getClass().getClassLoader().getResource("inputs.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var set = InstructionSet.parse(reader);
            assertEquals(8, set.repairInstructionSet());
        }
    }

    public void testProblemPartTwo() throws Exception {
        var file = getClass().getClassLoader().getResource("problem.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var set = InstructionSet.parse(reader);
            assertEquals(1358, set.repairInstructionSet());
        }
    }
}
