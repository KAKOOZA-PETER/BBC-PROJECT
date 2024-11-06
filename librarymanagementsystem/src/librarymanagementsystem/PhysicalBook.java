package librarymanagementsystem;

public class PhysicalBook extends Book {
	 public PhysicalBook(String title, String[] authors, int isbn) {
	        super(title, authors, isbn);
	    }

	    @Override
	    public void bookType() {
	        System.out.println("Physical Book");
	    }
	}
