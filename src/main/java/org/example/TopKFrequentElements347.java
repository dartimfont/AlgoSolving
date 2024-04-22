package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements347 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int val : bucket[i]) {
                    res[index++] = val;
                    if (index == k) {
                        return res;
                    }
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] result = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        int[] result2 = topKFrequent(new int[]{1, 2}, 2);
        System.out.println(Arrays.toString(result2));

    }
}
