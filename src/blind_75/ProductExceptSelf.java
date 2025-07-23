package blind_75;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    private static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] output = new int[n];
        output[0]=1;
        for(int i=1; i<n; i++){
            output[i] = output[i-1]*nums[i-1];
        }
        int right = 1;
        for(int i=n-1; i>=0; i--){
            output[i]*=right;
            right *= nums[i];
        }
        return output;
    }
}
