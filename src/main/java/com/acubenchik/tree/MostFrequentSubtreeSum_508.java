package com.acubenchik.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum_508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map= new HashMap<>();
        helper(root, map);
        int maxCount = 0;
        for(int i : map.keySet()) {
            if(map.get(i) > maxCount) {
                maxCount = map.get(i);
            }
        }
        List<Integer> mf = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()==maxCount){
                mf.add(entry.getKey());
            }
        }

        int[] result = new int[mf.size()];
        int k=0;
        for(int i: mf){
            result[k++]=i;
        }

        return result;
    }

    Integer helper(TreeNode root, Map<Integer, Integer> map) {
        if(root == null) {
            return null;
        }
        Integer right = helper(root.right, map);
        Integer left = helper(root.left, map);
        if(right ==  null) {
            right = 0;
        }
        if(left == null) {
            left =0;
        }
        int sum = left +right + root.val;
        map.put(sum, map.getOrDefault(sum,0) + 1);
        return sum;
    }
}
