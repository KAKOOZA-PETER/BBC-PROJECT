package librarymanagementsystem;

public class Student extends LibraryUser {
    public Student(String name, String email, String password, String country_name) {
        super(name, email, password, country_name);
    }

    @Override
    public void userType() {
        System.out.println("Student");
    }
}
