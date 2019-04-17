package com.acubenchik;

import java.util.*;

/**
 * Created by acubenchik on 14.04.2019.
 */
public class DirectedDFS {

    private  DiGraph g;
    private int source;
    public boolean [] visited;
    public int[] edgeTo;
    public boolean[] onStack;
    private Stack<Integer> cycle;

    Queue<Integer> pre = new LinkedList<Integer>();
    Queue<Integer> post = new LinkedList<Integer>();
    Deque<Integer> reversePost = new ArrayDeque<Integer>();

    public DirectedDFS(DiGraph g, int source) {
        this.source = source;
        this.g = g;
        visited = new boolean[g.matrix.size()];
        edgeTo = new int[g.matrix.size()];
        onStack = new boolean[g.matrix.size()];
        cycle = new Stack<Integer>();
        dfs(source);
    }

    public static void main(String[] args) {
        DirectedDFS dfs = new DirectedDFS(new DiGraph(), 0);
//        dfs.dfs(0);
        System.out.println(dfs.cycle());
        System.out.println(dfs.pre);
        System.out.println(dfs.post);
        System.out.println(dfs.reversePost);
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    private void dfs(int source) {
        visited[source] = true;
//        onStack[source] = true;
        pre.add(source);
        for(int a: g.matrix.get(source)) {
            if(!cycle.isEmpty()) {
                return;
            }
            else if(!visited[a]) {
                edgeTo[a] = source;
                dfs(a);
            }
//            else if(onStack[a]) {
//                cycle = new Stack<Integer>();
//                for (int x = source; x != a; x = edgeTo[x])
//                    cycle.push(x);
//                cycle.push(a);
//                cycle.push(source);
//            }
        }
        post.offer(source);
        reversePost.push(source);
//        onStack[source] = false;
    }
}
