package librarymanagementsystem;
import java.io.Serializable;
public abstract class Book implements Serializable {
    private String title;
    private String[] authors;
    private long ISBNL;
    private boolean isLent;

    public Book(String title, String[] authors,long ISBNL) {
        this.title = title;
        this.authors = authors;
        this.ISBNL = ISBNL;
        this.isLent = false;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public Long getISBNL() {
        return ISBNL;
    }

    public boolean getIsLent() {
        return isLent;
    }

    public void setIsLent(boolean isLent) {
        this.isLent = isLent;
    }

    public abstract void bookType(); // Method to identify type of book (Digital or Physical)

    @Override
    public String toString() {
        return "Title: " + title + ", Authors: " + String.join(", ", authors) + ", ISBN: " + ISBNL + ", Available: " + !isLent;
    }
}


