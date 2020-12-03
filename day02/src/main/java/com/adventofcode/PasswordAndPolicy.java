package com.adventofcode;

public class PasswordAndPolicy {
    private String password;
    private Policy policy;

    public PasswordAndPolicy(String password, Policy policy) {
        this.password = password;
        this.policy = policy;
    }

    public boolean match() {
        return policy.match(password);
    }

    public static PasswordAndPolicy of(String text) {
        var data = text.split(" ");
        var bounds = data[0].split("-");
        return new PasswordAndPolicy(data[2], new Policy(Integer.valueOf(bounds[0]), Integer.valueOf(bounds[1]), data[1].charAt(0)));
    }
}
