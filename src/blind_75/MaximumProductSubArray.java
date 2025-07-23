package blind_75;

public class MaximumProductSubArray {
    public static void main(String[] args) {
      int[] nums = {2,3,-2,4};
      System.out.println(maxProduct(nums));
    }
    
    private static int maxProduct(int[] nums){
        int prefix=1, suffix=1, max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));

        }
        return max;
    }

}
