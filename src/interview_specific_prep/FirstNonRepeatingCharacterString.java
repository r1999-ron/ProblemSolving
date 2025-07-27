package interview_specific_prep;

public class FirstNonRepeatingCharacterString {
    public static void main(String[] args) {
        String input = "swiss";
        char result = firstNonRepeatingChar(input);
        System.out.println("First non repeating character in the string is: " + result);
    }
    public static char firstNonRepeatingChar(String s) {
        int[] count = new int[256];
        for(char c : s.toCharArray()){
            count[c]++;
        }
        for(int i=0; i<s.length(); i++){
            if(count[s.charAt(i)]==1){
                return s.charAt(i);
            }
        }
        return '#';
    }
}
