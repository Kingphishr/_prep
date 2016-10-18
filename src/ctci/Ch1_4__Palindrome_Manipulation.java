/*
* Problem 1.4
* Check if a String can be a palindrome when it grows up
*
* @Input
* String: "Tact coa"
*
* @Output
* Boolean: true (Taco Cat, etc..)
*
* */


package ctci;

import java.util.HashMap;

public class Ch1_4__Palindrome_Manipulation {
    //Remove spaces and do toLowerCase
    //Check if char count is even, if it is return -1.
    //Check if frequency has only 1 odd charcount, otherwise might be something like "cacbc"

    private static boolean canBeAPalindrome(String s){
        char[] str = s.toLowerCase().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int charCount = 0, oddCount = 0;

        for(char i : str){
            if(i != ' '){
                if(map.get(i) == null){
                    map.put(i, 1);
                    charCount++;
                }
                else{
                    map.put(i, map.get(i) + 1);
                    charCount++;
                }
            }
        }

        for(char i : str){
            if(i != ' ' && map.get(i)%2 == 1){
                oddCount++;
            }
        }

        return charCount%2 != 0 && oddCount == 1;
    }

    public static void main(String[] args){
        System.out.println(canBeAPalindrome("Tact Coa")); //true
        System.out.println(canBeAPalindrome("a ba")); //true
        System.out.println(canBeAPalindrome("bbbab")); //true
        System.out.println(canBeAPalindrome("ccc ba")); //false
        System.out.println(canBeAPalindrome("nope wont work")); //false
    }

}
