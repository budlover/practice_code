public class surroundRegions {
	public static void main(String args[]) {
		//char arr[][] = {{'O', 'O','O'},{'O','O','O'},{'O','O','O'}};
		char arr[][] = {{'O'}};
		Solution cl = new Solution();

		cl.solve(arr);

		for (char a[] : arr) {
			for (char c : a) {
				System.out.print(" " + c);
			}

			System.out.println();
		}
	}


}


class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j;
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        
        for (i = 0; i < board[0].length; i++) {
            setv(board, 0, i);
            setv(board, board.length - 1, i);
        }
        
        for (i = 0; i < board.length; i++) {
            setv(board, i, 0);
            setv(board, i, board[0].length - 1);
            
        }
 

		for (char a[] : board) {
            for (char c : a) {
                System.out.print(" " + c);
            }

            System.out.println("****************");
        }



           
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '$')
                    board[i][j] = 'O';
            }
        }
        


    }
    
    private void setv(char[][] board, int x, int y) {
        
        if (x <0 || x >= board.length || y < 0 || y >= board[0].length)
            return;
           
		System.out.println("x: " + x + " y: " + y);
        if (board[x][y] != 'O')
            return;
            
        board[x][y] = '$';
        
        setv(board, x, y+1); // go right
        setv(board, x, y-1);    
        setv(board, x+1, y);    
        setv(board, x-1, y);
        
        return;
    }
}
