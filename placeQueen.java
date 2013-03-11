import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;

public class placeQueen {
	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println("please give me the size n");
			return;
		}

		int size = Integer.parseInt(args[0]);
		Queen q = new Queen(size);
		q.place();
	}
}

class Queen {
	int array[][];
	int size;
	ArrayList<ArrayList<Integer>> lists;

	public Queen(int size) {
		if (0 >= size)
			return;
		
		this.size = size;
		array = new int[size][size];
		lists = new ArrayList<ArrayList<Integer>>();

		return;
	}

	public void place() {
		int columns[] = new int[this.size];
		for (int i = 0; i < columns.length; i++)
			columns[i] = -1;

		placeRecur(columns, 0);
		
		if (0 != this.lists.size()) {
			for (ArrayList<Integer> list : this.lists) {
				for (int i = 0; i < list.size(); i++)
					System.out.print(list.get(i) + ", ");
				
				System.out.print("\n");
			}
		} else {
			System.out.println("No way");
		}
	}

	private void placeRecur(int columns[], int row) {
		//System.out.println(row + "   " + Arrays.toString(columns));

		// base case
		if (row >= this.size) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i : columns)
                list.add(i);

            lists.add(list);
			return;
        }

		for (int i = 0; i < this.size; i++) {  // choose a column
			boolean collision = false;

			// check for collision
			for (int j = 0; j < row; j++) { // check diagonal
				if (columns[j] == i) {
					collision = true;
					break;
				}
					
				if (Math.abs(i - columns[j]) == Math.abs(row - j)) {
					collision = true;
					break;
				}
			}

			if (collision != false) // there is collision
				continue;

			// no collision, chhoose column i for row
			columns[row] = i;
			placeRecur(columns, row + 1);
		}

		return;
	}
}
