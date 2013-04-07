import java.lang.Integer;
import java.lang.Math;


public class Solution {
    int rec[][];
    
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.rec = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rec[i][j] = -1;
            }
        }
        
        return recur(grid, 0, 0);
    }
    
    
    private int recur(int grid[][], int x, int y) {
        if (rec[x][y] != -1) return rec[x][y];
        
        if (x == grid.length - 1 && y == grid[0].length - 1)
            return grid[x][y];
        
        int ret1 = Integer.MAX_VALUE;
        int ret2 = Integer.MAX_VALUE;
        if (x + 1 < grid.length) { // go down
            ret1 = recur(grid, x+1, y);
        }
        
        if (y + 1 < grid[0].length) { // go right
            ret2 = recur(grid, x, y+1);
        }
        
        int ret = Math.min(ret1, ret2) + grid[x][y];
        rec[x][y] = ret;
        
        return ret;
    }
}
