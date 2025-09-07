package interview_specific_prep;

public class MinSizeSubArraySum {
    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
    private static int minSubArrayLen(int target, int[] nums){
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int n = nums.length;
        int sum = 0;
        while(right < n){
            sum += nums[right];
            while(sum >= target){
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return minLength!= Integer.MAX_VALUE ? minLength : 0;
    }
}
