package chapter_4;

/**
 * Created by aatifshah on 10/25/16.
 * Problem 4.2
 * Given a sorted, unique array, create a balanced BST
 */
public class Ch4_2__MinimalTree<T extends Comparable> {

    //since its already sorted, you know where to choose your root node (n/2)
    //then just build the tree from the leftover array keeping in mind it's a inorder representation.
    public static void main(String[] args){
        Integer[] array = new Integer[] {0,1,2,3,4,5,6};
        BST<Integer> test = new BST<Integer>(array);
        test.print();


    }

    private static class BST<T extends Comparable> {
        Node root;
        T[] array;

        public BST(T[] a){
            array = a;
            root = new Node(array[array.length/2]);
            root.left = buildBST(0, array.length/2 - 1);
            root.right = buildBST(array.length/2 + 1, array.length - 1);
        }


        public Node buildBST(int start, int end){
            System.out.println(start + ":" + end);
            if(start == end)
                return new Node(array[start]);

            int i = start + (end - start)/2;
            Node newParent = new Node(array[i]);
            if(i!=start)
                newParent.left = buildBST(start, i-1);
            if(i!=end)
                newParent.right = buildBST(i+1, end);
            return newParent;
        }

        public void print(){
            printBST(root);
        }

        private void printBST(Node parent){
            if(parent != null){
                printBST(parent.left);
                System.out.print(" " + parent.data + " ");
                printBST(parent.right);
            }
        }



    }
    private static class Node<T extends Comparable>{
        T data;
        Node right;
        Node left;
        public Node(T data){
            this.data = data;
            right = left = null;
        }
    }
}

