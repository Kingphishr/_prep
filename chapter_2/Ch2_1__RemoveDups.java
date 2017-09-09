package chapter_2;


import java.util.HashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by aatifshah on 9/9/17.
 *
 * Remove duplicates from linked list
 *
 * FOLLOW UP
 *
 * to do this without using buffers to keep track of seen values, you would need to basically have a runner foreach value (read O(n^2))
 *
 *
 */
public class Ch2_1__RemoveDups {

    public static void removeDups(Node head){
        if(head.next == null)
            return;

        Node pointer = head.next;
        Node previous = head;
        HashSet<Integer> set = new HashSet<>();

        while(pointer.next != null){
            if(set.contains(pointer.data)){ // found dup
                previous.next = pointer.next;
                pointer = null;
            } else {
                previous = previous.next;
                set.add(pointer.data);
            }

            pointer = pointer.next; //increment pointer
        }

    }

}

class Node{
    int data;
    Node next = null;

    public Node(int d){
        this.data = d;
    }
}

class Ch2_1_Test {
    Node head = new Node(1);
    Node second = new Node(2);
    Node third = new Node(3);
    Node fourth = new Node(3);


    @BeforeEach
    public void setUp(){

        head.next = second;
        second.next = third;
        third.next = fourth;
    }


    @Test
    public void testRemoveDups(){
        Ch2_1__RemoveDups.removeDups(head);

        Node p = head;
        while(p.next != null){
            System.out.println(String.valueOf(p.data));
            p = p.next;
        }
        Assertions.assertEquals(1, head.data);
        Assertions.assertEquals(2, second.data);
        Assertions.assertEquals(3, fourth.data);


    }




}
