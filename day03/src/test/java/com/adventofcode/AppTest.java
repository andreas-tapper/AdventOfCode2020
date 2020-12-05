package com.adventofcode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

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
    public void testApp() throws IOException {
        var file = getClass().getClassLoader().getResource("inputs.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var map = TravelMap.of(reader);
            assertEquals(7, map.countTrees());
        }
    }

    public void testProblemPartOne() throws IOException {
        var file = getClass().getClassLoader().getResource("problem.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var map = TravelMap.of(reader);
            assertEquals(280, map.countTrees());
        }
    }

    public void testMaps() throws IOException {
        var file = getClass().getClassLoader().getResource("problem.txt").getFile();
        TravelMap map1;
        SecondTravelMap map2;
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            map1 = TravelMap.of(reader);
        }
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            map2 = SecondTravelMap.of(reader);
        }
        assertEquals(map1.countTrees(), map2.countTrees(3, 1));
    }

    public void testExamplePartTwo() throws IOException {
        var file = getClass().getClassLoader().getResource("inputs.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var map = SecondTravelMap.of(reader);
            assertEquals(336, map.countTrees());
        }
    }

    public void testProblemPartTwo() throws IOException {
        var file = getClass().getClassLoader().getResource("problem.txt").getFile();
        try(var reader = new BufferedReader(new FileReader(file, Charset.forName("UTF-8")))) {
            var map = SecondTravelMap.of(reader);
            assertEquals(4355551200l, map.countTrees());
        }
    }
}
