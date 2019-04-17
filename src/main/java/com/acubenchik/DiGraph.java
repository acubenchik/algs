package com.acubenchik;

import java.util.*;

/**
 * Created by acubenchik on 14.04.2019.
 */
public class DiGraph {

    public Map<Integer, List<Integer>> matrix;

    public DiGraph() {
        this.matrix = new HashMap<Integer, List<Integer>>();
        matrix.put(0, Arrays.asList(1, 2));
        matrix.put(1, Arrays.asList(3, 4));
        matrix.put(2, Collections.<Integer>emptyList());
        matrix.put(3, Collections.<Integer>emptyList());
        matrix.put(4, Collections.<Integer>emptyList());
    }

    public DiGraph(Map<Integer, List<Integer>> matrix) {
        this.matrix = matrix;    }

    public DiGraph reverse(DiGraph graph) {
        DiGraph reverse = new DiGraph(new HashMap<Integer, List<Integer>>());
        for (Map.Entry<Integer, List<Integer>> element: graph.matrix.entrySet()) {
            if(reverse.matrix.get(element.getKey()) == null) {
                reverse.matrix.put(element.getKey(), new ArrayList<Integer>());
            }
            for(int node: element.getValue()) {
                if(reverse.matrix.get(node) == null) {
                    reverse.matrix.put(node, new ArrayList<Integer>());
                }
                reverse.matrix.get(node).add(element.getKey());
            }
        }
        return reverse;
    }
}
