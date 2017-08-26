package chapter_6;

/*
* PROBLEM
*
* Write an efficient function to find the first non-repeated character in a string
*
* SOLUTION
*
* Complexity = O(n)
* Space      = O(1)
*
*
* */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;

public class page_91 {

    public char getFirstNonRepeatedChar(String input){
        char[] arr = input.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], -1);
            } else {
                map.put(arr[i], i);
            }
        }

        Collection<Integer> values = map.values();

        int position = 0;

        for(int i : values){
            if(i > -1){
                position = i;
                break;
            }
        }

        for(int i : values)
            if(i > -1 && i < position)
                position = i;

        return arr[position];
    }
}

class page_91Test {
    page_91 page_91 = new page_91();

    @Test
    void testGetFirstNonRepeatedChar() {
        char total = page_91.getFirstNonRepeatedChar("total");
        Assertions.assertEquals('o', total);

        char teeter = page_91.getFirstNonRepeatedChar("teeter");
        Assertions.assertEquals('r', teeter);
    }
}

