package interview_specific_prep;

public class SecondLargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {12,35,1,10,34,1};
        System.out.println(print2Largest(arr));
    }

    private static int print2Largest(int[] arr){
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max1){
                max2 = max1;
                max1 = arr[i];
            }else if(arr[i] > max2 && arr[i] != max1){
                max2 = arr[i];
            }
        }
        return max2;
    }
}
