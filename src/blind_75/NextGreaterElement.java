package blind_75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/*
* /**
 * A class to solve the "Next Greater Element I" problem.
 *
 * Given two arrays `nums1` and `nums2`, where `nums1` is a subset of `nums2`,
 * for each element in `nums1`, this program finds the next greater element in `nums2`.
 * The next greater element of a number x in `nums2` is the first greater number to the
 * right of x in the same array. If no such number exists, return -1 for that element.
 *
 * Time Complexity: O(m + n), where n is the length of nums2 and m is the length of nums1.
 * Space Complexity: O(n) for stack and hashmap.
 *
 * Example:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 *
 * Approach:
 * - Use a monotonic decreasing stack to pre-process nums2 and map each number to its next greater element.
 * - Use a hashmap for O(1) lookup for each element in nums1.
 **/
public class NextGreaterElement {
    public static void main(String[] args) {

        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        int n = nums2.length;
        for(int i=n-1; i>=0; i--){
            int current = nums2[i];
            while (!stack.isEmpty() && stack.peek()<=current){
                stack.pop();
            }
            nextGreaterMap.put(current, stack.isEmpty() ? -1 : stack.peek());

            stack.push(current);
        }
        int[] res = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            res[i] = nextGreaterMap.get(nums1[i]);
        }
        return res;
    }


}