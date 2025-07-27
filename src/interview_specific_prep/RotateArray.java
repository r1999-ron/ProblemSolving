package interview_specific_prep;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k=3;
        rotateArray(nums, k);
        for(int num : nums){
            System.out.print(num+" ");
        }
    }
    private static void rotateArray(int[] nums, int k){
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-1);
        reverse(nums,0,k-1);
        reverse(nums, k, n-1);
    }
    private static void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    // 7,6,5,4,3,2,1
    // 5,6,7,4,3,2,1
    //5,6,7,1,2,3,4
}
