package leetcode_medium;

// Problem: https://leetcode.com/problems/3sum-closest/

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target){
        int result = Integer.MAX_VALUE, start, end, sum = 0;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            start = i+1;
            end = nums.length-1;
            while(start < end){
                sum = nums[i] + nums[start] + nums[end];
                if(sum > target){
                    end--;
                }else{
                    start++;
                }
            }
            if(Math.abs(sum-target) < Math.abs(result-target)){
                result = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
