
 /**
 * Eric Quispe
 * Course:202410 Software Development I CEN-3024C-16046
 * Date: 9/6/23
 * 
 * Book class is used to create the books based on what is enter on the text file. 
 * here is where the book is assigned id, Title, and author
 */
 
public class Book 
{
	private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    
    // These methods just get the information stated ID,Title, or Author
    public int getId()
    {
        return id;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }
}
