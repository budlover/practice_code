// leetcode Spiral Matrix

import java.util.ArrayList;

public class spiralMatrix {
	public static void main(String args[]) {
		Solution cl = new Solution();
		int arr[][] = {{2},{3}};
		ArrayList<Integer> list = cl.spiralOrder(arr);

		for (int i : list)
			System.out.print(" " + i);

		System.out.println();
	}	

}

class Solution {
    int mat[][];
    
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> retlist = new ArrayList<Integer>();
        
        if (null == matrix)
            return retlist;
        
        if (0 == matrix.length || 0 == matrix[0].length)
            return retlist;
        
        this.mat = matrix;
        boolean arr[][] = new boolean[matrix.length][matrix[0].length];
        
        int x = 0;
        int y = 0;
        int w = matrix[0].length - 1;
        int h = matrix.length - 1;
        
        recur(x, y, h, w, arr, retlist);
        
        return retlist;
    }
    
    private void recur(int x, int y, int h, int w, boolean arr[][], ArrayList<Integer> list) {
        //arr[x][y] = true;
        // go right
		// System.out.println(arr.length + " " + arr[0].length + " " + h + " " + w + " " + x + " " + y);
        while (y <= w && true != arr[x][y]) {
            arr[x][y] = true;
            list.add(mat[x][y]);
            y++;
        }
		y--;
        if (x + 1 > h || false != arr[x + 1][y])
            return;
        
        x++;
        // go down
        while (x <= h && true != arr[x][y]) {
            arr[x][y] = true;
            list.add(mat[x][y]);
            x++;
        }
		x--;
        if (y - 1 < 0 || false != arr[x][y - 1])
            return;
            
        y--;
        // go left
        while (y >= 0 && true != arr[x][y]) {
            arr[x][y] = true;
            list.add(mat[x][y]);
            y--;
        }
		y++;
        if (x - 1 < 0 || false != arr[x - 1][y])
            return;
            
        x--;
        // go up
        while (x >= 0 && true != arr[x][y]) {
            arr[x][y] = true;
            list.add(mat[x][y]);
            x--;
        }
		x++;
        if (y + 1 > w || false != arr[x][y + 1])
            return;
        
        y++;
        // inner spin
        recur(x, y, h - 1, w - 1, arr, list);
        
        return;
    }
}
