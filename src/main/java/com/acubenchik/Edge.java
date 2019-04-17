package com.acubenchik;

public class Edge implements Comparable<Edge> {

    private int v;
    private int other;
    public double weight;


    public Edge(int v, int w, double weight) {
        if (v < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (w < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.other = w;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    public String toString() {
        return String.format("%d-%d %.5f", v, other, weight);
    }

    public int other(int vertex) {
        if      (vertex == v) return other;
        else if (vertex == other) return v;
        else throw new IllegalArgumentException("Illegal endpoint");
    }

    public int either() {
        return v;
    }


}
