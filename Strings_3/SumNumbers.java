package Strings_3;

/**
 * Created by aatifshah on 11/5/17.
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SumNumbers {
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

        if(foundNumber) sum += Integer.parseInt(str.substring(startIndex));
        return sum;
    }
}

class TestSumNumbers {

    @Test
    void sumNumbersTest(){
        SumNumbers test = new SumNumbers();

        Assertions.assertEquals(123, test.sumNumbers("abc123xyz"));
        Assertions.assertEquals(44, test.sumNumbers("aa11b33"));
        Assertions.assertEquals(18, test.sumNumbers("7 11"));

    }
}
