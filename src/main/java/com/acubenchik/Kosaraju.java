package com.acubenchik;

import java.util.Deque;
import java.util.Queue;

/**
 * Created by acubenchik on 15.04.2019.
 */
public class Kosaraju {

    private final DiGraph graph;

    public Kosaraju(DiGraph graph) {
        this.graph = graph;
    }

    public void kosaraju(){
        Deque<Integer> result = new DirectedDFS(graph, 0).reversePost;
        DiGraph reversed = graph.reverse(this.graph);
        while(!result.isEmpty()) {
            //visited should be global
            //Queue<Integer> group = new DirectedDFS(reversed, element).pre;
            //System.out.println(group);
            //result.removeAll(group);
        }
    }

    class DFSKosaraju {

    }



    public static void main(String[] args) {
        new Kosaraju(new DiGraph()).kosaraju();
    }
}
