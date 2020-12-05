package com.adventofcode;

import java.util.*;
import java.util.regex.Pattern;

public class Passport {
    private static final Pattern Height = Pattern.compile("^\\d+(cm|in)$");
    private static final Pattern Color = Pattern.compile("^#(\\d|[a-f]){6}$");
    private static final Pattern PassportId = Pattern.compile("^(\\d){9}$");
    private static final Set<String> EyeColor = new HashSet<>();

    private Map<String, String> values = new HashMap<String, String>();

    static {
        EyeColor.add("amb");
        EyeColor.add("blu");
        EyeColor.add("brn");
        EyeColor.add("gry");
        EyeColor.add("grn");
        EyeColor.add("hzl");
        EyeColor.add("oth");
    }

    public boolean isComplete() {
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

    public boolean isValid() {
        if(!isComplete()) return false;

        /*
        byr (Birth Year) - four digits; at least 1920 and at most 2002.
        iyr (Issue Year) - four digits; at least 2010 and at most 2020.
        eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
        hgt (Height) - a number followed by either cm or in:
            If cm, the number must be at least 150 and at most 193.
            If in, the number must be at least 59 and at most 76.
        hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
        ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
        pid (Passport ID) - a nine-digit number, including leading zeroes.
        cid (Country ID) - ignored, missing or not.
        */
        var byr = Integer.parseInt(values.get("byr"));
        if(byr < 1920 || byr > 2002) return false;

        var iyr = Integer.parseInt(values.get("iyr"));
        if(iyr < 2010 || iyr > 2020) return false;

        var eyr = Integer.parseInt(values.get("eyr"));
        if(eyr < 2020 || eyr > 2030) return false;

        var hgt = values.get("hgt");
        if(!Height.matcher(hgt).matches()) return false;
        var length = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
        var unit = hgt.substring(hgt.length() - 2);
        if(unit.equalsIgnoreCase("cm") && (length < 150 || length > 193)) return false;
        if(unit.equalsIgnoreCase("in") && (length < 59  || length > 76)) return false;

        if(!Color.matcher(values.get("hcl")).matches()) return false;

        if(!EyeColor.contains(values.get("ecl"))) return false;

        if(!PassportId.matcher(values.get("pid")).matches()) return false;

        return true;
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
