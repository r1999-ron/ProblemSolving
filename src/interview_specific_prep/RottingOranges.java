package interview_specific_prep;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {1,0,0,1,2},
                {2,0,1,1,0},
                {1,0,1,2,1},
                {0,0,1,2,0}
        };
        System.out.println("Minutes to rot all oranges: " + orangesRotting(grid));
    }
    private static int orangesRotting(int[][] grid){
        if(grid == null || grid.length == 0) return -1;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2){
                    queue.offer(new int[] {i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }

            }
        }
        if(fresh == 0) return 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int minutes = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rottedThisRound = false;
            for(int i=0; i<size; i++){
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for(int [] dir : directions){
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if(newX >= 0 && newY >=0 && newX < rows && newY < cols && grid[newX][newY]==1){
                        grid[newX][newY]=2;
                        queue.offer(new int[]{newX, newY});
                        fresh--;
                        rottedThisRound=true;
                    }
                }
            }
            if(rottedThisRound) minutes++;
        }
        return  fresh == 0 ? minutes : -1;
    }
}
