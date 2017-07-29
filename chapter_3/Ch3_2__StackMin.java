package chapter_3;


/**
 * Created by aatifshah on 10/20/16.
 * Problem 3.2
 *
 * Design a stack which, in addition to push and pop,
 * also has a function min which returns the minimum element.
 * Push, pop and min should all operate in O(1) time
 */
public class Ch3_2__StackMin {
    public static void main(String[] args){
        Min_Int_Stack test = new Min_Int_Stack();
        test.push(5);
        test.push(4);
        test.push(2);
        test.push(9);
        test.push(90);
        test.push(90);
        test.push(1);
        System.out.println(test.min()); // Output = 1
        test.pop();
        test.pop();
        System.out.println(test.min()); // Output = 2


        node_min_stack<Integer> test2 = new node_min_stack<>();
        test2.push(5);
        test2.push(4);
        test2.push(2);
        test2.push(9);
        test2.push(90);
        test2.push(90);
        test2.push(1);
        System.out.println(test2.min()); // Output = 1
        test2.pop();
        test2.pop();
        System.out.println(test2.min()); // Output = 2
    }
}

class Min_Int_Stack{
    private int[] mainStack;
    private int[] minStack;
    private int pointer = 0;
    private int minPointer = 0;

    public Min_Int_Stack(){
        this(10);
    }

    public Min_Int_Stack(int size){
        this.mainStack = new int[size];
        this.minStack = new int[size];
    }

    public void push(int i){
        //check if first element, if so min is the first element. Add to minstack;
        if(pointer == 0){
            this.minStack[minPointer] = i;
            minPointer++;
        }
        //check if i is smaller than min, if so i is the new min
        if(i < minStack[minPointer - 1 ]){
            this.minStack[minPointer] = i;
            minPointer++;
        }
        //normal push
        if(pointer < mainStack.length){
            mainStack[pointer]  = i;
            pointer++;
        }
        else
            System.out.println("Stack Full");
    }

    public void pop(){
        if(pointer - 1 >= 0){
            //check if top of main stack is top of min stack
            if(mainStack[pointer - 1] == minStack[minPointer -1]){
                minStack[minPointer - 1] = 0;
                minPointer--;
            }
            //normal pop
            mainStack[pointer - 1] = 0;
            pointer--;
        }
    }

    public int min(){
        //basically a peek on the min stack
        if(minPointer - 1 >= 0)
            return minStack[minPointer - 1];
        else
            return -1;
    }
}

class node_min_stack<T extends Comparable>{
    private node<T> main = new node<>(null);
    private node<T> min = new node<>(null);
    node<T> temp;
    node<T> minTemp;


    //push
    public void push(T data){
        if(main.data == null){
            main.data = data;
            min.data = data;
        }
        else{
            temp = new node<T>(data);
            temp.next = main;
            main = temp;

            if(min.data.compareTo(data) == 1){
                minTemp = new node<T>(data);
                minTemp.next = min;
                min = minTemp;
            }
        }
    }
    //pop
    public T pop(){
        if(main.data.compareTo(min.data) == 0)
            min = min.next;
        node<T> temp = main.next;
        main = main.next;
        return temp.data;
    }

    //
    public T min(){
        return min.data;
    }
}

class node<T>{
    public T data;
    public node next;
    public node(T data){
        this.data = data;
    }

}

