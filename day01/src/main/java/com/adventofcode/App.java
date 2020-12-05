package com.adventofcode;

import java.io.*;
import java.nio.charset.Charset;

import static java.util.stream.Collectors.toList;

public class App
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Day 1 of Advent of Code 2020." );

        if(args.length < 1) {
            System.out.println("usage <filename with inputs>");
            return;
        }

        try(var reader = new BufferedReader(new FileReader(args[0], Charset.forName("UTF-8")))) {
            var report = new ExpenseReport(reader.lines()
                    .map(Integer::valueOf)
                    .collect(toList()));
            System.out.println(String.format("The answer to part one is: %d", report.getResultPartOne()));
            System.out.println(String.format("The answer to part two is: %d", report.getResultPartTwo()));
        }
    }
}
