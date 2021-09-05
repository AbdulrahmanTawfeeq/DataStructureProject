import java.util.Scanner;

/**
 * Abstract class that content users information as a database. It cannot be
 * instantiated anywhere.
 * 
 * @author Abdulrahman
 *
 */
public abstract class Database {
	protected final String webSiteName = "Komar University"; //Time complexity: cost=1 action, no. of times=1, O(1)
															 //Space complexity: cost=2 bytes(for each char), no. of elements=16, O(1)
	
	private String[][] userInfo = { //1st dimension
									//Time complexity: cost=1 action, no. of times=1
									//Space complexity: each element in the array costs constant bytes and we have constant elements in the array ==>4 inner arrays
									
			
			{ "User1", "1111" }, 	//2nd dimension
									//Time complexity: cost=1 action, no. of times=1
									/*Space complexity: cost=constant bytes, no. of elements=constant*/
			{ "User2", "2222" }, 
			{ "User3", "3333" },
			{ "Admin", "Admin" } 
	};
	//	1*1 + 1*1 =1 ===>Time complexity: O(1)
	//  C + C = C ignored ===> Space complexity: O(1)

	public Database() {
		// TODO Auto-generated constructor stub
		// to show that once instantiate the sub class, the constructor of the super
		// abstract class will be called
		System.out.println(webSiteName); //Time complexity: cost=1 action, no. of times=1, O(1)
										 //Space complexity: No declared variable
	}

	/**
	 * It can be directly used by any class that inherits this class. It is final,
	 * cannot be overridden
	 * 
	 * @param username
	 * @param password
	 * @return true only if the info are correct.
	 */
	protected final boolean fetchUserInfo(String username, String password) { //Space complexity: cost=2bytes, no. of char=n
		for (int r = 0; r < 4; r++) {					//Time complexity: cost=3 action, no. of times=5 //Space complexity: cost=4bytes, no. of variables=1
			if (userInfo[r][0].equals(username)) {      //Time complexity: cost=1 action(calling function), no. of times=4
				if (userInfo[r][1].equals(password)) {  //Time complexity: cost=1 action(calling function), no. of times=1
					return true; 						//Time complexity: cost=1 action, no. of times=1
				}
			}
		}
		return false;//Time complexity: cost=1 action, no. of times=1
	}
	//Time complexity for fetchUserInfo(): 3*5 + 1*4 +1*1 + 1*1 + 1*1=constant ===> O(1)
	//Space complexity:2*n + 4*1 =2n+4 ===> O(n)

	/**
	 * Method with default visibility to get all the names of the users. Only the
	 * admin can get the results It is final, cannot be overridden
	 * 
	 * @param username
	 * @param password
	 */
	final void getUsers() {
		System.out.println(" ");
		System.out.println("Username and Password are required to complete...");
		Scanner input = new Scanner(System.in);
		System.out.println("Username: ");
		String username = input.nextLine();

		System.out.println("Password: ");
		String password = input.nextLine();
		if (username.equals(userInfo[3][0]) && password.equals(userInfo[3][1])) {
			System.out.println("Users' names:");
			for (int r = 0; r < 4; r++) {
				System.out.println((r + 1) + ": " + userInfo[r][0]);
			}
		} else {
			System.out.println("Permission Dined!");
		}
	}

	/**
	 * Static method that cannot be overridden in the child classes
	 */
	protected static void about_komar() {
		System.out.println("");
		System.out.println("University Name: Komar University of Science and Technology");
		System.out.println("Place: Qularaisy");
		System.out.println("Type: Private University");
		System.out.println(
				"Available Departments: Computer Science | Computer Engineering | Pharmacy | Dentistry | Nursing");
		System.out.println("");
	}

}
