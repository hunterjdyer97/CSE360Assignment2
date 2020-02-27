/**
 * Hunter Dyer, class ID: 352, Assignment #2
 * This java file is the SimpleList, which is an array that can hold up to 10 elements. 
 * There are different methods that can modify the list, such as adding, removing, or searching the list. 
 */

package cse360assign2;

/**
 * @author Hunter
 * This is the main class of the assignment. It contains the two main variables, list and count. 
 * List is the main array that will be manipulated in the file
 * Count keeps track of how many integers will be in the list. 
 */
public class SimpleList {
	private int list[]; 
	private int count;
	
/**
 * This sets the values of count and list
 * Sets count to 0 and list to hold 10 integers
 */
	public SimpleList() {
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
}
