package interview_specific_prep;

import java.util.Arrays;
import java.util.HashMap;

public class SubArraySumEqualsK {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        int k=3;
        System.out.println(subArraySum(nums, k));

    }

    private static int subArraySum(int[] nums, int k){
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // {0->1}
        for(int num : nums){
            currentSum += num; //6
            if(map.containsKey(currentSum-k)){
                count += map.get(currentSum-k); // 2
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1); // {1->1, 3->1,6->1}
        }
        return count;
    }
}