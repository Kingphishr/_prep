package chapter_10;

import java.util.Arrays;

/**
 * Created by LAViATHoR on 11/2/2016.
 *
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the
 * end to hold B. Write a method to merge B into A in sorted order.
 *
 * O(a) time
 *
 * O(1) space (no extra space needed)
 */
public class Ch10_1__SortedMerge {

    public static void main(String[] args){
        int[] A = new int[]{1,3,4,0,0};
        int[] B = new int[]{2,4};

        System.out.println(Arrays.toString(mergeSorted(A, B)));

    }


    private static int[] mergeSorted(int[] a, int[] b){
        int pointerA = a.length - b.length - 1;
        int pointerB = b.length - 1;
        int sorted = a.length - 1;
        while(pointerB >= 0){
            if(a[pointerA] > b[pointerB]){
                a[sorted] = a[pointerA];
                sorted--;
                pointerA--;
            }
            else if(a[pointerA] <= b[pointerB]){
                a[sorted] = b[pointerB];
                sorted--;
                pointerB--;
            }
        }

        return a;
    }


}
