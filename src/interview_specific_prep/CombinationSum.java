package interview_specific_prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 9};
        int target = 9;
        System.out.println(combinationSum(nums, target));
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums); // sort for pruning
        backtrack(nums, target, 0, new ArrayList<>());
        return result;
    }

    private static void backtrack(int[] nums, int target, int index, List<Integer> path) {
        if (target == 0) {
            result.add(new ArrayList<>(path)); // found one combination
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target) break; // pruning
            path.add(nums[i]);
            backtrack(nums, target - nums[i], i, path); // i (not i+1) → reuse allowed
            path.remove(path.size() - 1); // backtrack
        }
    }
}