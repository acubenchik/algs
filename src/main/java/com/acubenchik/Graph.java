package com.acubenchik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by acubenchik on 14.04.2019.
 */
public class Graph {

    public List<List<Integer>> matrix;

    public Graph() {
        this.matrix = new ArrayList<List<Integer>>();
        matrix.add(0, Arrays.asList(1,2));
        matrix.add(1, Arrays.asList(0,3,4));
        matrix.add(2, Arrays.asList(0));
        matrix.add(3, Arrays.asList(1));
        matrix.add(4, Arrays.asList(1));
    }


}



