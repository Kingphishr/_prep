package ctci;

import java.util.HashMap;

/**
 * Created by LAViATHoR on 10/31/2016.
 * Problem 8.1
 *
 * A child is running up a staircase with n steps and can hope either 1,2, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 *
 */
public class Ch8_1__TripleStep {
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args){
        System.out.println(paths(3));
    }

    private static int paths(int steps){

        if(steps == 0) return 1;

        if(!map.containsKey(steps)){
            switch(steps){
                case 1:
                    map.put(steps, paths(steps - 1));
                    break;
                case 2:
                    map.put(steps, paths(steps - 2) + paths(steps - 1));
                    break;
                default:
                    map.put(steps, paths(steps - 3) + paths(steps -2) + paths(steps - 1));
            }
        }

        return map.get(steps);
    }
}
