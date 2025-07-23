package blind_75;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args){
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(c == ')' && top != '(') return false;
                if(c == ']' && top != '[') return false;
                if(c == '}' && top != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
