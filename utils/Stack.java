package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.asserts.Assertion;

/**
 * Created by aatifshah on 9/19/17.
 */
public class Stack<T> {
    private T[] arr;
    private int pointer;

    private static final int DEFAULT_SIZE = 10;

    public Stack(){
        pointer = -1;
        arr = (T[]) new Object[DEFAULT_SIZE];
    }

    public void push(T data){
        pointer += 1;

        if(pointer == arr.length)
            resize();

        arr[pointer] = data;
    }

    public T pop(){

        if(pointer == -1) return null;

        T p = arr[pointer];

        pointer -= 1;

        return p;
    }


    public int size(){
        return pointer+1;
    }

    public boolean isEmpty(){
        return pointer < 0;
    }

    private void resize(){
        int newSize = arr.length + DEFAULT_SIZE;

        T[] temp = (T[]) new Object[newSize];

        for(int i = 0; i < arr.length; i++)
            temp[i] = arr[i];

        arr = temp;
    }

}


class test_Stack{
    Stack<String> test;

    @BeforeEach
    void init(){
        test = new Stack<>();
    }

    @Test
    void test_stack(){
        test.push("a");
        test.push("b");

        Assertions.assertEquals("b" , test.pop());
    }

    @Test
    void test_resize(){
        test.push("a");
        test.push("a");
        test.push("a");
        test.push("a");
        test.push("a");
        test.push("a");
        test.push("a");
        test.push("a");
        test.push("a");
        test.push("a");
        // max size reached

        test.push("b"); // exceed stack size

        //new length should now be 20
        Assertions.assertEquals(11, test.size());

        Assertions.assertEquals("b", test.pop());
    }

    @Test
    void test_isEmpty(){
        Assertions.assertEquals(true, test.isEmpty());

        test.push("a");
        Assertions.assertEquals(false, test.isEmpty());

        test.pop();
        Assertions.assertEquals(true, test.isEmpty());
    }
}

