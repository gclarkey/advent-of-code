package ie.gc.aoc.aoc2022.day2;

import ie.gc.aoc.input.Input;

import java.util.HashMap;
import java.util.List;

import static ie.gc.aoc.aoc2022.day2.Shape.PAPER;
import static ie.gc.aoc.aoc2022.day2.Shape.ROCK;
import static ie.gc.aoc.aoc2022.day2.Shape.SCISSORS;

public class Day2 {

    private final Input input;
    private final HashMap<Character, Shape> ABC_SHAPE = new HashMap<>();
    private final HashMap<Character, Shape> XYZ_SHAPE = new HashMap<>();

    public Day2(final Input input) {
        this.input = input;

        ABC_SHAPE.put('A', ROCK);
        ABC_SHAPE.put('B', PAPER);
        ABC_SHAPE.put('C', SCISSORS);

        XYZ_SHAPE.put('X', ROCK);
        XYZ_SHAPE.put('Y', PAPER);
        XYZ_SHAPE.put('Z', SCISSORS);
    }

    public void doSomething() {
        final List<String> stringInput = input.fetchInput("/2022/day2/rock-paper-scissors.txt");

        int totalScore = 0;

        for(final String round : stringInput){
            final char opponentShape = round.charAt(0);
            final char myShape = round.charAt(2);

            final int roundScore = calculateScore(ABC_SHAPE.get(opponentShape), XYZ_SHAPE.get(myShape));
            totalScore += roundScore;
        }

        System.out.println(totalScore);


        int totalScoreSneaky = 0;

        for(final String round : stringInput){
            final char opponentShape = round.charAt(0);
            final char requiredResult = round.charAt(2);
            final Shape myShape = determineRequiredShape(ABC_SHAPE.get(opponentShape), requiredResult);

            final int roundScoreSneaky = calculateScore(ABC_SHAPE.get(opponentShape), myShape);
            totalScoreSneaky += roundScoreSneaky;
        }

        System.out.println(totalScoreSneaky);
    }

    private int calculateScore(final Shape opponentShape, final Shape myShape) {
        // shape    | opponent | me
        // rock     | A        | X
        // paper    | B        | Y
        // scissors | C        | Z

        int roundScore = 0;

        // points for shape choice (bit weird)
        if(myShape == ROCK)
            roundScore+=1;
        else if (myShape == PAPER)
            roundScore+=2;
        else if (myShape == SCISSORS)
            roundScore+=3;

        // 6 points for winning
        // rock beats scissors
        if(myShape == ROCK && opponentShape == SCISSORS)
            roundScore+=6;
        // paper beats rock
        else if (myShape == PAPER && opponentShape == ROCK)
            roundScore+=6;
        //scissors beats paper
        else if (myShape == SCISSORS && opponentShape == PAPER)
            roundScore+=6;

        // 3 points for drawing
        if(myShape == opponentShape)
            roundScore+=3;

        return roundScore;
    }

    private Shape determineRequiredShape(final Shape opponentShape, final char requiredResult) {
        final char lose = 'X';
        final char draw = 'Y';

        final Shape requiredShape;

        // lose
        if(requiredResult == lose){
            if(opponentShape == ROCK)
                requiredShape = SCISSORS;
            else if(opponentShape == PAPER)
                requiredShape = ROCK;
            else
                requiredShape = PAPER;
        }
        // draw
        else if(requiredResult == draw)
            requiredShape = opponentShape;
        // win
        else{
            if(opponentShape == ROCK)
                requiredShape = PAPER;
            else if(opponentShape == PAPER)
                requiredShape = SCISSORS;
            else
                requiredShape = ROCK;
        }

        return  requiredShape;
    }

}
