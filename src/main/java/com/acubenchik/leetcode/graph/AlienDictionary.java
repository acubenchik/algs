package com.acubenchik.leetcode.graph;


import java.util.*;

//https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
//Just build a graph and get a topological sort
public class AlienDictionary {

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        alienDictionary.getOrder(new String[]{"caa", "aaa", "aab"});
        System.out.println(alienDictionary.reversePost);
    }

    private Map<Character, Boolean> visited;
    Deque<Character> reversePost = new ArrayDeque<Character>();
    public void getOrder(String [] words){
        Map<Character, Set<Character>> graph = new HashMap<>();
        Set<Character> all = new HashSet<>();
        for(String word : words) {
            for (int i = 0; i < word.length(); i++) {
                all.add(word.charAt(i));
            }
        }
        for (int i = 0; i < words.length-1; i++) {
            String first = words[i];
            String second = words[i+1];
            int length = Math.min(first.length(), second.length());
            for (int j = 0; j < length; j++) {
                if(first.charAt(j) != second.charAt(j)) {
                    graph.computeIfAbsent(first.charAt(j), k -> new HashSet<>());
                    graph.get(first.charAt(j)).add(second.charAt(j));
                    break;
                }
            }
        }
       for(char c : all) {
           if(!graph.containsKey(c)) {
               graph.put(c, new HashSet<>());
           }
       }

        visited = new HashMap<>();
       for(char c : all) {
           if(visited.get(c) == null) {
               dfs(c, graph);
           }
       }

    }

    private void dfs(char source,  Map<Character, Set<Character>> graph) {
       visited.put(source, true);
       Set<Character> edges = graph.get(source);
       for(char c : edges) {
           if(visited.get(c) == null) {
               dfs(c, graph);
           }
       }
       reversePost.push(source);
    }
}
