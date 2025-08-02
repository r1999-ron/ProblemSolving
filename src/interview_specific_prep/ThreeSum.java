package interview_specific_prep;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> li = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            int a = i+1;
            int b = nums.length-1;
            while(a<b){
                if(nums[i] + nums[a] + nums[b]==0){
                    set.add(Arrays.asList(nums[i] ,nums[a] ,nums[b]));
                    a++;
                }else if(nums[i] + nums[a] + nums[b] > 0){
                    b--;
                }else{
                  a++;
                }
            }
        }
        for(List<Integer> t : set){
            li.add(t);
        }
        return li;
    }
}
