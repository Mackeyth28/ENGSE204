package Lab2;
public class Lab12 {

    /**
     * The Course class represents a course with an ID and a name.
     */
    static class Course {
        // Attributes
        private String courseId;
        private String courseName;

        /**
         * Constructor to initialize a Course object.
         * @param courseId The unique identifier of the course.
         * @param courseName The name of the course.
         */
        public Course(String courseId, String courseName) {
            this.courseId = courseId;
            this.courseName = courseName;
        }

        /**
         * Returns the course information in the format "[courseId]: [courseName]".
         * @return The formatted string containing the course ID and name.
         */
        public String getCourseInfo() {
            // Requirement: Returns a String in the format "[courseId]: [courseName]"
            return "[" + courseId + "]: " + courseName;
        }
    }

    /**
     * The Student class represents a student with a name and an enrolled course.
     */
    static class Student {
        // Attributes
        private String studentName;
        private Course enrolledCourse;

        /**
         * Constructor to initialize a Student object.
         * @param studentName The name of the student.
         * @param enrolledCourse The Course object the student is enrolled in.
         */
        public Student(String studentName, Course enrolledCourse) {
            this.studentName = studentName;
            this.enrolledCourse = enrolledCourse;
        }

        /**
         * Displays the student's enrollment information.
         * The output format is:
         * Student: [studentName]
         * Enrolled in: [CourseInfo from enrolledCourse]
         */
        public void displayEnrollment() {
            // Requirement 1: Print "Student: [studentName]"
            System.out.println("Student: " + studentName);

            // Requirement 2: Print "Enrolled in: [CourseInfo from enrolledCourse]"
            // This calls the getCourseInfo() method on the enrolledCourse object.
            System.out.println("Enrolled in: " + enrolledCourse.getCourseInfo());
        }
    }

    // Main method to test the classes
    public static void main(String[] args) {
        // Test Case 1: ENGE174, Object Oriented Programming, Somsak Jaidee
        System.out.println("--- Test Case 1 ---");
        Course course1 = new Course("ENGE174", "Object Oriented Programming");
        Student student1 = new Student("Somsak Jaidee", course1);
        student1.displayEnrollment();
        System.out.println();

        // Test Case 2: GEN101, Physical Education, Suda Makmee
        System.out.println("--- Test Case 2 ---");
        Course course2 = new Course("GEN101", "Physical Education");
        Student student2 = new Student("Suda Makmee", course2);
        student2.displayEnrollment();
        System.out.println();

        // Test Case 3: MATH101, Calculus I, Piti Yindee
        System.out.println("--- Test Case 3 ---");
        Course course3 = new Course("MATH101", "Calculus I");
        Student student3 = new Student("Piti Yindee", course3);
        student3.displayEnrollment();
    }
}
