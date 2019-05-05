package com.acubenchik.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/minimum-height-trees/
public class MinimumHeightTree {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            if(adjList.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while(n>2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbor = adjList.get(leaf).iterator().next();
                adjList.get(neighbor).remove(leaf);

                if (adjList.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            leaves = newLeaves;
        }
        return leaves;

    }
}
