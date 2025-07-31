package interview_specific_prep;

public class TrappingRainWaterProblem {
    public static void main(String[] args) {
        int[] heights = {1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(volumeOfTrappedRainWater(heights));
    }

    private static int volumeOfTrappedRainWater(int[] heights){
        int n = heights.length;
        int left=0;
        int right= n-1;
        int maxLeft=0, maxRight=0;
        int res=0;
        while(left<=right){
            if(heights[left] <=heights[right]){
                if(heights[left] >= maxLeft){
                    maxLeft = heights[left];
                }else{
                    res += maxLeft - heights[left];
                }
                left++;
            }else{
                if(heights[right] >=maxRight){
                    maxRight = heights[right];
                }else{
                    res += maxRight - heights[right];
                }
                right--;
            }
        }
        return res;

    }

}
