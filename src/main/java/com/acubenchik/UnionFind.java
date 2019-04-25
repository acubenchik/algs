package com.acubenchik;

public class UnionFind {

//    private int[] adjList;

    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] M) {
        int [] sets = new int[M.length];
        for(int i = 0; i < sets.length; i++) {
            sets[i] = i;
        }
        int [] size = new int[M.length];
        for(int i =0; i < M.length; i++) {
            for(int j=0; j < M[i].length; j++) {
                if(M[i][j] == 1) {
                    union(sets, size, i, j);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < sets.length; i++) {
            if(sets[i] == i) count++;

        }
        return count;
    }

    public void union(int[] sets, int[] sz, int i, int j) {
        int iRoot = root(sets, i);
        int jRoot = root(sets, j);
        if(sz[iRoot] < sz[jRoot]) { sets[iRoot] = jRoot; sz[iRoot] += sz[jRoot];}
        else { sets[jRoot] = iRoot; sz[jRoot] += sz[iRoot];}


    }


    public int root(int[] sets, int source){
        while(sets[source] != source) {
            sets[source] = sets[sets[source]];
            source = sets[source];}

        return source;
    }
}
