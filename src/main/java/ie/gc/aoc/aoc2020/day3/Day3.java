package ie.gc.aoc.aoc2020.day3;

import ie.gc.aoc.input.Input;

import java.util.List;

public class Day3 {

    private final Input input;

    public Day3(Input input) {
        this.input = input;
    }

    public void doSomething() {
        final List<String> stringInput = input.fetchInput("/2020/day3/map.txt");
        System.out.println("stringInput.size()="+stringInput.size());

        final int treesEncountered_3_1 = numberOfTreesEncountered(stringInput, 3, 1);
        System.out.println("Number of r3d1 trees encountered: " + treesEncountered_3_1);

        final int treesEncountered_1_1 = numberOfTreesEncountered(stringInput, 1, 1);
        final int treesEncountered_5_1 = numberOfTreesEncountered(stringInput, 5, 1);
        final int treesEncountered_7_1 = numberOfTreesEncountered(stringInput, 7, 1);
        final int treesEncountered_1_2 = numberOfTreesEncountered(stringInput, 1, 2);

        System.out.println("Number of all trees encountered: " + treesEncountered_3_1*treesEncountered_1_1*treesEncountered_5_1*treesEncountered_7_1*treesEncountered_1_2);
    }

    private int numberOfTreesEncountered(final List<String> stringInput, int right, int down) {
        int x=0;
        int y=0;
        int treesEncountered = 0;
        for(int i = 0; i< stringInput.size()-1; i++){
            x +=right;
            if(x >= stringInput.get(y).length()){
                x = x - stringInput.get(y).length();
            }

            y=y+down;
            if(y>= stringInput.size()){
                break;
            }

            if(stringInput.get(y).charAt(x) == '#'){
                treesEncountered++;
            }
        }

        System.out.println("Number of trees encountered: " + treesEncountered);

        return treesEncountered;
    }

}
