package chapter_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class page_101 {
    int RADIX = 10;

    int stringToInt(String input){
        int sum = 0;
        int place = 0;
        char[] arr = input.toCharArray();
        boolean isnegative = arr[0] == '-';

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);


        for(int i = arr.length - 1; i > 0; i--){
            sum += map.get(arr[i]) * Math.pow(RADIX, place);
            place++;
        }

        if(!isnegative)
            sum += map.get(arr[0]) * Math.pow(RADIX, place);
        else
            sum *= -1;

        return sum;
    }

    String intToString(int input){
        StringBuilder builder = new StringBuilder();
        ArrayList<Character> reverse = new ArrayList<>();


        if(input < 0){
            builder.append('-');
            input *= -1;
        }

        HashMap<Integer, Character> map = new HashMap<>();
        map.put(0, '0');
        map.put(1, '1');
        map.put(2, '2');
        map.put(3, '3');
        map.put(4, '4');
        map.put(5, '5');
        map.put(6, '6');
        map.put(7, '7');
        map.put(8, '8');
        map.put(9, '9');

        int mod = input;
        while(input > 0){
            mod = input % 10;
            reverse.add(map.get(mod));
            input /= RADIX;
        }

        for(int i = reverse.size() - 1; i >= 0; i--)
            builder.append(reverse.get(i));

        return builder.toString();
    }
}

class page_101Test {
    page_101 test = new page_101();

    @Test
    void testPage_101(){
        String posStr = "132";
        String negStr = "-132";
        int posInt = 132;
        int negInt = -132;

        Assertions.assertEquals(posStr, test.intToString(posInt));
        Assertions.assertEquals(negStr, test.intToString(negInt));

        Assertions.assertEquals(posInt, test.stringToInt(posStr));
        Assertions.assertEquals(negInt, test.stringToInt(negStr));
    }
}
