package chapter_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.BinaryNode;
import utils.BinaryTree;

import java.util.ArrayList;

/**
 * Created by aatifshah on 9/18/17.
 */
public class page_70 {

    public static ArrayList<Integer> preOrder(BinaryNode node, ArrayList<Integer> list){
        if(list == null) list = new ArrayList<>();

        if(node != null){
            //parent
            list.add(node.data);
            //left
            preOrder(node.left, list);
            //right
            preOrder(node.right, list);
        }

        return list;
    }
}


class test_page_70{
    BinaryTree test;

    @BeforeEach
    void init(){
        test = new BinaryTree();
    }

    @Test
    void test_preOrder(){
        int[] testdat = new int[]{100,50,25,75,150,125,110,175};

        test.add(testdat);

        ArrayList<Integer> output = page_70.preOrder(test.getRoot(), null);

        int[] outputArr = new int[output.size()];
        for(int i = 0; i < outputArr.length; i++){
            outputArr[i] = output.get(i);
        }

        Assertions.assertArrayEquals(testdat, outputArr);




    }
}
