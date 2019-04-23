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

        Map<Integer, Node> graph = transform(n, flights, src);
        int result = dijkstra(src, dst, K, graph);
        return result;
    }

    private int dijkstra(int from, int to, int numOfStops, Map<Integer, Node> graph) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.distanceToSource));
        queue.add(graph.get(from));
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if(currentNode.number == to) {
                return currentNode.distanceToSource;
            }
            if(currentNode.currentStops <= numOfStops) {

                for (Edge e : currentNode.childs) {
                    Node child = graph.get(e.to);
                    Node cloneChild = new Node();
                    cloneChild.number = child.number;
                    cloneChild.currentStops = child.currentStops;
                    cloneChild.distanceToSource = child.distanceToSource;
                    cloneChild.childs = child.childs;

                    int alternativDistance = currentNode.distanceToSource + e.weight;

                    if (alternativDistance < cloneChild.distanceToSource) {
                        cloneChild.distanceToSource = alternativDistance;
                    }

                    cloneChild.currentStops = currentNode.currentStops + 1;
                    queue.offer(cloneChild);
                }
            }
        }
        return -1;
    }

    private Map<Integer, Node> transform(int cities, int [][] flights, int source) {
        Map<Integer, Node> result = new HashMap<>();
        //other is integer max
        for(int[] el: flights) {
            if(result.get(el[1]) == null) {
                Node n = new Node();
                n.number = el[1];
                if(el[1] == source) {
                    n.distanceToSource = 0;
                } else {
                    n.distanceToSource = Integer.MAX_VALUE;
                }
                n.childs = new ArrayList<>();
                result.put(el[1], n);
            }
          if(result.get(el[0]) == null) {
              Node node = new Node();
              node.number = el[0];
              if(el[0] == source) {
                  node.distanceToSource = 0;
              } else {
                  node.distanceToSource = Integer.MAX_VALUE;
              }
              node.childs = new ArrayList<>();
              Edge e = new Edge();
              e.weight = el[2];
              e.from = el[0];
              e.to = el[1];
              node.childs.add(e);
              result.put(el[0], node);
          } else {
              Node node = result.get(el[0]);
              Edge e = new Edge();
              e.weight = el[2];
              e.from = el[0];
              e.to = el[1];
              node.childs.add(e);
          }
        }

        return result;
    }
    class Node {
        int number;
        int distanceToSource;
        int currentStops;
        List<Edge> childs;
    }

    class Edge {
        int weight;
       int from;
       int to;

    }

}
