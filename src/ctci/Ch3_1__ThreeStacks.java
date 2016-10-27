package ctci;

import java.lang.reflect.Array;

/**
 * Created by LAViATHoR on 10/27/2016.
 * Problem 3.1
 * How would you implement three stacks that use the same array?
 *
 */
public class Ch3_1__ThreeStacks {
    public static void main(String[] args){
        ThreeStack<Integer> test = new ThreeStack<>(10);
        test.pushAt(1,1);
        test.pushAt(1,1);
        test.pushAt(1,1);
        System.out.println(test.popAt(1));
        System.out.println(test.popAt(1));
        System.out.println(test.popAt(1));
        System.out.println(test.popAt(1));

        test.pushAt(2,2);
        test.pushAt(2,2);
        test.pushAt(2,2);
        test.pushAt(2,2);

        test.pushAt(3,3);
        test.pushAt(3,3);
        test.pushAt(3,3);
        test.pushAt(3,3);

        /* OUTPUT

        1
        1
        1
        Sub-Stack 1 is Empty : null
        Sub-Stack 2 is Full
        Sub-Stack 3 is Full

        */
    }


    private static class ThreeStack <T extends Comparable> {
        private Object[] array;
        int stacksize, p1, p2, p3;

        public ThreeStack(int size){
            stacksize = size/3;
            p1 = 0;
            p2 = stacksize;
            p3 = stacksize*2;
            array = new Object[size];
        }

        private void pushAt(T a, int stack_index){
            switch (stack_index){
                case 1:
                    if(p1 < stacksize){
                        array[p1] = a;
                        p1++;
                    }
                    else
                        System.out.println("Sub-Stack 1 is Full");
                    break;
                case 2:
                    if(p2 < stacksize*2){
                        array[p2] = a;
                        p2++;
                    }
                    else
                        System.out.println("Sub-Stack 2 is Full");
                    break;
                case 3:
                    if(p3 < stacksize*3){
                        array[p3] = a;
                        p3++;
                    }
                    else
                        System.out.println("Sub-Stack 3 is Full");
                    break;
            }
        }

        private T popAt(int stack_index){
            T value = null;
            switch (stack_index){
                case 1:
                    if(p1 > 0){
                        p1--;
                        value = (T) array[p1];
                        array[p1] = null;
                    }
                    else
                        System.out.print("Sub-Stack 1 is Empty : ");
                    return value;
                case 2:
                    if(p2 > stacksize){
                        p2--;
                        value = (T) array[p2];
                        array[p2] = null;
                    }
                    else
                        System.out.print("Sub-Stack 1 is Empty : ");
                    return value;
                case 3:
                    if(p3 > stacksize*2){
                        p3--;
                        value = (T) array[p3];
                        array[p3] = null;
                    }
                    else
                        System.out.print("Sub-Stack 1 is Empty : ");
                    return value;
            }
            return value;
        }
    }
}
