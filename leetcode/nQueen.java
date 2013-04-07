mport java.lang.Math;

public class Solution {
    ArrayList<String[]> list;
    
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> list = new ArrayList<String[]>();
        this.list = list;
        
        int arr[] = new int[n];
        
        recur(arr, 0);
        
        return this.list;
    }
    
    // DFS
    private void recur(int arr[], int row) {
        if (row >= arr.length) {
            
            String retarr[] = new String[arr.length];
            
            for (int i = 0; i < arr.length; i++) {
                int set = arr[i];
                String str = "";
                for (int j = 0; j < arr.length; j++) {
                    
                    if (j == set)
                        str += "Q";
                    else
                        str += ".";
                }
                
                retarr[i] = str;
            }
            
            this.list.add(retarr);
            return;
        }
        
        int col;
        int tmprow;
        for (col = 0; col < arr.length; col++) {
            if (!valid(arr, row, col))
                continue;
            
            // it's OK for this (row, col) 
            arr[row] = col;
            recur(arr, row + 1);    
        }
        
        // if there is no valid position, this level will return directly
        return;        
    }
    
    private boolean valid(int arr[], int row, int col) {
        int i;
        for(i = 0; i < row; i++) { // check for any possible collision
            if (arr[i] == col) // this col has been used before
                return false;
                
            if (Math.abs(i - row) == Math.abs(arr[i] - col)) // diagnal
                return false;
        }
        
        return true;
    }
}
