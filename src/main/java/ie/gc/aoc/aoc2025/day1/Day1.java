package ie.gc.aoc.aoc2025.day1;

import ie.gc.aoc.input.FileInput;
import ie.gc.aoc.input.Input;

import java.util.List;
import java.util.Locale;

public class Day1 {

    void main() {
        System.out.println("Aoc2025::Day1");

        final Input input = new FileInput();
        final List<String> stringInput = input.fetchInput("/2025/day1/rotations.txt");
        System.out.println(stringInput);

        int position = 50;
        int atOrPassesZero = 0;

        for (final String rotation : stringInput) {
            System.out.println("--------------------------------");
            final int startingPosition = position;
            System.out.println("Starting position: " + startingPosition);
            System.out.println("Input rotation: " + rotation);

            final char direction = rotation.toUpperCase(Locale.getDefault())
                .charAt(0);
            final int distance = Integer.parseInt(rotation.substring(1));
            final int distanceToMove = distance % 100;
            final int loops = distance / 100;
            System.out.println("Parsed data: " + direction + "-" + distance + "-" + distanceToMove  + "-" + loops);
            System.out.println("Loops: " + loops);

            atOrPassesZero += loops;

            final int interimPosition;
            if (direction == 'R') {
                interimPosition = startingPosition + distanceToMove;
            } else {
                interimPosition = startingPosition - distanceToMove;
            }

            System.out.println("Interim position: " + interimPosition);

            final int finalPosition;
            if (interimPosition == 0) {
                atOrPassesZero++;
                finalPosition = interimPosition;
            } else if (interimPosition > 99) {
                finalPosition = interimPosition - 100;
                atOrPassesZero++;
            } else if (interimPosition < 0) {
                finalPosition = interimPosition + 100;
                if (startingPosition!=0) {
                    atOrPassesZero++;
                }
            } else {
                finalPosition = interimPosition;
            }

            System.out.println("Final position: " + finalPosition);
            System.out.println("Passes Zero: " + atOrPassesZero);

            position = finalPosition;
        }

    }

}
