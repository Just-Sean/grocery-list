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
		while(!exitFlag) {
			int choice = showMenu();
			
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
					handleError("Some message");
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
		
		for (int i = 0; i < itemsArr.length; i++) {	
			System.out.println("Checking against item: " + itemsArr[i]);
			
			if(itemsArr[i] != null && itemsArr[i].equalsIgnoreCase(item)) {
				handleError("The item is already in the list.");
				return;
			} 
		}
		
		itemsArr[nextEmpty]	= item;
		nextEmpty++;
	}
	
	//removeItem
	public static void removeItem() {
		System.out.println("Remove Item Called");
	}
	
	//checkItem
	public static void checkItem() {
		System.out.println("Check Item Called");
	}
	
	// printList
	public static void printList() {
		System.out.println("Print List Called");
	}
	
	// Exit
	public static void handleExit() {
		System.out.println("Exit Called");
		exitFlag = true;
	}
	
	//handleError
	public static void handleError(String msg) {
		System.out.println("Error: " + msg);
	}
	
}