package org.example;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numMap.containsKey(diff)) {
                return new int[] {numMap.get(diff), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
