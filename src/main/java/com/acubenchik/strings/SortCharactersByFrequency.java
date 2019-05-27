package com.acubenchik.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String res = new SortCharactersByFrequency().frequencySort("rraabbb");
        System.out.println(res);
    }

    public String frequencySort(String s) {
        if(s == null || s.isEmpty() ) return s;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new List[s.length()+1];
        for(char entry : map.keySet()) {
            if(buckets[map.get(entry)]  == null) {
                buckets[map.get(entry)] = new ArrayList<>();
            }
            buckets[map.get(entry)].add(entry);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = buckets.length -1; i>=0; i--) {
            if(buckets[i] != null) {
                for(char c : buckets[i]) {
                    for(int j  = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

}
