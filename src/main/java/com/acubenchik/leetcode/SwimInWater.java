package com.acubenchik.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInWater {

    public int swimInWater(int[][] grid) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.offer(new Node(0,0,grid[0][0]));
        int [][]steps = new int[][]{{0,1}, {0, -1}, {1,0}, {-1, 0}};
        boolean [][] visited = new boolean[grid.length][grid.length];
        while(!pq.isEmpty()) {
           Node current = pq.poll();
            if(current.i==grid.length-1 && current.j==grid.length-1){
                return current.weight;
            }
           for(int [] step: steps) {
               int row = current.i + step[0];
               int column = current.j + step[1];
               if(row<0 || column<0 || row>=grid.length || column>=grid.length || visited[row][column]){
                   continue;
               }
               visited[current.i][current.j] = true;
               pq.offer(new Node(row, column, Math.max(current.weight, grid[row][column])));
           }
        }
        return -1;
    }

    class Node {
        int i;
        int j;
        int weight;

        public Node(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }
    }
}
