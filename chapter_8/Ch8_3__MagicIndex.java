package chapter_8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by aatifshah on 9/22/17.
 *
 * Find i where a[i] == i
 *
 * A. given sorted distinct array
 *
 * B. given sorted not distinct array
 *
 * My algorithm: O(logn) time and O(1) space - not counting provided array
 *
 */
public class Ch8_3__MagicIndex {


    public static int findMagicIndex(int[] arr, int pivot){
        if(pivot < 0) return -1;

        if(arr[pivot] == pivot) return pivot;

        if(arr[pivot] > pivot) return findMagicIndex(arr, pivot - pivot/2 - 1);

        return -1;
    }


    public static int findMagicIndexNotDistinct(int[] arr, int pivot){
        if(pivot > arr.length || pivot < 0) return -1;

        if(arr[pivot] == pivot){
            System.out.println(String.valueOf(pivot) + ":" + String.valueOf(arr[pivot]));
            return pivot;
        }

        if(arr[pivot] > 0 && arr[arr[pivot]] == arr[pivot])
            return findMagicIndexNotDistinct(arr, arr[pivot]);

        else if(arr[pivot] < pivot)
            return findMagicIndexNotDistinct(arr, pivot + Math.max(1, pivot/2));

        else if(arr[pivot] > pivot)
            return findMagicIndexNotDistinct(arr, pivot - Math.max(1, pivot/2));

        return -1;
    }


}

class Test_MagicIndex{
    int[] arr, notdistarr;


    @BeforeEach
    public void init(){
        arr = new int[]{0,1,2,6,7,8};
        notdistarr = new int[]{1,1,1,5,5,5};
    }

    @Test
    public void test_findMagicIndex(){
        int output = Ch8_3__MagicIndex.findMagicIndex(arr, arr.length/2);
        System.out.println(String.valueOf(output));
    }

    @Test
    void test_findMagicIndexNotDistinct(){
        int output = Ch8_3__MagicIndex.findMagicIndexNotDistinct(notdistarr, notdistarr.length/2);
        System.out.println(String.valueOf(output));
    }
}
