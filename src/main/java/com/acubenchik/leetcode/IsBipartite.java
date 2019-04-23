package com.acubenchik.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/is-graph-bipartite/
public class IsBipartite {

    public static void main(String[] args) {
        System.out.println( new IsBipartite().isBipartite(new int[][]{
//                {2,3,5,6,7,8,9},{2,3,4,5,6,7,8,9},{0,1,3,4,5,6,7,8,9},
////        {0,1,2,4,5,6,7,8,9},{1,2,3,6,9},{0,1,2,3,7,8,9},{0,1,2,3,4,7,8,9},{0,1,2,3,5,6,8,9},{0,1,2,3,5,6,7},{0,1,2,3,4,5,6,7}
                {1,3},
                {0,2},
                {1,3},
                {0,2}

        }));
    }

    public boolean isBipartite(int[][] graph) {
        boolean [] visited = new boolean[graph.length];
        boolean [] color = new boolean[graph.length];
        boolean []isBi = new boolean[]{true};
        for (int s = 0; s < graph.length; s++)
            if (!visited[s])
                dfs(s, graph, visited, color, isBi);

        return isBi[0];
    }

    public void dfs(int source, int[][] adjList, boolean [] visited, boolean [] color, boolean[] isBi) {
        visited[source] = true;
        for (int child : adjList[source]) {
            if (!visited[child]) {
                color[child] = !color[source];
                dfs(child, adjList, visited, color, isBi);
            } else if (color[source] == color[child]) {
                isBi[0] = false;
            }

        }
    }


}
