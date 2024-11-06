package librarymanagementsystem;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Library {
	  private List<Book> books = new ArrayList<>();
	    private static final double MAX_BOOKS =3000000 ;

	    public void addBook() {
	        if (books.size() >= MAX_BOOKS) {
	            System.out.println("Library is at full capacity.");
	            return;
	        }

	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter book type (Digital/Physical): ");
	        String bookType = scanner.nextLine();

	        System.out.print("Enter title: ");
	        String title = scanner.nextLine();

	        System.out.print("Enter number of authors: ");
	        int authorCount = scanner.nextInt();
	        scanner.nextLine();
	        String[] authors = new String[authorCount];
	        for (int i = 0; i < authorCount; i++) {
	            System.out.print("Enter author " + (i + 1) + ": ");
	            authors[i] = scanner.nextLine();
	        }

	        System.out.print("Enter ISBN: ");
	        int isbn = scanner.nextInt();

	        Book book;
	        if (bookType.equalsIgnoreCase("Digital")) {
	            book = new DigitalBook(title, authors, isbn);
	        } else if (bookType.equalsIgnoreCase("Physical")) {
	            book = new PhysicalBook(title, authors, isbn);
	        } else {
	            System.out.println("Invalid book type.");
	            return;
	        }

	        books.add(book);
	        System.out.println("Book added: " + book);
	    }

	    public void lendBook(int isbn, LibraryUser user) {
	        for (Book book : books) {
	            if (book.getISBNL() == isbn && !book.getIsLent()) {
	                book.setIsLent(true);
	                System.out.println("Book lent to " + user.getName());
	                return;
	            }
	        }
	        System.out.println("Book unavailable or already lent.");
	    }

	    public void returnBook(int isbn) {
	        for (Book book : books) {
	            if (book.getISBNL() == isbn && book.getIsLent()) {
	                book.setIsLent(false);
	                System.out.println("Book returned.");
	                return;
	            }
	        }
	        System.out.println("Book not found or not currently lent.");
	    }

	    public void showAllBooks() {
	        for (Book book : books) {
	            System.out.println(book);
	        }
	    }

	    public void sendEmailReminder(LibraryUser user) {
	        System.out.println("Email reminder sent to " + user.getEmail() + " to return book.");
	    }

	    public void applyFine(LibraryUser user) {
	        System.out.println(user.getName() + " has been fined for a lost book.");
	    }

	    public void saveLibraryData() {
	        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("library_data.ser"))) {
	            out.writeObject(books);
	            System.out.println("Library data saved.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void loadLibraryData() {
	        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("library_data.ser"))) {
	            books = (List<Book>) in.readObject();
	            System.out.println("Library data loaded.");
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("No previous data found, starting new library.");
	        }
	    }
	}
