import java.lang.Exception;
import java.lang.*;
import java.util.Iterator;

public class myCircularArray {
	public static void main(String args[]) {
		myCircularArrayTest<String> arr = new myCircularArrayTest<String>(10);
		arr.set(0, "aa");
		arr.set(9, "bb");

		System.out.println(arr.get(0));
		System.out.println(arr.get(9));
	}

}

class myCircularArrayTest<T> implements Iterable<T> {
	private int head;
	private T array[];

	public Iterator<T> iterator() {
		Iterator<T> iter = new myCircularArrayTestIter();
		return iter;
	}
	
	public class myCircularArrayTestIter implements Iterator<T> {
		int iterIndex = -1;

		public myCircularArrayTestIter() {
			return;
		}
		@Override
		public boolean hasNext() {
			if (iterIndex < array.length - 1)
				return true;
			else
				return false;
		}

		@Override
		public T next() {
			int physicalIndex = transition(iterIndex + 1);

			if (hasNext()) {
				iterIndex++;
				return array[physicalIndex];
			} else
				throw new java.lang.IndexOutOfBoundsException("exception.");
		}

		@Override
		public void remove() {
			throw new java.lang.IndexOutOfBoundsException("exception.");
		}
	}
	
	public myCircularArrayTest (int size) {
		if (0 >= size)
			throw new java.lang.IndexOutOfBoundsException("exception.");

		head = 0;
		array = (T[]) new Object[size];

		return;
	}

	private int transition(int logicIndex) {
		if (0 > logicIndex) 
			logicIndex += array.length;

		return (head + logicIndex) % array.length;
	}
	
	public void rotateBy(int rotation) {
		head = transition(rotation);
	}

	public T get(int index) {
		if ((index >= array.length) || (index < 0))
			throw new java.lang.IndexOutOfBoundsException("exception.");

		int physicalIndex = transition(index);
		return array[physicalIndex];
	}

	public void set(int index, T value) {
        if ((index >= array.length) || (index < 0))
            throw new java.lang.IndexOutOfBoundsException("exception.");

        int physicalIndex = transition(index);
        array[physicalIndex] = value;
    }
}
