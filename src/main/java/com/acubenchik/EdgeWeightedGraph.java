package com.acubenchik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EdgeWeightedGraph {

    public List<Edge>[] adjList;

    public int numOfNodes;

    public EdgeWeightedGraph(int size) {
        this.numOfNodes = size;
        adjList  = new ArrayList[size];
        for(int i = 0; i < size; i++) {
            adjList[i]  = new ArrayList<>();
        }

    }

    public List<Edge> edges(){
        List<Edge> result = new ArrayList<>();
        for (int v = 0; v < numOfNodes; v++) {
            int selfLoops = 0;
            for (Edge e : adjList[v]) {
                if (e.other(v) > v) {
                    result.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) result.add(e);
                    selfLoops++;
                }
            }
        }
        return result;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adjList[v].add(e);
        adjList[w].add(e);

    }
}
