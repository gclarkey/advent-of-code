package ie.gc.aoc.aoc2022.day3;

import ie.gc.aoc.input.Input;

import java.util.ArrayList;
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

        final int totalPriority = getTotalPriority(stringInput);
        System.out.println(totalPriority);

        final int groupPriority = getGroupPriority(stringInput);
        System.out.println(groupPriority);
    }

    private int getGroupPriority(final List<String> stringInput) {
        int groupPriority = 0;
        final List<String> rucksacks = new ArrayList<>();
        int count = 0;
        for (final String rucksack : stringInput) {
            count++;
            rucksacks.add(rucksack);
            if (count == 3) {
                groupPriority += determineGroupPriority(rucksacks);
                count = 0;
                rucksacks.clear();
            }

        }
        return groupPriority;
    }

    private int determineGroupPriority(final List<String> rucksacks) {
        final List<Integer> groupPriority = rucksacks.get(0)
            .chars()
            .distinct()
            .filter(rucksacks.get(1)
                .chars()
                .boxed()
                .collect(Collectors.toList())::contains)
            .filter(rucksacks.get(2)
                .chars()
                .boxed()
                .collect(Collectors.toList())::contains)
            .boxed()
            .collect(Collectors.toList());

        return determinePriority(groupPriority.get(0));
    }

    private int getTotalPriority(final List<String> stringInput) {
        int totalPriority = 0;

        for (final String rucksack : stringInput) {
            final Set<Integer> intersection = getCompartmentIntersection(rucksack);

            for (final Integer i : intersection) {
                totalPriority += determinePriority(i);
            }
        }
        return totalPriority;
    }

    private int determinePriority(final Integer i) {
        final int priority;
        if(i >=65 && i <= 90)
            priority = i -38;
        else
            priority = i -96;

        return priority;
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
