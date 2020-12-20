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
            var program = DockingProgram.parse(reader);
            assertEquals(165, program.run());
        }
    }

    public void testProblemPartOne() throws Exception {
        var file = getClass().getClassLoader().getResource("problem.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var program = DockingProgram.parse(reader);
            assertEquals(11926135976176L, program.run());
        }
    }

    public void testExamplePartTwo() throws Exception {
        var file = getClass().getClassLoader().getResource("inputs-parttwo.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var program = DockingProgram.parse(reader);
            assertEquals(208L, program.runWithFloatingMemory());
        }
    }

    public void testProblemPartTwo() throws Exception {
        var file = getClass().getClassLoader().getResource("problem.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var program = DockingProgram.parse(reader);
            assertEquals(4330547254348L, program.runWithFloatingMemory());
        }
    }
}
