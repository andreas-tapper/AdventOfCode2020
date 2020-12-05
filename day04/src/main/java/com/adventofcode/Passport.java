package com.adventofcode;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Passport {
    private Map<String, String> values = new HashMap<String, String>();

    public boolean isValid() {
        var keys = values.keySet();
        /*
            byr (Birth Year)
            iyr (Issue Year)
            eyr (Expiration Year)
            hgt (Height)
            hcl (Hair Color)
            ecl (Eye Color)
            pid (Passport ID)
            cid (Country ID)
        */
        return keys.contains("byr")
                && keys.contains("iyr")
                && keys.contains("eyr")
                && keys.contains("hgt")
                && keys.contains("hcl")
                && keys.contains("ecl")
                && keys.contains("pid");
    }

    public static class Builder {
        private Passport passport = new Passport();

        public Passport build() {
            return passport;
        }

        public void add(String key, String value) {
            passport.values.put(key, value);
        }
    }
}
