import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Student extends User {
	private String code;
	private Course[] courses = new Course[5]; // Student can add 5 courses as max

	public Student(String username, String password, String email, String gender, String code) {
		super(username, password, email, gender);
		this.code = code;
	}

	/**
	 * In case student adds more than 5 courses, the length will increase to be
	 * doubled and he will be able to add 10 courses as max
	 * 
	 * @param courseName
	 */
	public void addCourses(Course... courseName) {
		try {
			for (int i = 0; i < courseName.length; i++) {
				this.courses[i] = courseName[i];
			}
		} catch (Exception e) {
			if (e instanceof java.lang.ArrayIndexOutOfBoundsException) {
				this.courses = new Course[this.courses.length * 2];
				for (int i = 0; i < courseName.length; i++) {
					this.courses[i] = courseName[i];
				}
			}
		}
	}

	public void calcMyAverage() {
		System.out.println("Enter (ok) to get the result");
		System.out.println("Enter (rm) to remove the last grade you entered");
		System.out.println("Enter (rmElem) to remove any grade you entered");
		System.out.println("Enter (cls) to remove all the previous grades\n");
		ArrayList<Double> grades = new ArrayList<Double>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the grades of your courses: ");
		int i = 0;
		while (true) {
			System.out.print("Course NO. " + (i + 1) + " :");
			String input = scan.nextLine();

			try {
				if (input.equalsIgnoreCase("ok")) {
					break;
				} else if (input.isEmpty()) {
					continue;
				}

				if (input.equalsIgnoreCase("rm")) {
					grades.remove(grades.size() - 1);
				}

				if (input.equalsIgnoreCase("rmElem")) {
					System.out.print("Enter the grade to be deleted: ");
					grades.remove(grades.get(grades.indexOf(scan.nextDouble())));
				}

				if (input.equalsIgnoreCase("cls")) {
					grades.clear();
				}

				if (!input.equalsIgnoreCase("rm") && !input.equalsIgnoreCase("rmElem")
						&& !input.equalsIgnoreCase("cls")) {
					double grade = Double.parseDouble(input);
					grades.add(grade);
				}

			} catch (Exception e) {
				if (e instanceof IndexOutOfBoundsException) {
					System.err.println("No grade to be removed!");
				} else if (e instanceof NumberFormatException) {
					System.err.println("Enter double value only for the grades!");
				} else {
					System.err.println(e.getMessage());
				}
			}

			i++;
		}

		double addtion = 0;
		System.out.println("");
		grades.sort(Comparator.reverseOrder());
		System.out.println("The Grades You Entered (Sorted Descending)");
		for (Double double1 : grades) {
			System.out.println(double1);
			addtion += double1;
		}
		System.out.println("You Entered Grades for " + grades.size() + " Courses");
		System.out.println("\nYour Average: " + addtion / grades.size());

	}

	public String getCode() {
		return code;
	}

	public Course[] getCourses() {
		return courses;
	}

	@Override
	public String toString() {
		return "Student [code=" + code + ", courses=" + Arrays.toString(courses) + "]";
	}

}
