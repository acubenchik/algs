package com.acubenchik.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited = new boolean[rooms.size()];
        List<Integer> order = new ArrayList<>();
        dfs(0, visited, rooms, order);
        return order.size() == rooms.size();

    }

    public void dfs(int source, boolean[] visited, List<List<Integer>> rooms, List<Integer> preOrder) {
        visited[source] = true;
        preOrder.add(source);
        for(int child: rooms.get(source)) {
            if(!visited[child]) {
                dfs(child, visited, rooms,preOrder);
            }
        }
    }

}
