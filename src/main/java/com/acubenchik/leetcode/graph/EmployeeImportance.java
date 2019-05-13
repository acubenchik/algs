package com.acubenchik.leetcode.graph;

import java.util.*;

public class EmployeeImportance {


// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};


    public static void main(String[] args) {

    }


    class Solution {


        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Map<Integer, Integer> importance = new HashMap<>();
            Map<Integer, Boolean> visited = new HashMap<>();
            Queue<Integer> pre = new LinkedList<Integer>();
            for(Employee e:employees) {
                importance.put(e.id, e.importance);
                graph.put(e.id, e.subordinates);
            }
//            boolean [] visited = new boolean[employees.size()];
            dfs(graph,id, visited, pre);
            int result = 0;
            for(int emp: pre) {
                result += importance.get(emp);
            }
            return result;
        }

        private void dfs(Map<Integer, List<Integer>> graph, int  source, Map<Integer, Boolean> visited, Queue<Integer> pre) {
            visited.put(source, true);
            pre.add(source);
            for(int child: graph.get(source)) {
                if(visited.get(child) == null || !visited.get(child)){
                    dfs(graph, child, visited, pre);
                }
            }
        }
    }
}
