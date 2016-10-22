package ctci;

import java.util.ArrayList;

/**
 * Created by aatifshah on 10/21/16.
 * Problem 3.3
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOf Stacks that mimics this. SetOfStacks should be composed of several stacks and
 * should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
 * (that is, pop() should return the same values as it would if there were just a single stack).
 *
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */
public class Ch3_3__StackOfPlates {
    public static void main(String[] args){
        SetOfStacks<Integer> test = new SetOfStacks<>();

        test.push(1);
        test.push(1);
        test.push(1);
        System.out.println(test.numOfStacks());
        test.push(2);
        test.push(2);
        test.push(2);
        System.out.println(test.numOfStacks());
        test.push(3);
        System.out.println(test.numOfStacks());
        test.pop();
        test.pop();
        System.out.println(test.numOfStacks());

        System.out.println(test.popAt(0));


    }

}
class SetOfStacks<T>{
    private ArrayList<Stack> stacks = new ArrayList<>();
    int currentStack;
    int numOfStacks;
    int stackSize;

    public SetOfStacks(){
        this(3);
    }

    public SetOfStacks(int stackSize){
        stacks.add(new Stack<T>(stackSize));
        this.stackSize = stackSize;
        numOfStacks = 1;
        currentStack = 0;
    }
    //push
    public void push(T data){
        if(stacks.get(currentStack).isFull()){
            stacks.add(new Stack<T>(stackSize));
            currentStack++; numOfStacks++;
            stacks.get(currentStack).push(data);
        }
        else {
            stacks.get(currentStack).push(data);
        }
    }
    //pop
    public T pop(){
        if(stacks.get(currentStack).isEmpty()){
            currentStack--; numOfStacks--;
        }
        return (T)stacks.get(currentStack).pop();
    }
    //popAt
    public T popAt(int index){
        if(index < stacks.size())
            return (T) stacks.get(index).pop();
        return null;
    }
    //Total number of stacks
    public int numOfStacks(){
        return numOfStacks;
    }

}
class Stack<T>{
    ArrayList<T> stack;
    private int size;
    private int pointer = 0;

    public Stack(){
        this(10);
    }

    public Stack(int size){
        this.stack = new ArrayList<>(size);
        this.size = size;
    }
    //push
    public void push(T data){
        if(pointer < size)
            stack.add(pointer, data);
        pointer++;
    }
    //pop
    public T pop(){
        T temp;
        if(pointer > 0){
            temp = stack.get(pointer-1);
            pointer--;
        }
        else
            temp = stack.get(pointer);
        return temp;
    }
    //peek
    public T peek(){
        return stack.get(pointer);
    }

    //isFull
    public boolean isFull(){
        return pointer == size;
    }

    //isEmpty
    public boolean isEmpty(){
        return pointer==0;
    }
}


