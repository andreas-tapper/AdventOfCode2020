package com.adventofcode;

public class PasswordAndPolicy {
    private String password;
    private SledRentalPlacePolicy policy;

    public PasswordAndPolicy(String password, SledRentalPlacePolicy policy) {
        this.password = password;
        this.policy = policy;
    }

    public boolean match() {
        return policy.match(password);
    }

    public static PasswordAndPolicy withSledRentalPolicy(String text) {
        var data = text.split(" ");
        var bounds = data[0].split("-");
        return new PasswordAndPolicy(data[2], new SledRentalPlacePolicy(Integer.valueOf(bounds[0]), Integer.valueOf(bounds[1]), data[1].charAt(0)));
    }

    public static PasswordAndPolicy withTobogganCorporate(String text) {
        var data = text.split(" ");
        var bounds = data[0].split("-");
        return new PasswordAndPolicy(data[2], new TobogganCorporatePolicy(Integer.valueOf(bounds[0]), Integer.valueOf(bounds[1]), data[1].charAt(0)));
    }
}
