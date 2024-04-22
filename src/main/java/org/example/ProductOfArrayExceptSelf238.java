package org.example;

import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {

    public static int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] result = new int[length];
        int[] prefix = new int[length];
        int[] postfix = new int[length];

        prefix[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        postfix[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }

        result[0] = postfix[1];
        result[length - 1] = prefix[length - 2];
        for (int i = 1; i < length - 1; i++) {
            result[i] = prefix[i - 1] * postfix[i + 1];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
