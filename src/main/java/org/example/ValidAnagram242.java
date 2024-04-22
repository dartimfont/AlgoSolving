package org.example;

import java.util.HashMap;

public class ValidAnagram242 {
    public static boolean validAnagram(String s, String t) {
        HashMap<Character, Integer> res = new HashMap<>();
        for (char ch : s.toCharArray()) {
            res.put(ch, res.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            res.put(ch, res.getOrDefault(ch, 0) - 1);
        }
        for (Integer val : res.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validAnagram("anagram", "nagaram"));
        System.out.println(validAnagram("rat", "car"));
    }
}
