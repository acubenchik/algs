package com.acubenchik.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 286. Walls and Gates
 https://leetcode.com/problems/walls-and-gates/#/description
 You are given a m x n 2D grid initialized with these three possible values.
 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent
 INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible
 to reach a gate, it should be filled with INF.
 For example, given the 2D grid:
 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
 */
public class WallsAndGates_286 {

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()) {
            int [] current = q.poll();
            int row = current[0];
            int col = current[1];
            int dist = rooms[row][col];
            //check 4 neibgours
            if (isInside(row-1, col, rooms) && rooms[row-1][col] == Integer.MAX_VALUE){
                rooms[row-1][col] = dist + 1;
                q.add(new int[]{row-1, col});
            }
            if (isInside(row, col-1, rooms) && rooms[row][col-1] == Integer.MAX_VALUE){
                rooms[row][col-1] = dist+1;
                q.add(new int[]{row,col-1});
            }
            if (isInside(row+1, col, rooms) && rooms[row+1][col] == Integer.MAX_VALUE){
                rooms[row+1][col] = dist+1;
                q.add(new int[]{row+1,col});
            }
            if (isInside(row, col+1, rooms) && rooms[row][col+1] == Integer.MAX_VALUE){
                rooms[row][col+1] = dist+1;
                q.add(new int[]{row,col+1});
            }
        }

    }

    private boolean isInside(int i , int j, int [][] rooms) {
        return  i>=0 && i<rooms.length && j>=0 && j<rooms[0].length;
    }
}
