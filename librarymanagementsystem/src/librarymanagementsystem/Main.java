package librarymanagementsystem;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.out.print("===== WELOCOME TO MUBS OPEN LIBRARY====");
	        Library library = new Library();
	        library.loadLibraryData();
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter user type (Student, Researcher, Faculty): ");
	        String userType = scanner.nextLine();
	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter your email: ");
	        String email = scanner.nextLine();
	        System.out.print("Enter your password: ");
	        String password= scanner.nextLine();
	        System.out.print("Enter your country_name: ");
	        String country_name= scanner.nextLine();

	        LibraryUser libraryUser;
	        switch (userType.toLowerCase()) {
	            case "student":
	                libraryUser = new Student(name, email, password, country_name);
	                break;
	            case "researcher":
	                libraryUser = new Researcher(name, email,  password, country_name );
	                break;
	            case "faculty":
	                libraryUser = new Faculty(name, email,password, country_name );
	                break;
	            default:
	                System.out.println("Invalid user type.");
	                return;
	        }

	        while (true) {
	            System.out.println("\nLibrary System:");
	            System.out.println("1. Add Book");
	            System.out.println("2. Lend Book");
	            System.out.println("3. Return Book");
	            System.out.println("4. Show All Books");
	            System.out.println("5. Send Reminder/Fine");
	            System.out.println("6. Exit");
	            System.out.print("Choose an option: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    library.addBook();
	                    break;
	                case 2:
	                    System.out.print("Enter ISBN to lend: ");
	                    int lendIsbn = scanner.nextInt();
	                    library.lendBook(lendIsbn, libraryUser);
	                    break;
	                case 3:
	                    System.out.print("Enter ISBN to return: ");
	                    int returnIsbn = scanner.nextInt();
	                    library.returnBook(returnIsbn);
	                    break;
	                case 4:
	                    library.showAllBooks();
	                    break;
	                case 5:
	                    System.out.println("Choose an action:");
	                    System.out.println("1. Send Reminder to Return Book");
	                    System.out.println("2. Issue Fine for Lost Book");
	                    int action = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    if (action == 1) {
	                        library.sendEmailReminder(libraryUser);
	                    } else if (action == 2) {
	                        library.applyFine(libraryUser);
	                    } else {
	                        System.out.println("Invalid action.");
	                    }
	                    break;
	                case 6:
	                    library.saveLibraryData();
	                    System.out.println("Library data saved. Exiting Library System.");
	                    return;
	                default:
	                    System.out.println("Invalid option. Try again.");
	            }
	        }
	    
	
	}

}
