package chapter_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.LinkList;
import utils.Node;

import java.awt.*;

/**
 * Created by aatifshah on 9/9/17.
 *
 * Partition nodes in linked list around a value such that all nodes with less or equal to value x are before it.
 *
 *
 * The algorithm outlined below operates in O(n) space and takes O(1) space
 *
 *
 */
public class Ch2_4__Partition {


    public static void partition(Node<Integer> head, int pValue){
        Node end = getTail(head);
        Node tail = end;

        Node<Integer> pointer = head;
        while(pointer != end){
            if(pointer.data >= pValue){
                tail.next = new Node<>(pointer.data);
                tail = tail.next;

                Node temp = pointer.next;
                pointer.next = temp.next;
                pointer.data = (Integer) temp.data;

                temp = null;

            } else {
                pointer = pointer.next;
            }
        }
    }


    public static Node<Integer> getTail(Node<Integer> head){
        Node tail = head;
        while(tail.next != null)
            tail = tail.next;
        return tail;
    }


    public static void printList(Node<Integer> head){
        Node pointer = head;
        while(pointer.next != null){
            System.out.println(String.valueOf(pointer.data));
            pointer = pointer.next;
        }
        System.out.println(String.valueOf(pointer.data));
    }


}


class testCh2_4__pPartition{

    LinkList<Integer> list = new LinkList<>();

    @BeforeEach
    public void init(){

        list.push(new Node<>(3));
        list.push(new Node<>(5));
        list.push(new Node<>(8));
        list.push(new Node<>(5));
        list.push(new Node<>(10));
        list.push(new Node<>(2));
        list.push(new Node<>(1));


    }

    @Test
    public void testPartition(){
        Ch2_4__Partition.partition(list.getHead(), 5);

        Ch2_4__Partition.printList(list.getHead());

    }

    @Test
    public void testPrintList(){
        Ch2_4__Partition.printList(list.getHead());
    }


}
