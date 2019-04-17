package com.acubenchik;

import java.security.DigestException;
import java.util.*;

/**
 * Created by acubenchik on 15.04.2019.
 */
public class DirectedKhan {

    public DiGraph graph;

    public static void main(String[] args) {
        new DirectedKhan(new DiGraph()).khan();
    }

    DirectedKhan(DiGraph diGraph) {
        this.graph = diGraph;
    }

    public void khan(){
        List<Integer> result = new ArrayList<Integer>();
        Queue<Integer> nodesWithoutIncomingEdges = new LinkedList<Integer>();
        for(int node: graph.matrix.keySet()) {
            if(!hasIncomingEdges(node)) {
                nodesWithoutIncomingEdges.add(node);
            }
        }
        while(!nodesWithoutIncomingEdges.isEmpty()) {
            Integer currentNode = nodesWithoutIncomingEdges.poll();
            result.add(currentNode);
            List<Integer> edges = new ArrayList<Integer>(this.graph.matrix.get(currentNode));
            this.graph.matrix.put(currentNode, Collections.<Integer>emptyList());
            for(int child: edges) {
                if(!hasIncomingEdges(child)) {
                    nodesWithoutIncomingEdges.add(child);
                }
            }
        }
        System.out.println(result);
    }

    private boolean hasIncomingEdges(int source) {
        for( Map.Entry<Integer, List<Integer>> entry: this.graph.matrix.entrySet()) {
            if(entry.getValue().contains(source)) {
                return true;
            }
        }
        return false;
    }
}
