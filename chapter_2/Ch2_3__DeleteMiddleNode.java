package chapter_2;

import utils.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by aatifshah on 9/9/17.
 */
public class Ch2_3__DeleteMiddleNode {

    public static void deleteNode(Node rip){
        if(rip.next == null || rip.next.next == null) return;
        rip.data = rip.next.data;
        rip.next = rip.next.next;
    }

}


class Ch2_3__Test{

    Node<Integer> head = new Node<>(1);
    Node<Integer> second = new Node<>(2);
    Node<Integer> third = new Node<>(3);


    @BeforeEach
    public void init(){
        head.next = second;
        second.next = third;
    }

    @Test
    public void testDeleteNode(){
        Ch2_3__DeleteMiddleNode.deleteNode(second);

        Node<Integer> pointer = head;
        while(pointer.next != null){
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }
}

