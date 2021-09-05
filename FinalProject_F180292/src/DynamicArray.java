import java.util.Arrays;

public class DynamicArray<T> {
	private int size = 0;
	@SuppressWarnings("unchecked")
	private T[] myArray = (T[]) new Object[4];

	public DynamicArray() {
		// TODO Auto-generated constructor stub

	}

	@SuppressWarnings("unchecked")
	public T getIndexOf(int index) {
		try {
			return myArray[index];
		} catch (Exception e) {
			if (e instanceof java.lang.ArrayIndexOutOfBoundsException) {
				return (T) e.getMessage();
			} else {
				return (T) e.getStackTrace();
			}
		}
	}

	public int getSize() {
		return size;
	}

	public T[] getNumbers() {
		return myArray;
	}

	private void setNumbers(T[] numbers) {
		this.myArray = numbers;
	}

	public void add(T value) {
		try {
			if (size < this.myArray.length) {
				this.myArray[size] = value;
			} else {
				resize(this.myArray);
				this.myArray[size] = value;
			}
			this.size++;
			shrink();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private void resize(T[] numbers2) {
		try {
			T[] bigger = (T[]) new Object[numbers2.length * 2];
			for (int i = 0; i < numbers2.length; i++) {
				bigger[i] = numbers2[i];
			}
			numbers2 = bigger;
			setNumbers(numbers2);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private void lengthPlusOne(T[] array) {
		try {
			T[] bigger = (T[]) new Object[array.length + 1];
			for (int i = 0; i < array.length; i++) {
				bigger[i] = array[i];
			}
			array = bigger;
			setNumbers(array);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void shrink() {
		try {
			T[] array = this.myArray;
			int count = 0; // to count how many null are there at the end of the array
			for (int i = array.length - 1; i > 0; i--) { // starting from the end of the array

				if (array[i] != null) { // if the value is not null, break the loop
					break;
				}
				count++;
			}
			// if the length is 5 (index 0 to 4 ==> [1,2,0,0,0]) , 5-3=2 as length
			T[] smaller = (T[]) new Object[array.length - count]; // new array of new length

			for (int i = 0; i < smaller.length; i++) {
				smaller[i] = array[i];
			}
			array = smaller; // old array = new array
			setNumbers(array);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	// old ==>{1,2,3,4,5,6,7,8} old.length
	// temp==>{0,0,0,0,0,0,0,0,0} old.length+1
	// old ==>{1,2,3,4,5,6,7,8,0,0,0,0,0,0,0,0} resized
	// temp==>{0,0,0,0,4,5,6,7,8}
	// old ==>{1,2,3,9,5,6,7,8,0,0,0,0,0,0,0,0}
	// old ==>{1,2,3,9,4,5,6,7,8,0,0,0,0,0,0,0,0}
	@SuppressWarnings("unchecked")
	public void addAt(int index, T value) {
		try {
			T[] temp = (T[]) new Object[this.myArray.length + 1];
			lengthPlusOne(this.myArray);
			for (int i = index + 1; i < temp.length; i++) {
				temp[i] = this.myArray[i - 1];
			}

			this.myArray[index] = value;
			this.size += 1;

			for (int i = index + 1; i < temp.length; i++) {
				this.myArray[i] = temp[i];
			}
		} catch (Exception e) {
			if (e instanceof IndexOutOfBoundsException) {
				System.err.println("No such index in the original array!");
			}
		}

	}

	@SuppressWarnings("unchecked")
	public void remove() {
		try {
			T[] temp = (T[]) new Object[this.myArray.length - 1];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = this.myArray[i];
			}
			this.myArray = temp;
			this.size -= 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public void removeFrom(int index) {
		try {
			T[] temp1 = (T[]) new Object[this.myArray.length];
			int x = 0;
			for (int i = 0; i < temp1.length; i++) {

				if (i == index) {
					x++;
				}

				// to avoid the index out of bound as we increased the x and may be exceeds
				if (x < this.myArray.length) {
					temp1[i] = this.myArray[x];
					x++;
				}
			}

			this.myArray = temp1;
			remove();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public String toString() {
		return "DynamicArray [size=" + size + ", numbers=" + Arrays.toString(myArray) + "]";
	}

}
