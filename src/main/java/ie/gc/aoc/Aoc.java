package ie.gc.aoc;

import ie.gc.aoc.day1.Day1;
import ie.gc.aoc.input.FileInput;
import ie.gc.aoc.input.Input;

public class Aoc {

    public static void main(String[] args) {
        System.out.println("Aoc::main");

        final Input input = new FileInput();

        final Day1 day1 = new Day1(input);
        day1.doSomething();
    }

}
