package blind_75;

public class ContainerWithMaximumWater {
    public static void main(String[] args) {
        int[] nums = {5,2,4,2,6,3};
        System.out.println(maxArea(nums));
    }

    private static int maxArea(int[] height){
        int left=0, right = height.length-1;
        int maxArea = 0;
        while(left < right){
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * (right - left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
