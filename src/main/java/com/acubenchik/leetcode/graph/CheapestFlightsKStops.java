package com.acubenchik.leetcode.graph;


import java.util.*;

public class CheapestFlightsKStops {
    public static void main(String[] args) {
        new CheapestFlightsKStops().findCheapestPrice(4, new int[][]{{0,1,1}, {0,2,5}, {1,2,1}, {2,3,1}}, 0, 3, 1);
//        [[0,1,100],[1,2,100],[0,2,500]]
//        new CheapestFlightsKStops().findCheapestPrice(10, new int[][] {{3,4,4},
//                        {2,5,6},{4,7,10},{9,6,5},{7,4,4},{6,2,10},{6,8,6},{7,9,4},
//                        {1,5,4},{1,0,4},{9,7,3},{7,0,5},{6,5,8},
//        {1,7,6},{4,0,9},{5,9,1},{8,7,3},{1,2,6},{4,1,5},{5,2,4},{1,9,1},{7,8,10},{0,4,2},{7,2,8}},
//        6,
//        0,
//        7
//        );

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, cost);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{src, 0, 0});
        while(!queue.isEmpty()) {
            int [] current = queue.poll();
            int distance = current[2];
            int city = current[0];
            int cost = current[1];
            if(distance > K + 1) continue;
            if(city == dst) {
                return cost;
            }
            if (graph.containsKey(city)) {
                Map<Integer, Integer> nexts = graph.get(city);
                for (int nextCity : nexts.keySet()) {
                    queue.offer(new int[]{ nextCity, cost + nexts.get(nextCity), distance + 1 });
                }
            }

        }
        return -1;
    }

}
