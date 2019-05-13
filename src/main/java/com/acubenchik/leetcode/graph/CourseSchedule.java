package com.acubenchik.leetcode.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] input = new int[][] {
                {2, 0},
                {1,0},
                {3,1},
                {3,2},
                {1,3}
        };
        System.out.println(canFinish(4, input));
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList[] graph = getGraph(numCourses, prerequisites);
        for(int i =0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            boolean[] onStack = new boolean[numCourses];
            int[] edgeTo = new int[numCourses];
            Stack<Integer> cycle = new Stack<Integer>();
            dfs(graph, i, visited, onStack, cycle, edgeTo);
            if(! cycle.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(ArrayList<Integer>[] graph, int source, boolean[] visited, boolean[] onStack, Stack<Integer> cycle, int [] edgeTo) {
        visited[source] = true;
        onStack[source] = true;
        for(int child: graph[source]) {
            if(!cycle.isEmpty()) {
                return;
            }
            if(!visited[child]) {
                edgeTo[child] = source;
                dfs(graph, child, visited, onStack, cycle, edgeTo);
            } else if(onStack[child]) {
                for (int x = source; x != child; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(child);
                cycle.push(source);
            }
        }
        onStack[source] = false;
    }

    private static ArrayList[] getGraph(int numCourses, int[][] prerequisites){
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        return graph;
    }
}
