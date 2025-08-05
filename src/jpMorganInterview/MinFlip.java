package jpMorganInterview;

public class MinFlip {
    public static void main(String[] args) {
        String target = "10111";
        System.out.println(minFlips(target));
    }

    private static int minFlips(String target){
        int flips=0;
        char current = '0';
        for(int i=0;i<target.length();i++){
            if(target.charAt(i) != current){
                flips++;
                current = target.charAt(i);
            }
        }
        return flips;
    }
}
