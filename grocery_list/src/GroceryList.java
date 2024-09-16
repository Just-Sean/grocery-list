import java.util.*;

public class GroceryList {
	
	// Global variables 
	private static String[] itemsArr = new String[50];
	private static boolean[] checkedArr = new boolean[50];
	private static Scanner input = new Scanner(System.in);
	private static boolean exitFlag = false;
	private static int nextEmpty = 0;
	
	// main
	public static void main(String[] args) {
		flowControl();
	}
	
	// flowControl
	public static void flowControl() {
		int choice;
		
		while(!exitFlag) {
			choice = showMenu();
			
			switch(choice) {
				case 1: 
					addItem();
					break;
				case 2: 
					removeItem();
					break;
				case 3: 
					checkItem();
					break;
				case 4: 
					printList();
					break;
				case 5:
					handleExit();
					break;
				default:
					handleError("There has been an unexpected error. Please try again.");
				}
			}

	}

	// showMenu
	public static int showMenu() {
		System.out.println("Welcome to Grocery List Management! \n");
		System.out.println("1. Add item to your Grocery List.");
		System.out.println("2. Remove item from your Grocery List.");
		System.out.println("3. \"Check off\" an item from your Grocery List.");
		System.out.println("4. Display your Grocery List.");
		System.out.println("5. Exit. \n");
		
		return input.nextInt();
	}
	
	// addItem
	public static void addItem() {
		System.out.println("Please enter the name of the item you wish to add.");
		String item = input.next();
		
		for (String entry : itemsArr) {	
			if(entry != null && entry.equalsIgnoreCase(item)) {
				handleError("The item is already in the list.");
				return;
			} 
		}
		
		itemsArr[nextEmpty]	= item;
		nextEmpty++;
	}
	
	// removeItem
	public static void removeItem() {
		System.out.println("Please input the name or number of the item you wish to remove.\n");
		int index = findItem();
		
		if (index != -1) {
			itemsArr[index] = null;
			checkedArr[index] = false;
			shiftArray(index);
		}
	}
	
	// checkItem
	public static void checkItem() {
		System.out.println("Please input the name or number of the item you wish to check.\n");
		int index = findItem();
		
		if (index != -1) {
			checkedArr[index] = !checkedArr[index];
		}
	}
	
	// printList
	public static void printList() {
		char marker;
		
		for (int i = 0; i < itemsArr.length; i++) {
			if(itemsArr[i] != null) {
				marker = checkedArr[i] ? 'x': '-';
				System.out.println(i+1 + ". " + itemsArr[i] + " [" + marker + "] ");
			}
		}
		
		System.out.println(); // Just an extra line after the list for readability.
	}
	
	// Exit
	public static void handleExit() {
		printList();
		System.out.println("\nGoodbye, and thank you for using Grocery List!\n");
		exitFlag = true;
	}
	
	//handleError
	public static void handleError(String msg) {
		System.out.println("Error: " + msg + "  Please try again.\n");
	}
	
	// getIndex for string
	public static int getIndex(String item) {
		int index = -1;
		
		for (int i = 0; i < itemsArr.length; i++) {
			if (item.equalsIgnoreCase(itemsArr[i])) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	// shiftArray
	public static void shiftArray(int index) {
		
		for(int i = index; i < itemsArr.length; i++) {
			
			// If the next entry is null, that's the end of the list.
			if (itemsArr[i + 1] == null) {
				nextEmpty = i; // Set this so the addItem method knows where to start. 
				itemsArr[i] = null; // Remove the last item as it is a duplicate.
				return;
			}
			
			itemsArr[i] = itemsArr[i + 1];
			
		}
	}
	
	// Common logic for finding an item by index or name
	public static int findItem() {
			if (input.hasNextInt()) {
				int index = input.nextInt() - 1;
				if (index >= 0 && index < itemsArr.length && itemsArr[index] != null) {
					return index;
				} else {
					handleError("That item does not exist.");
					return -1;
				}
			} else if (input.hasNext()) {
				String item = input.next();
				int index = getIndex(item);
				if (index == -1) {
					handleError("That item does not exist.");
				}
				return index;
			}
			return -1;
		}
		

		
	
}