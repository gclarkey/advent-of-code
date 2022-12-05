package ie.gc.aoc.aoc2022;

import ie.gc.aoc.aoc2022.day1.Day1;
import ie.gc.aoc.aoc2022.day2.Day2;
import ie.gc.aoc.aoc2022.day3.Day3;
import ie.gc.aoc.input.FileInput;
import ie.gc.aoc.input.Input;

public class Aoc2022 {

    public static void main(final String[] args) {
        System.out.println("Aoc2022::main");

        final Input input = new FileInput();

        System.out.println("\n\n**** DAY 1 ****");
        final Day1 day1 = new Day1(input);
        day1.doSomething();

        System.out.println("\n\n**** DAY 2 ****");
        final Day2 day2 = new Day2(input);
        day2.doSomething();

        System.out.println("\n\n**** DAY 3 ****");
        final Day3 day3 = new Day3(input);
        day3.doSomething();
    }

}
