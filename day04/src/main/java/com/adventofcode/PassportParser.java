package com.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class PassportParser {
    public static List<Passport> Parse(BufferedReader reader) {
        var passports = new ArrayList<Passport>();

        var builder = new Passport.Builder();
        try {
            String line;
            while((line = reader.readLine()) != null) {
                if(line.isBlank()) {
                    passports.add(builder.build());
                    builder = new Passport.Builder();
                    continue;
                }

                for (var pairs : line.split(" ")) {
                    var pair = pairs.split(":");
                    builder.add(pair[0], pair[1]);
                }
            }

            passports.add(builder.build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return passports;
    }
}
