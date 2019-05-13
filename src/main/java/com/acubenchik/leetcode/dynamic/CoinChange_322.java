package com.acubenchik.leetcode.dynamic;

//https://leetcode.com/problems/coin-change/solution/
public class CoinChange_322 {
    public static void main(String[] args) {
        int res = new CoinChange_322().coinChange(new int[]{2}, 3);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        int [] amountResult = new int[amount+1];
        return dp(coins, amountResult, amount);

    }

    private int dp(int [] coins, int[] amount, int remaining) {
        if(remaining < 0) {
            return remaining;
        }
        if(remaining == 0) {
            return 0;
        }
        if (amount[remaining] != 0) return amount[remaining];
        int min = Integer.MAX_VALUE;
        for(int coin: coins) {
            int res = dp(coins, amount, remaining - coin);
            if(res>=0 && res < min) {
                min = 1 + res;
            }
        }
        amount[remaining] = (min == Integer.MAX_VALUE) ? -1 : min;
        return amount[remaining];
    }
}
