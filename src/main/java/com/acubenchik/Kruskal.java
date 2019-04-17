package com.acubenchik;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Kruskal {

    public EdgeWeightedGraph graph;

    public static void main(String[] args) {
        EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(5);
        edgeWeightedGraph.addEdge(new Edge(0, 1, 10));
        edgeWeightedGraph.addEdge(new Edge(0, 2, 15));
        edgeWeightedGraph.addEdge(new Edge(1, 2, 30));
        edgeWeightedGraph.addEdge(new Edge(1, 3, 20));
        edgeWeightedGraph.addEdge(new Edge(2, 3, 40));
        edgeWeightedGraph.addEdge(new Edge(3, 4, 50));
        edgeWeightedGraph.addEdge(new Edge(2, 4, 60));
        new Kruskal(edgeWeightedGraph);
    }

    public Kruskal(EdgeWeightedGraph graph){
        this.graph = graph;
        Queue<Edge> pq = new PriorityQueue<>();



        pq.addAll(graph.edges());
        Queue<Edge> mst = new LinkedList<>();
        Uf uf = new Uf(5);

        while(!pq.isEmpty()  && mst.size() < graph.numOfNodes-1) {
            Edge e = pq.remove();
            int v = e.either(), w = e.other(v);
            int x = uf.find(v);
            int y = uf.find(w);
            if (x == y) continue; // Ignore ineligible edges, so skip the cycle
            uf.union(x, y); // Merge components.
            mst.add(e);
        }
        System.out.println(mst);
    }

    class Uf {

        private int[] parent;

        Uf(int size){
            this.parent = new int[size];
            for (int i=0; i<size; ++i)
                parent[i]=-1;
        }


        public boolean hasCycle(EdgeWeightedGraph graph)
        {
            // Allocate memory for creating V subsets
            parent = new int[graph.adjList.length];

            // Initialize all subsets as single element sets
            for (int i=0; i<graph.adjList.length; ++i)
                parent[i]=-1;

            // Iterate through all edges of graph, find subset of both
            // vertices of every edge, if both subsets are same, then
            // there is cycle in graph.
            for (Edge e : graph.edges())
            {
                int subsetNumberForFrom = find(e.either());
                int subsetNumberForTo = find(e.other(e.either()));

                if (subsetNumberForFrom == subsetNumberForTo)
                    return true;

                union(subsetNumberForFrom, subsetNumberForTo);
            }
            return false;
        }

        public void union(int x, int y)
        {
            int xset = find(x);
            int yset = find(y);
            parent[xset] = yset;
        }

        public int find(int i)
        {
            if (parent[i] == -1)
                return i;
            return find(parent[i]);
        }
    }
}
