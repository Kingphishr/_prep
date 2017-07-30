package chapter_3;

/**
 * Created by aatifshah on 7/29/17.
 * # Write a program to sort a stack such that the smallest items are on the top.
 # You may use at most one additional stack to hold items, but you may not copy
 # the elements into any other data structure (such as an array). The stack
 # supports the following operations: push, pop, peek, and isEmpty.
 */
public class CH3_5_SortedStacks {

    public static void main(String[] args){
        SortedStack test = new SortedStack();

        test.push(5);
        test.push(9);
        test.push(3);
        test.push(2);

        while(!test.isEmpty()){
            System.out.println(String.valueOf(test.pop()));
        }

    }

    private static class SortedStack{
        Stack<Integer> main = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        public void push(int data){
            boolean placed = false;
            while(!main.isEmpty()){
                int val = main.pop();
                if(val > data){
                    main.push(val);
                    main.push(data);
                    placed = true;
                    break;
                } else {
                    temp.push(val);
                }
            }

            if(!placed) main.push(data);

            while(!temp.isEmpty())
                main.push(temp.pop());

        }

        public int pop(){
            return main.pop();
        }

        public int peek(){
            return main.peek();
        }

        public boolean isEmpty(){
            return main.isEmpty();
        }
    }
}
