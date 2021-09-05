import java.util.Scanner;

/**
 * User class that inherites the Database abstract class
 * 
 * @author Abdulrahman
 *
 */
public abstract class Person extends Database {
	private String username; // Encapsulation
	private String password; // Encapsulation
	protected String email;
	protected final String gender; // blank final variable should be instantiated in all the constructors

	/**
	 * Constructor
	 * 
	 * @param username
	 * @param password
	 */
	public Person(String username, String password, String email, String gender) {
		super();
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Person(String gender) {
		this.gender = gender;
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * public method for login the user into the system if he input the right
	 * username and password. It uses the fetchUserInfo() from the parent class. It
	 * uses other two private helper methods in this class. It is final, cannot be
	 * overridden
	 */
	public final void login() {
		if (fetchUserInfo(username, password)) {
			welcome(username);
		} else {
			while (tryAgain() == false) {
				tryAgain();
			}
		}

	}

	/**
	 * Private helper method that can only be used in this class to let the user to
	 * input his username and password to try to login again
	 * 
	 * @return
	 */
	private boolean tryAgain() {
		System.out.println("Try to login again with the correct username and password!!");

		Scanner input = new Scanner(System.in);

		System.out.println("Username: ");
		String user = input.nextLine();

		System.out.println("Password: ");
		String pass = input.nextLine();

		if (fetchUserInfo(user, pass)) {
			welcome(user);
			return true;
		}
		return false;
	}

	/**
	 * Private helper method that can be used only in this class to print the
	 * welcome method.
	 * 
	 * @param username
	 */
	private void welcome(String username) {
		System.out.println("Hello " + username + ", you are logged in.");
	}

	protected abstract void contact();

	@Override
	public String toString() {
		return "Person [username=" + username + ", password=" + password + "]";
	}

}
