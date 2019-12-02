package com.acubenchik.leetcode.arrays;

import java.util.*;

public class SkylineProblem_218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        List<Point> points = new ArrayList<>();
        for(int [] item : buildings) {
            points.add(new Point(item[0], item[2], false));
            points.add(new Point(item[1], item[2], true));
        }
        int maxHeight = 0;
        queue.add(maxHeight);

        List<List<Integer>> result = new ArrayList<>();

        for(Point p : points) {
            if(p.height > queue.peek() && !p.isEnd) {
                queue.add(p.height);
                maxHeight = queue.peek();
                result.add(Arrays.asList( p.x, p.height));
            } else if (p.isEnd) {
                queue.remove(p.height);
//                if(cu)
            }


        }

        return result;
    }

    class Point {
        public Point(int x, int height, boolean end) {
            this.x = x;
            this.height = height;
            this.isEnd = end;
        }
        int x;
        int height;
        boolean isEnd;
    }
}
