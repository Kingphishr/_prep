package chapter_1;

/**
 * Created by LAViATHoR on 10/19/2016.
 * * Problem 1.1
 *
 * Implement an algorithm to check if a string has Unique characters. (Just use arrays)
 *
 *
 */
public class Ch1_1__IsUnique {

    private static boolean isUnique(String s){
        char[] str = s.toCharArray();
        int[] check = new int[256];

        for(int i = 0; i < check.length; i++)
            check[i] = 0;


        for (int i = 0; i < str.length; i++){
            if(check[Character.getNumericValue(str[i])] !=0)
                return false;
            check[Character.getNumericValue(str[i])] += 1;
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(isUnique("aab")); //false
        System.out.println(isUnique("abcd")); //true
        System.out.println(isUnique("zyxwvutsrqponmlkjihgfedcba")); //true
    }
}
