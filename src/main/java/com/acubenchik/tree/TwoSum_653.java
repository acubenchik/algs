package com.acubenchik.tree;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class TwoSum_653 {

    public boolean findTarget(TreeNode root, int k) {
        return visit(new HashSet<>(), k, root);
    }

    private boolean visit(Set<Integer> numbers, int k, TreeNode root) {
        if(root == null) {
            return false;
        }
        if(numbers.contains(root.val)){
            return true;
        }
        numbers.add(k-root.val);
        return visit(numbers, k, root.right) || visit(numbers, k, root.left);
    }
}
