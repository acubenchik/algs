package com.acubenchik.leetcode;

import java.util.*;

public class NetworkWithDelay {

    public static void main(String[] args) {

        new NetworkWithDelay().networkDelayTime(new int[][]{{1,2,1}, {2,3,2}, {1,3,4}}, 3, 1);
    }

    public int networkDelayTime(int[][] times, int N, int K) {

        return dijkstra(K, times, N);
    }

    private int dijkstra(int from, int[][] times, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        boolean[] visited = new boolean[K+1];
        int [] allDistances = new int[K+1];
        for(int i = 0; i < allDistances.length; i++) {
            allDistances[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        queue.add(new int[]{from, 0});
        while(!queue.isEmpty()) {

            int[] currentNodeInfo = queue.poll();
            int currentDistance = currentNodeInfo[1];
            int currentNodeNumber = currentNodeInfo[0];
            if(visited[currentNodeNumber]) continue;;
            visited[currentNodeNumber] = true;

            allDistances[currentNodeNumber] = currentDistance;

            if (graph.containsKey(currentNodeNumber)) {
                for (int [] edge : graph.get(currentNodeNumber)) {
                    if (!visited[edge[0]]) {
                        int alternativDistance = currentDistance + edge[1];
                        if (alternativDistance < allDistances[edge[0]]) {
                            queue.offer(new int[]{edge[0], alternativDistance});
                        } else {
                            queue.offer(new int[]{edge[0], allDistances[edge[0]]});
                        }
                    }
                }
        }
        }

        int result = 0;
        for (int i = 1; i <=K; i++ ) {
            if (allDistances[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, allDistances[i]);
        }
        return result;
    }

}
