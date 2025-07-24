package blind_75;
/*
* The code finds the length of the longest substring containing the same letter that can be created after performing at most character replacements. `k`
* ### How it Works
1. **Sliding Window Approach**:

- Uses a sliding window to examine substrings
- Window expands to the right and shrinks from left when needed

1. **Character Frequency Tracking**:
``` java
char rightChar = s.charAt(windowEnd);
charFreq[rightChar - 'a']++;
maxRepeating = Math.max(maxRepeating, charFreq[rightChar - 'a']);
```
- Keeps track of character frequencies
- Updates the count of most frequent character

1. **Window Adjustment**:
``` java
if ((windowEnd - windowStart + 1 - maxRepeating) > k) {
    char leftChar = s.charAt(windowStart);
    charFreq[leftChar - 'a']--;
    windowStart = windowStart + 1;
}
```
- If characters to be replaced exceed k, shrink window
- Updates frequency when removing characters from window start

### Example
For input "aabccbb" with k=2:
- Can convert "bccbb" to "bbbbb" by replacing 'cc' with 'bb'
- Returns 5 as the length of longest valid substring

### Complexity
- Time Complexity: O(n) where n is length of string
- Space Complexity: O(1) as we use fixed-size array of 26 characters

 */
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
