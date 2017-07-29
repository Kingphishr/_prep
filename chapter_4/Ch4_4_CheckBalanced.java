package chapter_4;

/**
 * Created by aatifshah on 7/28/17.
 *
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a
 * balanced tree is defined to be a tree such that the heights of any two subtrees doesn't differ by one.
 */
public class Ch4_4_CheckBalanced {

    public static void main(String[] args){
        int[] fail = new int[]{5,4,6,7,8,9};
        int[] pass = new int[]{2,3,1};


        System.out.println(isBalanced(buildBST(fail)));
        System.out.println(isBalanced(buildBST(pass)));

    }

    private static boolean isBalanced(Node root){
        final boolean[] x = {true};
        check(root, () -> x[0] = false);
        return x[0];
    }

    private static int check(Node a, callback c) {
        int height = 1;
        int right = 0;
        int left = 0;

        if (a.right != null) right = right + check(a.right, c);

        if (a.left != null) left = right + check(a.left, c);

        if (a.right == null && a.left == null) {
            return 1;
        }

        if (Math.abs(right - left) > 1)
            c.failed();

        return Math.max(right, left) + height;
    }


    private static Node buildBST(int[] arr){
        Node root = new Node(arr[0]);

        for(int i = 1; i < arr.length; i++){
            buildNode(root, arr[i]);
        }

        return root;
    }

    private static void buildNode(Node a, int d){
        //go right
        if(a.data < d){
            if(a.right == null){
                a.right = new Node(d);
            } else {
                buildNode(a.right, d);
            }
        }
        //go left
        if(a.data > d){
            if(a.left == null){
                a.left = new Node(d);
            } else {
                buildNode(a.left, d);
            }
        }
    }

    private interface callback{
        void failed();
    }

    private static class Node{
        Node left;
        Node right;
        int data;

        public Node(int d){
            data = d;
        }
    }
}


