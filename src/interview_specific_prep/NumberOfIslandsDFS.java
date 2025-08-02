package interview_specific_prep;

public class NumberOfIslandsDFS {
    public static void main(String[] args) {
        int[][] grid = {
            { 1, 1, 1, 0, 0 },
            { 0, 1, 0, 0, 1 },
            { 0, 0, 1, 1, 0 },
            { 0, 0, 1, 0, 0 },
            { 0, 0, 1, 0, 0 }
        };
        System.out.println("Total islands: " + countIslands(grid));
    }

    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (visited[i][j] || grid[i][j] == 0) return;

        visited[i][j] = true;

        dfs(grid, visited, i - 1, j); // up
        dfs(grid, visited, i + 1, j); // down
        dfs(grid, visited, i, j - 1); // left
        dfs(grid, visited, i, j + 1); // right
    }
}
