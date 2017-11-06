package Strings_3;

/**
 * Created by aatifshah on 11/5/17.
 */
public class sumNumbers {
    public int sumNumbers(String str) {
        int sum = 0, startIndex = 0, endIndex = 0;
        boolean foundNumber = false;
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                if(!foundNumber){
                    foundNumber = true;
                    startIndex = i;
                }
            } else {
                if(foundNumber){
                    endIndex = i;
                    sum += Integer.parseInt(str.substring(startIndex, endIndex));
                    foundNumber = false;
                }
            }
        }
        return sum;
    }
}

