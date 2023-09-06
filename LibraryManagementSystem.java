import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Eric Quispe
 * Course:202410 Software Development I CEN-3024C-16046
 * Date: 9/6/23
 * 
 * LMS class runs the Library Management System program were the user will have the most interaction with.
 *  It reads book data from a text file books.txt, allows adding and removing books,
 *  and lists all books in the library's collection.
 */
 
public class LibraryManagementSystem {

	public static void main(String[] args) 
	{
        Library library = new Library();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. List All Books");
            System.out.println("4. Exit");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addBook(library);
                    break;
                case 2:
                    removeBook(library);
                    break;
                case 3:
                    listAllBooks(library);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        
    }
	
	// getUserChoice() will allow the user to enter a choice from the menu
	private static int getUserChoice()
	{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt())
        {
            scanner.next(); // Clear the invalid input
            System.out.print("Invalid input. Please enter a valid number: ");
        }
        return scanner.nextInt();
    }
	
	// addBook method will add a book based off the book.txt file
	private static void addBook(Library library) 
	{
		// Read book data from text file and add to the collection
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\uncha\\OneDrive\\Desktop\\books.txt"))) {
            String line;
            
            while ((line = reader.readLine()) != null) 
            {
                String[] bookData = line.split(",");// breaking the strings by looking for "," in the text file
                int id = Integer.parseInt(bookData[0]); // assigning Id
                String title = bookData[1]; // assigning title
                String author = bookData[2]; // assigning author
                Book book = new Book(id, title, author); // creating a new book
                library.addBook(book);// adding to the colleciton
            }
            
        }
        catch (IOException e) // in the event file was not read
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
	System.out.print("\n Books have been added to the collection via the book.txt file");
	}
	
	// This method will allow the user to enter a book to remove from the library
	 private static void removeBook(Library library) 
	 {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter book ID to remove: ");
	        int bookId = scanner.nextInt();
	        library.removeBook(bookId);// this will refer to the library method to remove the book
	        System.out.println("\nBook removed from the collection.");
	  }
	 // Display all books in the collection
	 private static void listAllBooks(Library library) 
	   {
	        System.out.println("\nAll books in the collection:");
	        library.listAllBooks();// refers to library method to show all books in the collection
	    }
	
	
	
}// end of LMS class