package com.adventofcode;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class App
{
    public static void main( String[] args ) throws IOException, URISyntaxException {
        System.out.println( "Day 2 of Advent of Code 2020." );

        if(args.length < 1) {
            System.out.println("usage <filename with inputs>");
            return;
        }

        var file = new File(args[0]);
        if(!file.exists()) {
            System.out.println(String.format("File at '%s' doesn't exist.", file.getAbsoluteFile().toString()));
            return;
        }

        try(var reader = new BufferedReader(new FileReader(file.getAbsoluteFile().toString(), Charset.forName("UTF-8")))) {
            var partOneMatches = reader.lines()
                    .map(PasswordAndPolicy::withSledRentalPolicy)
                    .filter(PasswordAndPolicy::match)
                    .count();
            var partTwoMatches = reader.lines()
                    .map(PasswordAndPolicy::withTobogganCorporate)
                    .filter(PasswordAndPolicy::match)
                    .count();
            System.out.println(String.format("The answer of part one is: %d", partOneMatches));
            System.out.println(String.format("The answer of part two is: %d", partTwoMatches));
        }
    }
}
