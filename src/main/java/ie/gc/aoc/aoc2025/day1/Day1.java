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
        int zeroCount = 0;

        for (final String rotation : stringInput) {

            final char direction = rotation.toUpperCase(Locale.getDefault())
                .charAt(0);
            final int distance = Integer.parseInt(rotation.substring(1));
            final int distanceToMove = distance % 100;
            System.out.println(direction + "-" + distance + "-" + distanceToMove);

            if (direction == 'R') {
                position += distanceToMove;
                if (position > 99) {
                    position -= 100;
                }
            } else {
                position -= distanceToMove;
                if (position < 0) {
                    position += 100;
                }
            }

            if (position == 0) {
                zeroCount++;
            }

            System.out.println("Current position: " + position + " - Zero Count: " + zeroCount);

        }

    }

}
