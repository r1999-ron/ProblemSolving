package blind_75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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