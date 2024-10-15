package LibraryApplication;
import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    private BookKey key;
    String title;
    BookType type;
    int price;
    LocalDate publishDate;
    String authorName;
    int quantity;

    
    public Book(String title, BookType type, int price, LocalDate publishDate, String authorName, int quantity) {
        
        this.key = new BookKey(title, authorName);
        this.title = title;
        this.type = type;
        this.price = price;
        this.publishDate = publishDate;
        this.authorName = authorName;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BookKey getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Book  : [Title = " + title + ", Type = " + type + ", Price = " + price + ", PublishDate = " + publishDate
                + ", AuthorName = " + authorName + ", Quantity = " + quantity + "]";
    }
}