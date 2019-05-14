package com.acubenchik.leetcode.arrays;

//https://leetcode.com/problems/battleships-in-a-board/
public class BattleshipsInABoard_419 {
    public int countBattleships(char[][] board) {
        if (board == null) throw new IllegalArgumentException("ex");
        int sum = 0;
        int height = board.length;
        int width = board[0].length;
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (isShipStart(i, j, board)) sum++;
            }
        }
        return sum;
    }
    boolean isShipStart(int row, int col, char[][] board) {
        if (board[row][col] != 'X') return false;
        return (row == 0 || board[row-1][col] != 'X') && (col == 0 || board[row][col-1] != 'X');
    }
}
