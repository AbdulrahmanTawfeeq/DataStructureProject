
public class Course {
	private String courseName;
	private String courseCode;

	public Course(String courseName, String courseCode) {
		super();
		this.courseName = courseName;
		this.courseCode = courseCode;
	}
	
	public Course(String courseName) {
		this.courseName = courseName;
		this.courseCode = null;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseCode=" + courseCode + "]";
	}

}
