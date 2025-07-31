package interview_specific_prep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        int[] A = {1,1,2,1,4,6,5};
        int k=3;
        System.out.println(Arrays.toString(distinctNumbersInWindow(A, k)));
    }
    private static int[] distinctNumbersInWindow(int[]A, int k){
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] result = new int[A.length-k+1];
        int left=0;
        for(int right=0; right<A.length; right++){
            freqMap.put(A[right], freqMap.getOrDefault(A[right], 0)+1);
            if(right - left +1 == k){
                result[left] = freqMap.size();
                freqMap.put(A[left], freqMap.get(A[left])-1);
                if(freqMap.get(A[left]) == 0){
                    freqMap.remove(A[left]);
                }
                left++;
            }
        }
        return result;
    }
}
