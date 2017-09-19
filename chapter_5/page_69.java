package chapter_5;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.BinaryNode;
import utils.BinaryTree;

/**
 * Created by aatifshah on 9/15/17.
 */
public class page_69 {
    // give back greatest height of children subtrees + 1 for self height
    public static int getHeight(BinaryNode parent){
        if(parent == null) return 0;
        //System.out.println(String.valueOf(parent.data));
        return 1 + Math.max(getHeight(parent.left), getHeight(parent.right));
    }


}

class test_page_69{
    BinaryTree test;

    @BeforeEach
    void init(){
        test = new BinaryTree();
    }

    @Test
    void test_getHeight(){
        test.add(3);
        test.add(1);
        test.add(2);

        Assertions.assertEquals(3, page_69.getHeight(test.getRoot()));
    }


}
