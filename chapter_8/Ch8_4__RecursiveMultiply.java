package chapter_8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * Created by aatifshah on 9/22/17.
 */
public class Ch8_4__RecursiveMultiply {

    public static int recursiveMultiply(int a, int b){
        return recursiveMultiply(a, b, new HashMap<>());
    }


    private static int recursiveMultiply(int a, int b, HashMap<Integer, Integer> memo){
        boolean neg = isNegative(a) ^ isNegative(b);

        if(isNegative(a)) a = ~a + 1;
        if(isNegative(b)) b = ~b + 1;


        if(b == 0) return 1;
        if(b == 1) return a;

        if(!memo.containsKey(b)){
            int x = b>>1;
            memo.put(b, recursiveMultiply(a, x, memo) + recursiveMultiply(a, b-x, memo));
        }

        return neg ? ~memo.get(b) + 1 : memo.get(b);
    }

    private static boolean isNegative(int a){
        return a < 0;
    }

}

class Test_RecursiveMultiply{
    @Test
    void testRecursiveMultiply(){
        Assertions.assertEquals(-6, Ch8_4__RecursiveMultiply.recursiveMultiply(-3, 2));
        Assertions.assertEquals(36, Ch8_4__RecursiveMultiply.recursiveMultiply(9, 4));
        Assertions.assertEquals(20, Ch8_4__RecursiveMultiply.recursiveMultiply(-4, -5));
    }
}
