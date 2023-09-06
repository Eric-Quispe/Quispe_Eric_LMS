import java.util.ArrayList;
import java.util.List;
public class Library 
/**
 * Eric Quispe
 * Course:202410 Software Development I CEN-3024C-16046
 * Date: 9/6/23
 * 
 * Library class will manage the collection of books
 */

{
	 private List<Book> bookCollection = new ArrayList<>();// this list hold Books

	    // Method to add a book to the collection
	    public void addBook(Book book) 
	    {
	        bookCollection.add(book);
	    }

	    /* Method to remove a book from the collection by ID which is assigned in the LMS class
	    *  removeBook method also has a feature to let the user know that a book wasn't found based on the ID
	    */
	    public void removeBook(int bookId) 
	    {
	        Book foundBook = null;
	        for (Book book : bookCollection) {
	            if (book.getId() == bookId) {
	                foundBook = book;
	                break;
	            }
	      }
	        if (foundBook != null) {
	            bookCollection.remove(foundBook);
	        } else {
	            System.out.println("Book with ID " + bookId + " not found.");
	        }
	    }

	    // Method to list all books in the collection
	    public void listAllBooks() {
	        for (Book book : bookCollection) {
	            System.out.println("ID: " + book.getId() + ". Title: " + book.getTitle() + ", Author: " + book.getAuthor());
	        }
	    }
	
}
