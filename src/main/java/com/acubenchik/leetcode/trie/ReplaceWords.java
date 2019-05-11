package com.acubenchik.leetcode.trie;

import java.util.List;

//https://leetcode.com/problems/replace-words/
public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        TrieNode trie = new TrieNode();
        for(String word: dict) {
            TrieNode current = trie;
            for(char c: word.toCharArray()) {
                if(current.childs[c] == null) {
                    current.childs[c] = new TrieNode();
                }
                current = current.childs[c];
            }
            current.value = word;
        }
        StringBuilder answer = new StringBuilder();
        for(String word: sentence.split("\\s+")) {
            if (answer.length() > 0)
                answer.append(" ");
            TrieNode current = trie;
            for(char c : word.toCharArray()) {
                if(current.childs[c] == null || current.value != null) {
                    break;
                }
                current = current.childs[c];
            }
            answer.append(current.value == null ? word : current.value);
        }
        return answer.toString();
    }

    class TrieNode {
        String value;
        TrieNode[] childs = new TrieNode[256];
    }
}
