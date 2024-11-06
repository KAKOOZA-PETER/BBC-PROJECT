package librarymanagementsystem;

public class Researcher extends LibraryUser {
	   public Researcher(String name, String email, String password,String country_name ) {
	        super(name, email, password, country_name);
	    }

	    @Override
	    public void userType() {
	        System.out.println("Researcher");
	    }
	}
