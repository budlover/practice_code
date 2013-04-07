public class Solution {
    int rec[][];
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (obstacleGrid == null)
            return 0;
        
        int rec[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        this.rec = rec;
        
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                rec[i][j] = -1;
            }
        }
        
        return recur(obstacleGrid, 0, 0);        
    }
    
    private int recur(int[][] obstacleGrid, int x, int y) {
        if (obstacleGrid[x][y] != 0)
            return 0;
            
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            if (obstacleGrid[x][y] == 0)
                return 1;
            else
                return 0;
        }
        
        if (rec[x][y] != -1)
            return rec[x][y];
        
        int ret = 0;
        if (x + 1 < obstacleGrid.length && obstacleGrid[x + 1][y] != 1)
            ret += recur(obstacleGrid, x + 1, y);
            
        if (y + 1 < obstacleGrid[0].length && obstacleGrid[x][y + 1] != 1)
            ret += recur(obstacleGrid, x, y + 1);
        
        rec[x][y] = ret;
        
        return ret;
    }
}
