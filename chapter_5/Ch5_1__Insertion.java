package chapter_5;

/**
 * Created by LAViATHoR on 10/26/2016.
 * Problem 5.1
 *
 * insert smaller int into larger int binary
 */
public class Ch5_1__Insertion {
    public static void main(String args[]) {

        int N = Integer.parseInt("10000000000",2);
        int M = Integer.parseInt("10011",2);

        int test = insertInside(M, N, 2, 6);
        System.out.println(Integer.toBinaryString(test));
    }


    // Insertion method
    private static int  insertInside(int M, int N, int i, int j){
        // make left mask: 11111111111111111111111110000000
        int leftMask = ~0 << j + 1;

        // make right mask: 00000000000000000000000000000011
        int rightMask = 0;
        for(int k = 0; k < i; k++)
            rightMask = rightMask | (1 << k);

        // combine both to make mask: 11111111111111111111111110000011
        int mask = leftMask | rightMask;

        return (N & mask) | (M << i);
    }

}
