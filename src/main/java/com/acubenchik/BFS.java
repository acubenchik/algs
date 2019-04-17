package com.acubenchik;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by acubenchik on 14.04.2019.
 */
public class BFS {

    private  Graph g;
    private int source;
    public boolean [] visited;
    public int[] edgeTo;

    public BFS(Graph g, int source) {
        this.source = source;
        this.g = g;
        visited = new boolean[g.matrix.size()];
        edgeTo = new int[g.matrix.size()];
    }

    public void bfs(int source) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[source] = true;
        queue.offer(source);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int a : g.matrix.get(current)) {
                if(!visited[a]) {
                    edgeTo[a] = current;
                    visited[a] = true;
                    queue.offer(a);
                }
            }
        }
    }

    public Iterable<Integer> pathTo(int v)
    {
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != source; x = edgeTo[x])
            path.push(x);
        path.push(source);
        return path;
    }

    public static void main(String[] args) {
        BFS dfs = new BFS(new Graph(), 0);
        dfs.bfs(0);
        System.out.println(dfs.pathTo(4));
    }
}
