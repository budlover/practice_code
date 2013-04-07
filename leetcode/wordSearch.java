import java.util.HashSet;
import java.util.Iterator;

public class wordSearch {
	public static void main(String args[]) {
		char arr[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

		Solution cl = new Solution();
		System.out.println(cl.exist(arr, "ABCB"));
	}

}


class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board == null || board.length == 0 || board[0].length == 0 || word.length() > board.length * board[0].length)
            return false;
        
        int i, j;
		boolean flag[][] = new boolean[board.length][board[0].length];

        //HashSet<Zuobiao> path = new HashSet<Zuobiao>();
        boolean ret = false;
        
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
				flag = new boolean[board.length][board[0].length];
                if (true == recur(board, flag, i, j, word, 0)) {
					//Iterator<Zuobiao> itr = path.iterator();
        			//while (itr.hasNext()) {
					//	Zuobiao z = itr.next();
            		//	System.out.println(z.x + " " + z.y);
					//}
                    return true;
				}
            }
        }
        

        return false;
    }
    
    private boolean recur(char[][] board, boolean flag[][], int x, int y, String s, int index) {
		if (index >= s.length() - 1) {
            if (board[x][y] != s.charAt(index) || flag[x][y] != false) {
				return false;
			} else {
				System.out.println("x: " + x + " y: " + y);
				//path.add(z);
                return true;
			}
        }
        
        if (board[x][y] != s.charAt(index) || flag[x][y] != false) {
            return false;
        }
        
        //path.add(z);
        flag[x][y] = true;

        boolean ret = false;

        if (y + 1 < board[0].length) { // go right
            ret = recur(board, flag, x, y + 1, s, index + 1);
            if (true == ret)
                return true;
        }
        
        if (y -1 >= 0) { // go left
            ret = recur(board, flag, x, y - 1, s, index + 1);
            if (true == ret)
                return true;
        }
        
        if (x - 1 >= 0) { // go up
            ret = recur(board, flag, x - 1, y, s, index + 1);
            if (true == ret)
                return true;
        }
        
        if (x + 1 < board.length) { // go up
            ret = recur(board, flag, x + 1, y, s, index + 1);
            if (true == ret)
                return true;
        }

		// quit from this        
		flag[x][y] = false;

        return false;
    }
}
