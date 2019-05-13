package com.acubenchik.leetcode.uf;

import java.util.HashSet;
import java.util.Set;


//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
public class RemoveStones {

    public static void main(String[] args) {
        new RemoveStones().removeStones(new int[][]{{0,0}, {0,2}, {1,1}, {2,0}, {2,2}});
    }

    public int removeStones(int[][] stones) {

        int [] sets = new int[2000];
        for (int i = 0; i < 2000; ++i)
            sets[i] = i;

        for(int [] el : stones) {
            union(sets, el[0], el[1]+1000);
        }
        Set<Integer> roots = new HashSet<>();
        for(int [] el : stones) {
            int parent = find(sets, el[0]);
            roots.add(parent);
        }

        return stones.length - roots.size();
    }


    private void union(int[] sets, int i, int j) {
        int iRoot = find(sets, i);
        int jRoot = find(sets, j);
        sets[iRoot] = jRoot;
    }

    private int find(int [] sets, int i) {
        while(sets[i] != i) i = sets[i];
        return i;
    }

}
