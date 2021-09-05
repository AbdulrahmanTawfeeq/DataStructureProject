import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Instructor extends User {
	private BinaryTree tree;
	private LinkedList<Course> myCourses;

	public Instructor(String username, String password, String email, String gender) {
		super(username, password, email, gender);
		// TODO Auto-generated constructor stub
	}

	public void attendance(Stack<Integer> s) {
		try {
			this.tree = new BinaryTree();
			Scanner scan = new Scanner(System.in);
			Iterator<Integer> iterator = s.iterator();
			System.out.println("\nEnter false for absence and true for the attendance");
			while (iterator.hasNext()) {
				int value = iterator.next();
				BinaryNode node = new BinaryNode(value);
				tree.insert(node);
				System.out.println("Student id " + value + ": ");
				boolean result = scan.nextBoolean();
				node.setBool(result);
			}

			System.out.println("ID   Attendance");
			tree.byLevelWithBool();
		} catch (Exception e) {
			if (e instanceof InputMismatchException) {
				System.out.println("Input true or false only, try again.");
			} else {
				System.err.println(e.getMessage());
			}
		}
	}

	public void isAttend(int student_id) {
		try {
			if (this.tree.getRoot() != null) {
				BinaryNode check = tree.searchBinaryNode(student_id);
				if (check != null) {
					System.out.print("Student No." + check.getData());
					if (check.isBool()) {
						System.out.println(" is present.");
					} else {
						System.out.println(" is absence!");
					}
				} else {
					System.out.println("Student id is not found!");
				}
			} else {
				System.out.println("The list is null!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addCourses(String... array) {
		try {
			myCourses = new LinkedList<Course>();
			for (int i = 0; i < array.length; i++) {
				myCourses.add(new Course(array[i]));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void showCourses() {
		try {
			if(this.myCourses.size() == 0) {
				System.out.println("No courses!");
			}else {
				for (int i = 0; i < myCourses.size(); i++) {
					System.out.println(i + 1 + ": " + myCourses.get(i));
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void deleteCourseByKey(int index) {
		try {
			this.myCourses.remove(index);
			System.out.println("Removed");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
	
	public void deleteAllCourses() {
		try {
			this.myCourses.clear();
			System.out.println("Cleared");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public String toString() {
		return "Instructor [email=" + email + ", gender=" + gender + ", webSiteName=" + webSiteName + "]";
	}

}
