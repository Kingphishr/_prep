package utils;

/**
 * Created by LAViATHoR on 10/19/2016.
 *
 * Simple Linked list
 */
public class LinkedList {
    private LinkNode head;

    public LinkedList(String item){
        head = new LinkNode(item);
    }

    public void add(String item){

        LinkNode node = head;
        while(node.next != null){
            node = node.next;
        }

        node.next = new LinkNode(item);
    }

    public LinkNode getHead(){
        return head;
    }

}

