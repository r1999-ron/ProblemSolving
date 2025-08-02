package interview_specific_prep;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args){
        String s = "workattech";
        System.out.println(lengthOfLongestSubstring(s));
    }
    private static int lengthOfLongestSubstring(String s){
        int left=0, right=0, maxLength=0;
        HashSet<Character> set = new HashSet<>();
        while(right < s.length()){
            char curr = s.charAt(right);
            if(!set.contains(curr)){
                set.add(curr);
                maxLength = Math.max(maxLength, right-left+1);
                right++;

            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
