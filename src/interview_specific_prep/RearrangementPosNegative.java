package interview_specific_prep;

import java.util.ArrayList;
import java.util.List;

public class RearrangementPosNegative {
    public static void main(String[] args) {
       int[] arr = {1,2,3,-4,-1,4};
       int[] res = solution(arr);
       for(int i=0; i<res.length; i++){
           System.out.print(res[i]+" ");
       }
    }

    private static int[] solution(int[] arr){
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Separate positive and negative
        for (int num : arr) {
            if (num >= 0) pos.add(num);
            else neg.add(num);
        }

        int[] result = new int[arr.length];
        int i = 0, p = 0, n = 0;
        boolean turnNeg = true; // start with negative (as per example)

        // Alternate placement
        while (p < pos.size() && n < neg.size()) {
            if (turnNeg) result[i++] = neg.get(n++);
            else result[i++] = pos.get(p++);
            turnNeg = !turnNeg;
        }

        // Add leftovers
        while (p < pos.size()) result[i++] = pos.get(p++);
        while (n < neg.size()) result[i++] = neg.get(n++);

        return result;
    }

}
