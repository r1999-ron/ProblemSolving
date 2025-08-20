package interview_specific_prep;

public class MatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        int target = 5;
        boolean found = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found? " + found);
    }

    private static boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int r=0, c=col-1;
        while(r<row && c>=0){
            if(matrix[r][c] == target){
                return true;
            } else if(matrix[r][c] > target){
                c --;
            }else{
                r++;
            }
        }
        return false;
    }
}
