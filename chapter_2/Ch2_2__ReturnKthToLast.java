package chapter_2;

import utils.*;

/**
 * Created by LAViATHoR on 10/19/2016.
 * Problem 2.2
 *
 * Find kth from last
 *
 */

public class Ch2_2__ReturnKthToLast {

    private static LinkNode findKthFromLast(LinkNode node, int k){
        // set up runner
        LinkNode runner = node;
        for (int i = 1; i < k; i++){
            if(runner.next != null){
                runner = runner.next;
            }
            else
                return new LinkNode("Not Possible Watson");
        }

        //while runner ! null
        while(runner.next != null){
            node = node.next;
            runner = runner.next;
        }
        return node;
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList("Start");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");
        list.add("Fifth");

        LinkNode test = findKthFromLast(list.getHead(), 6);
        System.out.println(test.getData());
    }

}
