package librarymanagementsystem;

public class DigitalBook extends Book {
	   public DigitalBook(String title, String[] authors, int isbn) {
	        super(title, authors, isbn);
	    }

	    @Override
	    public void bookType() {
	        System.out.println("Digital Book");
	    }
	}
