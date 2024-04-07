import java.util.ArrayList; // Import ArrayList from Java
import java.util.Scanner; // Import Scanner from Java
public class Main {
    private static ArrayList<String> list = new ArrayList<String>(); // Initialize an ArrayList that stores strings
    private static Scanner scan = new Scanner(System.in); // Create a scanner to read user input
    private static boolean done = false; // Initialize done variable for do-while loop, initially false, becomes true when user quits
    public static void main(String[] args) {
        do {
            display(); // Print the current list and the menu items
            String menuItem = SafeInput.getRegExString(scan, "Enter a menu item", "[AaDdPpQq]"); // Retrieves a menu item using SafeInput's getRegExString() function
            switch(menuItem) { // Switch statement for the value of the menuItem variable
                case "a", "A": // If user enters "a" or "A"
                    add(); // Use add() method to add an item
                    break; // Break
                case "d", "D":
                    delete(); // Use delete() method to delete an item
                    break; // Break
                case "p", "P":
                    print(); // Use print() method to print the list
                    break; // Break
                case "q", "Q":
                    quit(); // Use quit() method to stop the program
                    break; // Break
            }
        }
        while (!done); // User enters menu items until the user quits
    }
    private static void display() { // Function that prints the current list and the menu items
        print(); // Print the current list
        System.out.println("A - Add\nD - Delete\nP - Print\nQ - Quit"); // Print menu items (A to add, D to delete, P to print, Q to quit)
    }
    private static void add() { // Function that adds an item to the list
        String addItem = SafeInput.getNonZeroLenString(scan, "Enter the item you would like to add"); // Use SafeInput's getNonZeroLenString() function to retrieve the item to add
        list.add(addItem); // Add the item to the list
    }
    private static void delete() { // Function that deletes an item from the list
        print(); // Print the current list
        int deleteIndex = SafeInput.getRangedInt(scan, "Enter the number of the item you would like to delete", 1, list.size()); // Use SafeInput's getRangedInt() to retrieve the number of the item user wants to delete
        list.remove(deleteIndex - 1); // Remove the item from the list, we subtract 1 from the item number to calculate the index
    }
    private static void print() { // Function that prints the current list
        System.out.println("Current list: "); // Printing the current list below
        for(int i = 0; i < list.size(); i++) { // Loop through the list
            System.out.println((i + 1)+". "+list.get(i)); // Print the item, numbered
        }
    }
    private static void quit() { // Function that stops the program
        if(SafeInput.getYNConfirm(scan, "Are you sure you want to quit?")) { // Asks user if they are sure they want to quit using SafeInput's getYNConfirm() function
            done = true; // Set done to true to exit the do-while loop
        }
    }
}
