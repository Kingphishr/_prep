package chapter_3;

/**
 * Created by aatifshah on 7/29/17.
 *
 * Make a queue with two stacks.
 *
 */

public class Ch3_4_QueueViaStacks {
    public static class MyQueue<T> {
        Stack<T> mainStack = new Stack<T>();
        Stack<T> tempStack = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            mainStack.push(value);
        }

        public T peek() {
            if(tempStack.isEmpty()){
                while(!mainStack.isEmpty())
                    tempStack.push(mainStack.pop());
            }

            return tempStack.peek();
        }

        public T dequeue() {
            if(tempStack.isEmpty()){
                while(!mainStack.isEmpty())
                    tempStack.push(mainStack.pop());
            }

            return tempStack.pop();
        }

    }
}
