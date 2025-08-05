package jpMorganInterview;

import java.util.*;

public class MinOperationsToTarget {
    public static List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;

        // Prefix sum array
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        List<Long> result = new ArrayList<>();

        for (int q : queries) {
            // Find how many elements <= query using binary search
            int idx = binarySearch(nums, q);  // first index where nums[i] > q

            long leftCost = 0;
            if (idx > 0) {
                leftCost = (long)q * idx - prefixSum[idx - 1];
            }

            long rightCost = 0;
            if (idx < n) {
                rightCost = (prefixSum[n - 1] - (idx > 0 ? prefixSum[idx - 1] : 0)) - (long)q * (n - idx);
            }

            result.add(leftCost + rightCost);
        }

        return result;
    }

    // Binary search: first index where nums[i] > query
    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = {3, 1, 6, 8};
        int[] queries = {1, 5};
        System.out.println(minOperations(nums, queries)); // Output: [14, 10]

        int[] nums2 = {2, 9, 6, 3};
        int[] queries2 = {10};
        System.out.println(minOperations(nums2, queries2)); // Output: [20]
    }
}
