package com.acubenchik.leetcode;

import java.util.*;

import static java.util.Collections.emptyList;

//https://leetcode.com/problems/course-schedule-ii/
public class Schedule2 {

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {2, 0},
                {1,0},
                {3,1},
                {3,2}

        };
        findOrder(4, input);
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int [] result = khan(getGraph(numCourses, prerequisites, indegree), indegree);
        if(result.length != numCourses) {
            return new int[0];
        }
        return result;
    }


    public static int[] khan(ArrayList<Integer>[] graph, int [] indegree){
        List<Integer> result = new ArrayList<Integer>();
        Queue<Integer> nodesWithoutIncomingEdges = getNodesWithNoEdges(indegree);
        while(!nodesWithoutIncomingEdges.isEmpty()) {
            Integer currentNode = nodesWithoutIncomingEdges.poll();
            result.add(currentNode);
            List<Integer> childNodes = graph[currentNode];
            graph[currentNode] = new ArrayList<>();
            for(int child: childNodes) {
                indegree[child]--;
                if(indegree[child] == 0) {
                    nodesWithoutIncomingEdges.add(child);
                }
            }
        }
        int[] arr = result.stream().mapToInt(i -> i).toArray();
        return arr;

    }

    private static Queue<Integer> getNodesWithNoEdges(int [] indegree) {
        Queue<Integer> result = new LinkedList<Integer>();
       for(int i =0; i < indegree.length; i++)  {
           if(indegree[i] == 0) {
               result.add(i);
           }
       }
            return result;
    }

    private static ArrayList[] getGraph(int numCourses, int[][] prerequisites, int[] indegree){
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        return graph;
    }
}
