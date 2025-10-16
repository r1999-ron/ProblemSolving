package interview_specific_prep;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeros(arr);
        for(int v : arr) System.out.print(v + " ");
    }

    private static void moveZeros(int[] nums){
        int insertPos = 0;
        for(int x : nums){
            if(x !=0){
                nums[insertPos++] = x;
            }
        }
        while(insertPos < nums.length){
            nums[insertPos++] = 0;
        }

    }
}
