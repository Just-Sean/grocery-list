import java.util.*;

public class GroceryList {
	// Variables 
	private static String[] itemArr = new String[50];
	private static boolean[] checkedArr = new boolean[50];
	private static Scanner input = new Scanner(System.in);
	private static boolean endFlag = false;
	
	public static void main(String[] args) {
		flowControl();
	
	}
	
	// flowControl
	public static void flowControl() {
		showMenu();
	}

	// showMenu
	public static void showMenu() {
		System.out.println("Welcome to Grocery List Management! \n");
		System.out.println("1. Add item to your Grocery List.");
		System.out.println("2. Remove item from your Grocery List.");
		System.out.println("3. \"Check off\" an item from your Grocery List.");
		System.out.println("4. Display your Grocery List.");
		System.out.println("5. Exit.");
		
	}
	
	// addItem
	
	//removeItem
	
	//checkItem
	
	// printList
	
	// Exit
	
	
	
}