package interview_specific_prep;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args){
        String s = "workattech";
        System.out.println(lengthOfLongestSubstring(s));
    }
    private static int lengthOfLongestSubstring(String s){
        int left = 0, maxLength = 0;
        boolean[] seen = new boolean[256]; // ASCII

        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);


            while (seen[currChar]) {
                seen[s.charAt(left)] = false;
                left++;
            }

            seen[currChar] = true;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
