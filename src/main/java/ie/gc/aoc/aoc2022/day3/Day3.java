package ie.gc.aoc.aoc2022.day3;

import ie.gc.aoc.input.Input;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day3 {

    private final Input input;

    public Day3(final Input input) {
        this.input = input;
    }

    public void doSomething() {
        final List<String> stringInput = input.fetchInput("/2022/day3/rucksacks.txt");

        int totalPriority = 0;

        for (final String rucksack : stringInput) {
            final Set<Integer> intersection = getCompartmentIntersection(rucksack);

            for (final Integer i : intersection){
                totalPriority = determinePriority(totalPriority, i);
            }
        }

        System.out.println(totalPriority);
    }

    private int determinePriority(int totalPriority, final Integer i) {
        final int priority;
        if(i >=65 && i <= 90)
            priority = i -38;
        else
            priority = i -96;

        totalPriority +=priority;
        return totalPriority;
    }

    private Set<Integer> getCompartmentIntersection(final String rucksack) {
        final CharSequence compartment1 = rucksack.subSequence(0, rucksack.length() / 2);
        final CharSequence compartment2 = rucksack.subSequence(rucksack.length() / 2, rucksack.length());

        return compartment1.chars()
            .distinct()
            .filter(compartment2.chars()
                .boxed()
                .collect(Collectors.toList())::contains)
            .boxed()
            .collect(Collectors.toSet());
    }

}
