package chapter_4;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by LAViATHoR on 10/24/2016.
 * Problem 4.1
 * Design an algorithm to find out whether theres a route between two nodes
 */
public class Ch4_1__RouteBetweenNodes {
    public static Graph graph = new Graph(6);
    public static NodeGraph<String> nodegraph = new NodeGraph<>();

    public static void main(String[] args){
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(2,5);

        System.out.println(graph.findPath(0,3)); //true
        System.out.println(graph.findPath(0,5)); //false


        nodegraph.addNode("A", "B");
        nodegraph.addNode("A", "C");
        nodegraph.addNode("B", "D");
        nodegraph.addNode("E", "F");

        System.out.println(nodegraph.findPath("A", "D"));// doesnt work yet

    }
}
class Graph{
    private ArrayList<Integer>[] adj_list;
    private boolean[] visited;
    private java.util.LinkedList<Integer> queue;

    Graph(int nodes){
        adj_list = new ArrayList[nodes];
        visited = new boolean[nodes];
        for(int i = 0; i < nodes; i++){
            adj_list[i] = new ArrayList<Integer>();
            visited[i] = false;
        }
    }

    void addEdge(int x, int y){
        adj_list[x].add(y);
    }


    boolean findPath(int node_A, int node_B){
        visited[node_A] = true;

        queue = new LinkedList<>();
        queue.add(node_A);

        while (!queue.isEmpty()){
            int r = queue.removeFirst();
            if (r == node_B)
                return true;
            for(int i: adj_list[r]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return false;
    }
}


class NodeGraph<T extends Comparable>{
    private HashMap<T, Node<T>> map = new HashMap<>();
    private LinkedList<Node<T>> queue;

    void addNode(T name, T child){
        if(!map.containsKey(name))
            map.put(name, new Node<T>(name));
        map.get(name).children.add(new Node<T>(child));

    }

    boolean findPath(T start, T end){
        map.get(start).visited = true;

        queue = new LinkedList<>();
        queue.add(map.get(start));

        while(!queue.isEmpty()){
            Node<T> r = queue.removeFirst();
            if(r.name.equals(end))
                return true;

            for(Node i : r.children){
                System.out.println(i.name);
                if(!i.visited) {
                    i.visited = true;
                    queue.add(i);
                }
            }

        }
        return false;
    }


}
class Node<T extends Comparable>{
    T name;
    ArrayList<Node<T>> children = new ArrayList<>();
    boolean visited;

    public Node(T a){
        name = a;
        visited = false;
    }
}
