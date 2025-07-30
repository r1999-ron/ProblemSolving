package interview_specific_prep;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedSubArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            String[] meta = sc.nextLine().split(" ");
            int n = Integer.parseInt(meta[0]);
            int endIndex = Integer.parseInt(meta[1]);

            int[] arr = new int[n];
            String[] values = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(values[i]);
            }

            mergeSortedParts(arr, endIndex);


            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    private static void mergeSortedParts(int[] arr, int endIndex){

        int [] left = Arrays.copyOfRange(arr, 0, endIndex+1);
        int[] right = Arrays.copyOfRange(arr, endIndex+1, arr.length);

        int i=0,j=0,k=0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while(i < left.length){
            arr[k++] = left[i++];
        }
        while(j < right.length){
            arr[k++] = right[j++];
        }

    }
}
