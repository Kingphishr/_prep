package chapter_6;

/*
* PROBLEM
*
* Write an efficient function to find that deletes characters from an ASCII string
*
* SOLUTION
*
* Complexity = O(n)
* Space      = O(k) where k is length of remove characters
*
*
* */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class page_94 {

    String removeChars(String str, String remove){
        char[] strArr = str.toCharArray();
        char[] removeArr = remove.toCharArray();
        HashSet<Character> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for(char i : removeArr)
            set.add(i);

        for(char i : strArr)
            if(!set.contains(i))
                builder.append(i);

        return builder.toString();
    }
}

class page_94Test {
    page_94 test = new page_94();

    @Test
    void testRemoveChars(){
        String sentence = "Battle of the Vowels: Hawaii vs. Grozny";
        String remove = "aeiou";

        Assertions.assertEquals("Bttl f th Vwls: Hw vs. Grzny", test.removeChars(sentence, remove));
    }
}
