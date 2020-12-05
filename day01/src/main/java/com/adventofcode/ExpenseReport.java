package com.adventofcode;

import java.util.List;

public class ExpenseReport {
    private List<Integer> expenses;

    public ExpenseReport(List<Integer> expenses) {
        this.expenses = expenses;
    }

    public int getResultPartOne() {
        for(var i=0; i < expenses.size(); i += 1) {
            for(var j=0; j < expenses.size(); j += 1) {
                if(expenses.get(i) + expenses.get(j) == 2020) {
                    return expenses.get(i) * expenses.get(j);
                }
            }
        }
        return -1;
    }

    public int getResultPartTwo() {
        for(var i=0; i < expenses.size(); i += 1) {
            for(var j=0; j < expenses.size(); j += 1) {
                for(var k=0; k < expenses.size(); k += 1) {
                    if (expenses.get(i) + expenses.get(j) + expenses.get(k) == 2020) {
                        return expenses.get(i) * expenses.get(j) * expenses.get(k);
                    }
                }
            }
        }

        return 0;
    }
}
