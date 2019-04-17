package com.acubenchik;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prim {

    public static void main(String[] args) {
        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(5);
        edgeWeightedGraph.addEdge(new Edge(0, 1, 10));
        edgeWeightedGraph.addEdge(new Edge(0, 2, 15));
        edgeWeightedGraph.addEdge(new Edge(1, 2, 30));
        edgeWeightedGraph.addEdge(new Edge(1, 3, 20));
        edgeWeightedGraph.addEdge(new Edge(2, 3, 40));
        edgeWeightedGraph.addEdge(new Edge(3, 4, 50));
        edgeWeightedGraph.addEdge(new Edge(2, 4, 60));
        Prim prim = new Prim(edgeWeightedGraph, 0);
        System.out.println(prim.mst);
    }

    private EdgeWeightedGraph graph;
    private Queue<Edge> pq;
    private Queue<Edge> mst;
    private boolean[] visited;

    public Prim(EdgeWeightedGraph graph, int source){
        this.graph = graph;
        visited = new boolean[graph.adjList.length];
        pq = new PriorityQueue<>();
        mst = new LinkedList<>();
        visit(0);
        while(!pq.isEmpty()) {
            Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);
            if(visited[v] && visited[w]) {
                continue;
            }
            mst.add(e);
            if(!visited[v]) visit(v);
            if(!visited[w]) visit(w);
        }
    }

    private void visit(int source){
        visited[source] = true;
        for(Edge e : graph.adjList[source]) {
            if(!visited[e.other(source)]) {
                pq.add(e);
            }
        }
    }
}
