package ie.gc.aoc.aoc2020.day2;

import lombok.Data;

@Data
public class PasswordRecord {

    private int min;
    private int max;
    private char letter;
    private String password;
    private boolean isValid;

}
