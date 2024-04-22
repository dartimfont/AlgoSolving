package org.example;

import java.util.HashMap;

public class ContainDuplicate217 {
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> repeats = new HashMap();
        for (int num : nums) {
            if (repeats.containsKey(num) && repeats.get(num) >= 1) {
                return true;
            }
            repeats.put(num, repeats.getOrDefault(num, 0) + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
