package com.acubenchik.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/top-k-frequent-words/submissions/
public class TopKFrequentWords {

    public static void main(String[] args) {
        List<String> result = new TopKFrequentWords().topKFrequent(new String[]{"govno", "cuka", "cuka", "govno", "m"}, 2);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencies = new HashMap<>();
        for(String w : words) {
            frequencies.put(w, frequencies.getOrDefault(w, 0) + 1);
        }
        TrieNode[] buckets = new TrieNode[words.length+1];
        for(String word : frequencies.keySet()) {
            int frequency = frequencies.get(word);
            if(buckets[frequency] == null) {
                buckets[frequency] = new TrieNode();
            }
            addWord(buckets[frequency], word);
        }

        List<String> result = new ArrayList<>();
        for(int i = buckets.length - 1; i >=0 && result.size() < k; i--) {
            getWord(buckets[i], result, k);
        }
        return result;
    }

    private void addWord(TrieNode root, String text) {
        for(char c : text.toCharArray()) {
            if(root.childs[c] == null) {
                root.childs[c] = new TrieNode();
            }
            root = root.childs[c];
        }
        root.value = text;
    }

    private void getWord(TrieNode node, List<String> result, int k) {
        if(node == null) return;
        if(node.value != null && result.size() < k) {
            result.add(node.value);
        }
        for (int i = 0; i < 256; i++) {
            if(node.childs[i] != null) {
                getWord(node.childs[i], result, k);
            }

        }
    }

    class TrieNode {
        String value; // might be the text
        TrieNode[] childs = new TrieNode[256];
    }
}
