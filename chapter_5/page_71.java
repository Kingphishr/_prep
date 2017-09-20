package chapter_5;

/**
 * Created by aatifshah on 9/19/17.
 *
 * preorder traversal without recursion.. gaddaaaaaaaamit
 *
 *
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.*;
import java.util.ArrayList;

public class page_71 {

    public static ArrayList<Integer> preorderWithoutRecursion(BinaryNode root){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode pointer = root;

        while(!(stack.isEmpty() && pointer == null)){
            if(pointer != null){
                list.add(pointer.data);
                if(pointer.right != null)
                    stack.push(pointer.right);
                pointer = pointer.left;
            } else {
                pointer = stack.pop();
            }
        }
        return list;
    }

}

class test_page_71{
    BinaryTree test;

    @BeforeEach
    void init(){
        test = new BinaryTree();
    }

    @Test
    void test_preOrder(){
        int[] testdat = new int[]{100,50,25,75,150,125,110,175};

        test.add(testdat);

        ArrayList<Integer> output = page_71.preorderWithoutRecursion(test.getRoot());

        int[] outputArr = new int[output.size()];
        for(int i = 0; i < outputArr.length; i++)
            outputArr[i] = output.get(i);

        Assertions.assertArrayEquals(testdat, outputArr);

    }
}

