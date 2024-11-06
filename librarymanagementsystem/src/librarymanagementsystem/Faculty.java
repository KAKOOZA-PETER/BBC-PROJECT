package librarymanagementsystem;

public class Faculty extends LibraryUser {
	  public Faculty(String name, String email, String password, String country_name) {
	        super(name, email, password,country_name );
	    }

	    @Override
	    public void userType() {
	        System.out.println("Faculty");
	    }
	}
