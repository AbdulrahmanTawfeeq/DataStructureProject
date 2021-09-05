import java.util.Scanner;

/**
 * final class that cannot be extended
 * 
 * @author Ahmad
 *
 */
public final class Admin extends Person {

	public Admin(String username, String password, String email, String gender) {
		super(username, password, email, gender);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + "]";
	}

	@Override
	protected void contact() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String from = "From: " + email;
		System.out.println(from);

		System.out.print("To: ");
		String to = scan.nextLine();

		System.out.print("Subject: ");
		String subject = scan.nextLine();

		System.out.print("Message: ");
		String message = scan.nextLine();

		System.out.println("Write send to submit it: ");

		if (scan.nextLine().equalsIgnoreCase("send")) {
			String[][] addMessage = new String[1][4];
			addMessage[0][0] = from;
			addMessage[0][1] = to;
			addMessage[0][2] = subject;
			addMessage[0][3] = message;
		}
	}

}
