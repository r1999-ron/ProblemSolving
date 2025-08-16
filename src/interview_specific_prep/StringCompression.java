package interview_specific_prep;

public class StringCompression {
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println(stringCompression(input));
    }

    private static String stringCompression(String input){
        if (input == null || input.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i=1; i<=input.length(); i++){
            if(i < input.length() && input.charAt(i)== input.charAt(i-1)){
                count++;
            }else{
                sb.append(input.charAt(i-1)).append(count);
                count = 1;
            }
        }
        return sb.toString();
    }

}
