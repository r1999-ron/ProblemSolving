package code_forces;

import java.util.Arrays;
import java.util.Scanner;

public class MedianMinusMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }
            int maxDiff = 0;
            // Check all adjacent pairs
            for (int i = 0; i < n - 1; i++) {
                int x = a[i];
                int y = a[i + 1];
                int median = Math.max(x, y);
                int minimum = Math.min(x, y);
                maxDiff = Math.max(maxDiff, median - minimum);
            }

            // Check all triplets
            for (int i = 0; i < n - 2; i++) {
                int[] triplet = {a[i], a[i + 1], a[i + 2]};
                Arrays.sort(triplet);
                int median = triplet[1];
                int minimum = triplet[0];
                maxDiff = Math.max(maxDiff, median - minimum);
            }

            System.out.println(maxDiff);

        }
    }
}
