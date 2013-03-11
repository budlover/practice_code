import java.util.Stack;
import java.io.IOException;

public class hanoiTower {
	public static void main(String args[]) {
		Tower t1 = new Tower(1);
		Tower t2 = new Tower(2);
		Tower t3 = new Tower(3);

		int n = 5;
		// add n disks
		try {
			for (int i = 0; i < n; i++)
				t1.add(n - i);
		} catch (IOException e) {}

		t1.move(n, t3, t2);
		
		t3.printTower();
		return;
	}
}


class Tower {
	Stack<Integer> disks;
	int index;

	public Tower(int index) {
		disks = new Stack<Integer>();
		this.index = index;
	}

	public void moveToTop(Tower t) {
		if (disks.empty())
			return;
			
		Integer top = disks.pop();
		try {
			t.add(top);
		} catch (IOException e){}

		System.out.println("move disk " + top + " from tower " + getIndex() + " to tower " + t.getIndex());
	}

	public void add(Integer x) throws IOException {
		if (disks.empty()) {
			disks.push(x);
			return;
		}

		if (disks.peek().compareTo(x) <= 0)
			throw new IOException();

		disks.push(x);

		return;
	}

	public int getIndex() {
		return this.index;
	}

	// move n disks from this to dest, via medium
	public void move(int n, Tower dest, Tower medium) {
		if (0 >= n)
			return;
		
		// step1
		move(n - 1, medium, dest);

		// step2
		moveToTop(dest);

		// step3
		medium.move(n - 1, dest, this);

		return;
	}

	public void printTower() {
		while (!disks.empty()) {
			System.out.println(disks.pop());
		}
	}
}
