package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap();;
        for (int i = 0; i < strs.length; i++) {
            int[] key = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                int index = strs[i].charAt(j) - 'a';
                key[index] += 1;
            }
            String keyString = Arrays.toString(key);
            if (!res.containsKey(keyString)) {
                res.put(keyString, new ArrayList<>());
            }
            res.get(keyString).add(strs[i]);
        }
        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
