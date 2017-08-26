package chapter_6;

/*
* PROBLEM
*
* Write a function that reverses the order of the words in a string.
*
* SOLUTION
*
* Complexity = O(n)
* Space      = O(n) where k is number of words
*
*
* */


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class page_97 {

    String reverseOrder(String input){
        String[] words = input.split(" ");
        StringBuilder builder = new StringBuilder();

        for(int i = words.length - 1; i > 0; i--)
            builder.append(words[i] + " ");

        builder.append(words[0]);

        return builder.toString();
    }

}

class page_97Test {
    page_97 test = new page_97();

    @Test
    void testReverseOrder(){
        String yoda = "Do or do not, there is no try.";
        String reverseYoda = "try. no is there not, do or Do";

        Assertions.assertEquals(reverseYoda, test.reverseOrder(yoda));
    }
}