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
    public void testExamplePartOne() {
        var game = new MemoryGame();
        assertEquals(436, game.play2020(0L,3L,6L));
        assertEquals(1, game.play2020(1L,3L,2L));
        assertEquals(10, game.play2020(2L,1L,3L));
        assertEquals(27, game.play2020(1L,2L,3L));
        assertEquals(78, game.play2020(2L,3L,1L));
        assertEquals(438, game.play2020(3L,2L,1L));
        assertEquals(1836, game.play2020(3L,1L,2L));
    }

    public void testProblemPartOne() {
        var game = new MemoryGame();
        assertEquals(492L, game.play2020(1L,20L,8L,12L,0L,14L));
    }

    public void testExamplePartTwo() {
        var game = new MemoryGame();
        assertEquals(175594, game.play30000000(0L,3L,6L));
        /*assertEquals(2578, game.play30000000(1L,3L,2L));
        assertEquals(3544142, game.play30000000(2L,1L,3L));
        assertEquals(261214, game.play30000000(1L,2L,3L));
        assertEquals(6895259, game.play30000000(2L,3L,1L));
        assertEquals(18, game.play30000000(3L,2L,1L));
        assertEquals(362, game.play30000000(3L,1L,2L));*/
    }

    public void testProblemPartTwo() {
        var game = new MemoryGame();
        assertEquals(175594, game.play30000000(1L,20L,8L,12L,0L,14L));

    }
}
