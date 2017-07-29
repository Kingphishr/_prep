package chapter_1;

import java.util.HashMap;

/**
 * Created by LAViATHoR on 10/19/2016.
 * Problem 1.2
 *
 * Given two strings, write a method to decide if one is a permutation of the other
 *
 */
public class Ch1_2__CheckPermutation {
    //for it to be a permutation of the other, it needs to have the same character count.
    private static boolean checkIfPermutation(String A, String B){
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        // add a's characters to map
        for(char i : a){
            if(!map.containsKey(i))
                map.put(i, 1);
            else
                map.put(i, map.get(i) + 1);
        }

        // subtract b's characters from map
        for (char i : b){
            if(!map.containsKey(i) || map.get(i) == 0)
                return false;
            map.put(i, map.get(i) - 1);
        }

        return a.length == b.length;
    }

    public static void main(String[] args){
        System.out.println(checkIfPermutation("ababab", "baababbbbb"));
        System.out.println(checkIfPermutation("abcddcba", "aabbccdd"));

    }

}
