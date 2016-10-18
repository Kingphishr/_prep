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

public class Ch1_4__Palindrome_Manipulation {
    //Remove spaces and do toLowerCase
    //Check if char count is even, if it is return -1. Otherwise, ja. It can be a palindrome.
    private static boolean canBeAPalindrome(String s){
        char[] str = s.toLowerCase().toCharArray();
        int charCount = 0;

        for(char i : str)
            if(i != ' ')
                charCount++;

        return charCount%2 != 0;
    }

    public static void main(String[] args){
        System.out.println(canBeAPalindrome("Tact Coa")); //true
        System.out.println(canBeAPalindrome("a ba")); //true
        System.out.println(canBeAPalindrome("aababab")); //true
        System.out.println(canBeAPalindrome("nope wont work")); //false
    }

}
