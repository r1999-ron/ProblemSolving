package interview_specific_prep;

import java.util.HashMap;

public class LengthOfLongestSubarray2Distinct {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,2,2};
        int ans = totalElements(arr);
        System.out.println(ans);
    }

    private static int totalElements(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int left=0,right=0, n = arr.length;
        int maxLength=0;
        while(right < n){
            map.put(arr[right], map.getOrDefault(arr[right],0)+1);
            while(map.size() > 2){
                map.put(arr[left], map.get(arr[left])-1);
                if(map.get(arr[left])==0){
                    map.remove(arr[left]);

                }
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }
}
