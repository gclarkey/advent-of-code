package ie.gc.aoc.aoc2022.day4;

import ie.gc.aoc.input.FileInput;
import ie.gc.aoc.input.Input;

import java.util.List;

public class Day4 {

    public static void main(final String[] args) {
        System.out.println("Aoc2022::Day4");

        final Input input = new FileInput();

        doSomething(input);
    }

    private static void doSomething(final Input input) {
        final List<String> stringInput = input.fetchInput("/2022/day4/assignments.txt");

        int containsTheOther = 0;
        int overlaps = 0;

        for (final String assignment : stringInput) {
            if (containsTheOther(assignment)) {
                containsTheOther++;
            }

            if (overlaps(assignment)) {
                overlaps++;
            }
        }

        System.out.println(containsTheOther);
        System.out.println(overlaps);
    }

    private static boolean containsTheOther(final String assignment) {
        boolean containsTheOther = false;

        final String[] splitAssignment = assignment.split(",");
        final String elf1Assignment = splitAssignment[0];
        final String elf2Assignment = splitAssignment[1];

        final String[] elf1AssignmentSplit = elf1Assignment.split("-");
        final int elf1Start = Integer.parseInt(elf1AssignmentSplit[0]);
        final int elf1End = Integer.parseInt(elf1AssignmentSplit[1]);

        final String[] elf2AssignmentSplit = elf2Assignment.split("-");
        final int elf2Start = Integer.parseInt(elf2AssignmentSplit[0]);
        final int elf2End = Integer.parseInt(elf2AssignmentSplit[1]);

        if (elf1Start <= elf2Start && elf1End >= elf2End) {
            containsTheOther = true;
        }

        if (elf2Start <= elf1Start && elf2End >= elf1End) {
            containsTheOther = true;
        }

        return containsTheOther;
    }

    private static boolean overlaps(final String assignment) {
        boolean overlaps = false;

        final String[] splitAssignment = assignment.split(",");
        final String elf1Assignment = splitAssignment[0];
        final String elf2Assignment = splitAssignment[1];

        final String[] elf1AssignmentSplit = elf1Assignment.split("-");
        final int elf1Start = Integer.parseInt(elf1AssignmentSplit[0]);
        final int elf1End = Integer.parseInt(elf1AssignmentSplit[1]);

        final String[] elf2AssignmentSplit = elf2Assignment.split("-");
        final int elf2Start = Integer.parseInt(elf2AssignmentSplit[0]);
        final int elf2End = Integer.parseInt(elf2AssignmentSplit[1]);

        if (elf1Start <= elf2Start && elf1End >= elf2Start) {
            overlaps = true;
        }

        if (elf2Start <= elf1Start && elf2End >= elf1Start) {
            overlaps = true;
        }

        return overlaps;
    }

}
