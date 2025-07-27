package interview_specific_prep;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums){
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }
        int maxLength=0;
        for(Integer ele : set){
            int prevEle = ele-1;
            if(!set.contains(prevEle)){
                int len = 1;
                int nextEle = ele+1;
                while(set.contains(nextEle)){
                    len++;
                    nextEle = nextEle+1;
                }
                maxLength = Math.max(maxLength, len);
            }
        }
        return maxLength;
    }
}
