public class surroundRegion {
	public static void main(String args[]) {
		Solution s = new Solution();
		//char board[][] = {{'X','X','X'}, {'O','O','O'}, {'O','X','X'}};
		char board[][] = new char[0][0];

		s.solve(board);
		for (char x[] : board) {
			for (char c : x)
				System.out.print(c);

			System.out.println();
		}
	}

}

class Solution {
    int w;
    int h;
    
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (board == null)
            return;
            
        this.h = board.length;
		if (this.h == 0)
			return;
        this.w = board[0].length;
		if (this.w == 0)
			return;
        int i, j;
            
		// check for invalid chars            
        for (i = 0; i < this.w; i++) {
            if (board[0][i] == 'O')
                DFS(board, 0, i);
                
            if (board[this.h - 1][i] == 'O')
                DFS(board, this.h - 1, i);
        }
        
        for (i = 0; i < this.h; i++) {
            if (board[i][0] == 'O')
                DFS(board, i, 0);
                
            if (board[i][this.w - 1] == 'O')
                DFS(board, i, this.w - 1);
        }
        
        for (i = 0; i < this.h; i++) {
            for (j = 0; j < this.w; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '$')
                    board[i][j] = 'O';
            }
        }
        
        return;
    }
    
    private void DFS(char[][] board, int x, int y) {
        board[x][y] = '$';
        
        if (y - 1 >= 0 && board[x][y - 1] == 'O')
            DFS(board, x, y-1);
        
        if (y + 1 < w && board[x][y + 1] == 'O')
            DFS(board, x, y+1);
    
        if (x - 1 >= 0 && board[x-1][y] == 'O')
            DFS(board, x-1, y);
            
        if (x + 1 < h && board[x+1][y] == 'O')
            DFS(board, x+1, y);
            
        return;
    }
}
