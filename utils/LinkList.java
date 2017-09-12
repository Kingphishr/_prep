package utils;

/**
 * Created by aatifshah on 9/11/17.
 */
public class LinkList<T> {
    private Node<T> pointer, head = null;

    public void push(Node<T> n){
        if(head == null){
            head = n;
            pointer = head;
        }

        pointer.next = n;
        pointer = pointer.next;
    }

    public Node getHead(){
        return  head;
    }
}
