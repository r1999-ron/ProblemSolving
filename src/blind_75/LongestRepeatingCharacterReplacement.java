package blind_75;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "aabccbb";
        int k = 2;
        System.out.println(findLength(s, k));
    }

    private static int findLength(String s, int k) {
        int windowStart = 0, maxLength = 0, maxRepeating = 0;
        int[] charFreq = new int[26];
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            charFreq[rightChar - 'a']++;
            maxRepeating = Math.max(maxRepeating, charFreq[rightChar - 'a']);
            if ((windowEnd - windowStart + 1 - maxRepeating) > k) {
                char leftChar = s.charAt(windowStart);
                charFreq[leftChar - 'a']--;
                windowStart = windowStart + 1;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;

    }
}
