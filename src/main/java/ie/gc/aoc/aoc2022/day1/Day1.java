package ie.gc.aoc.aoc2022.day1;

import ie.gc.aoc.input.Input;

import java.util.ArrayList;
import java.util.List;

public class Day1 {

    private final Input input;

    public Day1(final Input input) {
        this.input = input;
    }

    public void doSomething() {
        final List<String> stringInput = input.fetchInput("/2022/day1/calories.txt");

        final List<Integer> caloriesPerElf = new ArrayList<>();

        int runningTotal = 0;
        for (final String line : stringInput) {
            if (line.isEmpty()) {
                caloriesPerElf.add(runningTotal);
                runningTotal = 0;
            } else {
                runningTotal += Integer.parseInt(line);
            }
        }
        caloriesPerElf.add(runningTotal);

        final Elf elf1 = getElfWithMostCalories(caloriesPerElf);
        System.out.println(elf1);
        caloriesPerElf.remove(elf1.getId());

        final Elf elf2 = getElfWithMostCalories(caloriesPerElf);
        System.out.println(elf2);
        caloriesPerElf.remove(elf2.getId());

        final Elf elf3 = getElfWithMostCalories(caloriesPerElf);
        System.out.println(elf3);
        caloriesPerElf.remove(elf3.getId());

        System.out.println(elf1.getCalories() + elf2.getCalories() + elf3.getCalories());

    }

    private Elf getElfWithMostCalories(final List<Integer> caloriesPerElf) {
        final Elf elfWithMostCalories = new Elf();
        for (int i = 0; i < caloriesPerElf.size(); i++) {
            if (caloriesPerElf.get(i) > elfWithMostCalories.getCalories()) {
                elfWithMostCalories.setCalories(caloriesPerElf.get(i));
                elfWithMostCalories.setId(i);
            }
        }
        return elfWithMostCalories;
    }

}
