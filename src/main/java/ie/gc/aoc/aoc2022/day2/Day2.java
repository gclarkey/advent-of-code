package ie.gc.aoc.aoc2022.day2;

import ie.gc.aoc.input.Input;

import java.util.List;

public class Day2 {

    private final Input input;

    public Day2(final Input input) {
        this.input = input;
    }

    public void doSomething() {
        final List<String> stringInput = input.fetchInput("/2022/day2/rock-paper-scissors.txt");

        int totalScore = 0;

        for(final String round : stringInput){
            final char opponentShape = round.charAt(0);
            final char myShape = round.charAt(2);

            final int roundScore = calculateScore(opponentShape, myShape);
            totalScore += roundScore;
        }

        System.out.println(totalScore);
    }

    private int calculateScore(final char opponentShape, final char myShape) {
        // shape    | opponent | me
        // rock     | A        | X
        // paper    | B        | Y
        // scissors | C        | Z

        int roundScore = 0;

        // points for shape choice (bit weird)
        if(myShape == 'X')
            roundScore+=1;
        else if (myShape == 'Y')
            roundScore+=2;
        else if (myShape == 'Z')
            roundScore+=3;

        // 6 points for winning
        // rock beats scissors
        if(myShape == 'X' && opponentShape == 'C')
            roundScore+=6;
        // paper beats rock
        else if (myShape == 'Y' && opponentShape == 'A')
            roundScore+=6;
        //scissors beats paper
        else if (myShape == 'Z' && opponentShape == 'B')
            roundScore+=6;

        // 3 points for drawing
        // rock
        if(myShape == 'X' && opponentShape == 'A')
            roundScore+=3;
        // paper
        else if (myShape == 'Y' && opponentShape == 'B')
            roundScore+=3;
        //scissors
        else if (myShape == 'Z' && opponentShape == 'C')
            roundScore+=3;

        return roundScore;
    }

}
