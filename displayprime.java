/*
*10.6 (Display the prime numbers) Write a program that displays
all the prime numbers less than 120 in decreasing order. Use the
StackOfIntegers class to store the prime numbers (e.g., 2 , 3 ,
5 , . . . ) and retrieve and display them in reverse order.
*/

public class displayprime {
	public static void main(String[] args) {
		StackOfIntegers stack = new StackOfIntegers();
		int limit = 120;
		int number = 2;
		while (number < limit) {
			if(primenumber(number)) {
				stack.push(number);
			}
			number++;
		}
		int index = 1;
		System.out.println("Prime numbers that are less than 120 in decreasing order: ");
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
			if (index % 10 == 0) {
				System.out.println();
			}
			index++;
		}
	}
	public static boolean primenumber(int number) {
		for (int divisibility = 2; divisibility <= number / 2; divisibility++) {
			if (number % divisibility == 0) {
				return false;
			}
		}
		return true;
	}
}
class StackOfIntegers {
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;
	public StackOfIntegers() {
		this(DEFAULT_CAPACITY);
	}
	public StackOfIntegers(int capacity) {
		elements = new int[capacity];
	}
	public void push(int value) {
		if (size >= elements.length) {
			int[] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements[size++] = value;
	}
	public int pop() {
		return elements[--size];
	}
	public int peek() {
		return elements[size - 1];
	}
	public boolean empty() {
		return size == 0;
	}
	public int getSize() {
		return size;
	}
}