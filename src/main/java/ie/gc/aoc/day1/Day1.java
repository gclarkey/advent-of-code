package ie.gc.aoc.day1;

import ie.gc.aoc.input.Input;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

    private Input input;

    public Day1(final Input input) {
        this.input = input;
    }

    public void doSomething() {
        final List<String> stringInput = input.fetchInput("/day1/expense-report.txt");
        final List<Integer> expenseReport = stringInput.stream()
                                                       .map(Integer::valueOf)
                                                       .sorted(Comparator.comparing(Integer::valueOf))
                                                       .collect(Collectors.toList());

        for (int i = 0; i < expenseReport.size(); i++) {
            for (int j = i + 1; j < expenseReport.size(); j++) {
                if (expenseReport.get(i) + expenseReport.get(j) == 2020) {
                    System.out.println(expenseReport.get(i));
                    System.out.println(expenseReport.get(j));
                    System.out.println(expenseReport.get(i) * expenseReport.get(j));

                    //TODO could start putting breaks in to stop searching
                }
            }
        }

        for (int i = 0; i < expenseReport.size(); i++) {
            for (int j = i + 1; j < expenseReport.size(); j++) {
                for (int k = j + 1; k < expenseReport.size(); k++) {
                    if (expenseReport.get(i) + expenseReport.get(j) + expenseReport.get(k) == 2020) {
                        System.out.println(expenseReport.get(i));
                        System.out.println(expenseReport.get(j));
                        System.out.println(expenseReport.get(k));
                        System.out.println(expenseReport.get(i) * expenseReport.get(j) * expenseReport.get(k));

                        //TODO could start putting breaks in to stop searching
                    }
                }
            }
        }

    }
}
