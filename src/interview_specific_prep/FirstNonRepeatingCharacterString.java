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
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return null;
        // if(charMap.get())
    }
}