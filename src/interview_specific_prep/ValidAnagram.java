package interview_specific_prep;


public class ValidAnagram {
    public static void main(String[] args){
        String s = "listen";
        String t = "silent";
        System.out.println(isBoolean(s, t));

    }
    private static boolean isBoolean(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int i=0; i<26; i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;

    }
}
