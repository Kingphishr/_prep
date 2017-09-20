package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by aatifshah on 9/13/17.
 */
public class BinaryTree {

    BinaryNode root = null;

    public void add(int data){
        if(root == null){
            root = new BinaryNode(data);
            return;
        }

        BinaryNode p = root;
        boolean placeFound = false;
        while(!placeFound){
            if(p.data < data){  // go right
                if(p.right == null){
                    p.right = new BinaryNode(data);
                    placeFound = true;
                }

                p = p.right;
            } else {                // go left
                if(p.left == null){
                    p.left = new BinaryNode(data);
                    placeFound = true;
                }
                p = p.left;
            }
        }

    }

    public void add(int[] data){
        for(int i : data){
            add(i);
        }
    }

    public BinaryNode getRoot(){
        return root;
    }


    private void BFT(Node n){
        Queue<Integer> queue = new PriorityQueue<>();

    }


}

class test_BinaryTree{
    BinaryTree test;

    @BeforeEach
    void init(){
       test = new BinaryTree();
    }

    @Test
    void testAdd(){
        test.add(3);
        Assertions.assertEquals(3, test.getRoot().data);
        test.add(4);
        Assertions.assertEquals(4, test.getRoot().right.data);
    }
}
