package interview_specific_prep;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
    public static void main(String[] args) {
        System.out.println(countIslands(new int[][]{
                { 1, 1, 1, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 0, 0, 1, 1, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 0 }
        }));
    }

    public static int countIslands(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int totalIsland = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(!visited[i][j] && matrix[i][j]==1){
                    totalIsland++;
                    bfs(matrix, visited, i, j);
                }
            }
        }
        return totalIsland;
    }
    private static void bfs(int[][] matrix, boolean[][] visited, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
         queue.add(new int[]{i,j});
         while(!queue.isEmpty()){
             int row = queue.peek()[0];
             int col = queue.peek()[1];
             queue.poll();
             if(row>=0 && row<matrix.length && col>=0 && col<matrix[0].length && !visited[row][col] && matrix[row][col]==1){
                 visited[row][col] = true;
                 queue.add(new int[]{row-1, col});
                 queue.add(new int[]{row+1, col});
                 queue.add(new int[]{row, col-1});
                 queue.add(new int[]{row, col+1});
             }
         }
    }

}
