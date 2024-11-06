package librarymanagementsystem;
import java.io.Serializable;
	public abstract class LibraryUser implements Serializable {
	    private String name;
	    private String email;
	    private String password;
	    private String country_name;

	    public LibraryUser(String name, String email,String password, String country_name) {
	        this.name = name;
	        this.email = email;
	        this.password = password;
	        this.country_name = country_name;
	    }

	    public abstract void userType(); // Identify user type (Student, Researcher, Faculty)

	    public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }
	    public String getPassword () {
	        return password;
	}
	    public String getCountry_name() {
	        return country_name;
	}
	}
