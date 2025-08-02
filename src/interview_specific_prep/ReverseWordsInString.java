package interview_specific_prep;

import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "geeks.for.geeks";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        String [] words = s.split("\\.");
        Stack<String> stack = new Stack<>();
        for(String word : words){
            stack.push(word);
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
            if(!stack.isEmpty()){
                sb.append(".");
            }
        }
        return sb.toString().trim();


    }
}
