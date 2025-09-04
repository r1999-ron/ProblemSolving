package interview_specific_prep;
import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterString {
    public static void main(String[] args) {
        String input = "swiss";
        System.out.println(firstNonRepeatingChar(input));
    }
    public static Character firstNonRepeatingChar(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (charMap.get(c) == 1) {
                return c;
            }
        }
        return null;
        // if(charMap.get())
    }
}