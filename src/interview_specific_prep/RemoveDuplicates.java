package interview_specific_prep;

import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args){
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i=0;
        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
                nums[i++]=num;
            }
        }
        return i;
    }
}
