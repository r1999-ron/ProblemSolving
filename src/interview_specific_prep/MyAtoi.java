package interview_specific_prep;

public class MyAtoi {
    public static void main(String[] args) {
        String s = "1337c0d3";
        System.out.println(myAtoi(s));
    }

    private static int myAtoi(String s){
        if(s == null || s.length() == 0) return 0;
        int i=0, n = s.length();
        while(i < n && s.charAt(i)== ' '){
            i++;
        }
        int sign = 1;
        while(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '-')?-1:1;
            i++;
        }
        long num = 0;
        while(i<n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            num = num*10 + (s.charAt(i) - '0');
            if(sign == 1 && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign == -1 && num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign*num);
    }
}
