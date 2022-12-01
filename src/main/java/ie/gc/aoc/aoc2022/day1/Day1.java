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
        for(final String line : stringInput){

            if(line.isEmpty()){
                caloriesPerElf.add(runningTotal);
                runningTotal=0;
            } else {
                runningTotal += Integer.parseInt(line);
            }
        }
        caloriesPerElf.add(runningTotal);

        int elf =0;
        int elfCalories=0;
        for(int i=0; i<caloriesPerElf.size(); i++){
                if(caloriesPerElf.get(i) > elfCalories){
                    elfCalories = caloriesPerElf.get(i);
                    elf=i;
                }
        }

        System.out.println(elf);
        System.out.println(elfCalories);
        System.out.println(caloriesPerElf.get(elf));

    }

}
