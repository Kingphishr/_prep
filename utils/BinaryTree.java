package utils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by aatifshah on 9/13/17.
 */
public class BinaryTree {

    Node root = null;

    public void add(int data){
        if(root == null) root = new Node(data);

        Node p = root;
        boolean placeFound = false;
        while(!placeFound){
            if(p.data >= data){  // go right
                if(p.right == null){
                    p.right = new Node(data);
                    placeFound = true;
                }

                p = p.right;
            } else {                // go left
                if(p.left == null){
                    p.left = new Node(data);
                    placeFound = true;
                }
                p = p.left;
            }
        }
    }

    public void breadthFirstTraversal(){

    }

    private void BFT(Node n){
        Queue<Integer> queue = new PriorityQueue<>();



    }

    private class Node{
        Node left, right;
        int data;

        public Node(int d){
            data = d;
        }
    }

}


