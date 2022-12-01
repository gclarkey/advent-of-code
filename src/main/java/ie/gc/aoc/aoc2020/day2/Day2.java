package ie.gc.aoc.aoc2020.day2;

import ie.gc.aoc.input.Input;

import java.util.ArrayList;
import java.util.List;

public class Day2 {

    private final Input input;

    public Day2(Input input) {
        this.input = input;
    }

    public void doSomething() {
        final List<String> stringInput = input.fetchInput("/2020/day2/password-list.txt");

        final List<PasswordRecord> passwordRecords = convert(stringInput);
        validatePasswords(passwordRecords);
        validatePositionBased(passwordRecords);
    }

    private List<PasswordRecord> convert(final List<String> stringInput) {
        final List<PasswordRecord> passwordRecords = new ArrayList<>();

        for (final String s : stringInput) {
            final PasswordRecord p = new PasswordRecord();

            final int dashPosition = s.indexOf('-');
            final int firstSpacePosition = s.indexOf(' ');
            final int colonPosition = s.indexOf(':');

            p.setMin(Integer.parseInt(s.substring(0, dashPosition)));
            p.setMax(Integer.parseInt(s.substring(dashPosition + 1, firstSpacePosition)));
            p.setLetter(s.substring(firstSpacePosition + 1, colonPosition)
                         .charAt(0));
            p.setPassword(s.substring(colonPosition + 2));

            passwordRecords.add(p);
        }
        return passwordRecords;
    }

    private void validatePasswords(final List<PasswordRecord> passwordRecords) {
        int validPasswords = 0;

        for (final PasswordRecord p : passwordRecords) {
            int characterCount = 0;
            for (final char c : p.getPassword()
                                 .toCharArray()) {
                if (c == p.getLetter()) {
                    characterCount++;
                }
            }
            if (characterCount >= p.getMin() && characterCount <= p.getMax()) {
                p.setValid(true);
                validPasswords++;
            }
        }

        System.out.println("Number of valid passwords: " + validPasswords);
    }

    private void validatePositionBased(final List<PasswordRecord> passwordRecords) {
        int validPasswords = 0;

        for (final PasswordRecord p : passwordRecords) {
            int characterCount = 0;

            if (p.getLetter() == p.getPassword()
                                  .charAt(p.getMin() - 1)) {
                characterCount++;
            }

            if (p.getLetter() == p.getPassword()
                                  .charAt(p.getMax() - 1)) {
                characterCount++;
            }

            if (characterCount == 1) {
                p.setValid(true);
                validPasswords++;
            }
        }

        System.out.println("Number of valid passwords position based: " + validPasswords);
    }
}
