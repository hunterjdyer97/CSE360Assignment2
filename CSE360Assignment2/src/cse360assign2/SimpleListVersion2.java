/**
 * Hunter Dyer, class ID: 352, Assignment #2
 * This java file is the SimpleListVersion2, which is a modification to the original SimpleList.java
 * The new methods to this one are append, first, last, and size
 */

package cse360assign2;

/**
 * @author Hunter
 * This is the main class of the assignment. It contains the two main variables, list and count. 
 * List is the main array that will be manipulated in the file
 * Count keeps track of how many integers will be in the list. 
 */
public class SimpleListVersion2 {
	private int list[]; 
	private int count;
	
/**
 * This sets the values of count and list
 * Sets count to 0 and list to hold 10 integers
 */
	public SimpleListVersion2() {
		this.count = 0; 
		list = new int[10]; 
	}

/**
 * This is the add class, with the number being added set to "int value"
 * It has an if, else if, and else for the different scenarios the value will be added in
 * The if is when it is the first integer being added to the list, it will just be added to the front
 * The else if is for when there are some integers already in, it will descend the list from the back and shift each value over one
 * It will then place the new value at the front
 * The else is when the list is full. It will kick out the 10th element, descend the list from the back
 * shift each value over one, then add the new value to the front
 * All the 3 cases will keep track of values with count++ every time something is added
 * the new list = new int[15] is increasing the size of the original list by 50%
 * @param value
 */
	public void add(int value) {
		if (count == 0) {
			list[count] = value; 
			count++;
		}
		else if (count < 10) {
			for (int i = count; i >= 0; i--) {
				list[i + 1] = list[i]; 
			}
			list[0] = value;
			count++; 
		}
		else {
			list[count - 1] = 0;
			for (int i = count; i >= 0; i--) {
				list [i + 1] = list[i]; 
			}
			list[0] = value;
			list = new int[15]; 
			count++;
		}
	}
	
	/**
	 * From the assignment description, I placed an if and else to first check if the desired value is in the list before removing. 
	 * The decided value will be made the index to transcend in the list, and the values will all be shifted down
	 * The else will just say the value isn't in the list
	 * @param value
	 */
	public void remove(int value) {
		int index = search(value); 
		if (index != -1) {
			for (int i = index; i < count - 1; i++) {
				list[i] = list[i - 1];
			if (count <= 2.5 && count > 1) {
				list = new int[count];
			}
			}
			count--;
		}
		else {
			System.out.println(value + "parameter not in list"); 
		}
	}
	
	/**
	 * All this does is return the current count of the list
	 * @return
	 */
	public int count() {
		return count; 
	}
	
	/**
	 * A basic toString method that will return the list as a string
	 * This is very similar to toString methods that I have used in previous classes
	 * The only difference is that it will transcend our list, add each element to the string
	 * If it is not the last element in the list, it will add a space in between each element
	 */
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < count; i++) {
			str += list[i]; 
			if (i != count - 1) {
				str += " ";
			}
		}
		return str; 
	}
	
	/**
	 * This method will search for a given value
	 * The desired index will be -1 unless it is found while transcending the list
	 * While transcending, it will look for the value provided
	 * If found, will set the element to the index
	 * At the end, it will return the index, which will be either -1 or the desired value
	 * @param value
	 * @return
	 */
	public int search(int value) {
		int index = -1; 
		for (int i = 0; i < count; i++) {
			if (list[i] == value) {
				index = i;
			}
		}
		return index; 
	}
	
	/**
	 * this is the append method
	 * it will place the value at the end of the list
	 * if the count is greater than 10, then still add it to the end
	 * @param value
	 */
	public void append(int value) {
		if (count >= 10) {
			list = new int[15];
			count = count + 5;
			list[count - 1] = value;
		}
		else {
			list[count - 1] = value;
			count++; 
		}
	}
	
	/**
	 * this method will return the first integer, or element 0
	 * @return
	 */
	public int first() {
		return list[0]; 
	}
	
	/**
	 * this will return the last element of the list
	 * @return
	 */
	public int last() {
		return list[count - 1]; 
	}
	/**
	 * this will return the size of the list
	 * it does it by counting the number of the elements in the list as it ascends the for loop, than returns that value
	 * @return
	 */
	public int size() {
		int size = 0;
		for (int i = 0; i < count; i++) {
			size = size + 1;
		}
		return size; 
	}
}
