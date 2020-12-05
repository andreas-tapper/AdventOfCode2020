package com.adventofcode;

import java.io.*;
import java.nio.charset.Charset;

public class App
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Day 4 of Advent of Code 2020." );

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
            var passports = PassportParser.Parse(reader);
            System.out.println(String.format("The answer is: %d", passports.stream().filter(Passport::isComplete).count()));
        }
    }
}
