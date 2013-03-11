import java.util.Stack;
import java.io.IOException;

public class stackWithMin {
	public static void main(String args[]) {
		minStack stack = new minStack();
		stack.push(4);
		stack.push(2);
		stack.push(6);

		int min = 0;
		try {
			min = stack.min();
		} catch (IOException e) {
		}
		System.out.println(min);
	}

}

class minStack {
	Stack stack;
	
	private class IntWithMin {
		private int min;
		private int data;

		public IntWithMin (int x) {
			data = x;
			min = 0;
		}

		public void setMin(int x) {
			min = x;
		}
		
		public int getMin() {
			return min;
		}

		public int getData() {
			return data;
		}
	}

	public minStack() {
		stack = new Stack();
	}

	public void push(int x) {
		IntWithMin haha = new IntWithMin(x);

		if (stack.empty()) {
			haha.setMin(x);
		} else {
			IntWithMin hahatmp = (IntWithMin)stack.peek();
			if (hahatmp.getMin() < x)
				haha.setMin(hahatmp.getMin());
			else
				haha.setMin(x);
		}

		stack.push(haha);
	}

	public int pop() throws IOException {
		if (stack.empty())
			throw new IOException();

		IntWithMin ret = (IntWithMin)stack.pop();

		return ret.getData();
    }

	public int min() throws IOException {
		if (stack.empty())
            throw new IOException();

        IntWithMin ret = (IntWithMin)stack.peek();

        return ret.getMin();
	}
}
