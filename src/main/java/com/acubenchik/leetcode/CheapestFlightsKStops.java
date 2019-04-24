package com.acubenchik.leetcode;


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
        int result = dijkstra(n, src, dst,  flights, K);
        return result;
    }

    private int dijkstra(int N, int from, int to, int[][] times, int numOfStops) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2], 0});
        }
        boolean[] visited = new boolean[N];
        int [] allDistances = new int[N];
//        int [] numOfStopsForNode = new int[N];
        for(int i = 0; i < allDistances.length; i++) {
            allDistances[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        queue.add(new int[]{from, 0, 0});
        while(!queue.isEmpty()) {
            int[] currentNodeInfo = queue.poll();
            int currentDistance = currentNodeInfo[1];
            int currentNodeNumber = currentNodeInfo[0];
            int currentNumOfStopForNode = currentNodeInfo[2];

            if(currentNodeNumber == to) {
                allDistances[currentNodeNumber] = currentDistance;
                return allDistances[currentNodeNumber];
            }
            visited[currentNodeNumber] = true;

            allDistances[currentNodeNumber] = currentDistance;

            if(currentNumOfStopForNode <=numOfStops) {
                if (graph.containsKey(currentNodeNumber)) {
                    for (int[] edge : graph.get(currentNodeNumber)) {

                            int alternativeDistance = currentDistance + edge[1];
                            if (alternativeDistance < allDistances[edge[0]]) {
                                queue.offer(new int[]{edge[0], alternativeDistance, currentNumOfStopForNode+1});
                            } else {
                                queue.offer(new int[]{edge[0], allDistances[edge[0]], currentNumOfStopForNode+1});
                            }


                    }
                }
            }
        }

        return -1;
    }

}
