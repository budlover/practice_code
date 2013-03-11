import java.util.Stack;

public class sortStack {
	public static void main(String args[]) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);

		Stack ret = sort(s);
		while(!ret.empty())
			System.out.println(ret.pop());
	}

	static Stack<Integer> sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		if (null == s1 || s1.empty())
			return s1;

		while (!s1.empty()) {
			Integer tmp = s1.pop();
			if (s2.empty() || s2.peek().compareTo(tmp) <= 0) {
				s2.push(tmp);
			} else {
				while(!s2.empty() && s2.peek().compareTo(tmp) > 0) 
					s1.push(s2.pop());
				
				s2.push(tmp);
			}
		}

		return s2;
	}
}

