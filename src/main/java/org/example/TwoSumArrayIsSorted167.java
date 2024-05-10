package org.example;

import java.util.Arrays;

public class TwoSumArrayIsSorted167 {

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;

        int sum;
        while (left <= right) {
            sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
