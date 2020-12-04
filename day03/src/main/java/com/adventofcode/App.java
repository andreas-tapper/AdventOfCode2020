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
        System.out.println( "Day 3 of Advent of Code 2020." );

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
            var map = TravelMap.of(reader);
            System.out.println(String.format("The answer is: %d", map.countTrees()));
        }
    }
}
