package com.acubenchik;

import java.util.Stack;

/**
 * Created by acubenchik on 14.04.2019.
 */
public class DFS {
    private  Graph g;
    private int source;
    public boolean [] visited;
    public int[] edgeTo;

    public DFS(Graph g, int source) {
        this.source = source;
        this.g = g;
        visited = new boolean[g.matrix.size()];
        edgeTo = new int[g.matrix.size()];
    }

    public void dfs(int source) {
        visited[source] = true;
        for(int a: g.matrix.get(source)) {
            if(!visited[a]) {
                edgeTo[a] = source;
                dfs(a);
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
        DFS dfs = new DFS(new Graph(), 0);
        dfs.dfs(0);
        System.out.println(dfs.pathTo(4));
    }
}
