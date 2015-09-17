package apigee;
import java.util.*;


class CourseManagementSystem {
    List<Enrollment> enrolling;
    List<Student> student;
    List<Course> course;
    private String programmeName;

    public CourseManagementSystem(String programmeName) {
        this.programmeName = programmeName;
        System.out.println(programmeName);
        enrolling = new ArrayList<Enrollment>();
        student = new ArrayList<Student>();
        course = new ArrayList<Course>();
    }

    public String getProgrammeName() {
        return programmeName;
    }


    public List<Course> getCourses() {
        return this.course;
    }

    public List<Student> getStudents() {
        return this.student;
    }

    public String toString() {
        String output;
        output = programmeName+"\n";
        output = output + "students list " +this.student+"\n";
        output = output + "course list " +this.course;
        return output;
    }

    public void addCourse(Course course) {
        this.course.add(course);
    }

    public void addStudent(Student student) {
        this.student.add(student);
    }

    public void enroll(Student student, Course[] c) {
        //System.out.println("********"+c.length);
        for(int i = 0; i < c.length ; i++) {
            Enrollment enrolls = new Enrollment(student,c[i]);
            enrolling.add(enrolls);
        }
        //System.out.println("********"+enrolling.size());
    }

    public Enrollment[] getEnrollments() {
        Enrollment[] courses = new Enrollment[enrolling.size()];
        for(int j = 0; j < enrolling.size(); j++) {
            courses[j] = enrolling.get(j);
            //System.out.println("*********"+courses[j]);
        }
        return courses;
    }

    public void awardGrade(Student student, Course c, int gradePoint) {
        for (int i = 0; i < enrolling.size(); i++) {
            if((enrolling.get(i).getStudent().equals(student)) &&
                    (enrolling.get(i).getCourse().equals(c)))
                enrolling.get(i).setGradePoints(gradePoint);
        }
    }

    public void computeGPA() {

        double gpa = 0.0D;
        for(int i = 0; i < student.size(); i++) {
            int sumGrade=0;
            int sumCredit=0;
            for(int j = 0; j < enrolling.size(); j++) {
                if((student.get(i).getStudentName()).equals(enrolling.get(j).getStudent().getStudentName())) {
                    sumGrade = sumGrade + ((enrolling.get(j).getGradePoints()) * (enrolling.get(j).getCourse().getCreditPoints()));  
                    sumCredit = sumCredit +(enrolling.get(j).getCourse().getCreditPoints());
                    //System.out.println(sumGrade+"   "+sumCredit);
                }
                //gpa = (float)sumGrade/sumCredit;
            }
            gpa = (float)sumGrade/sumCredit;
            double a = Math.round(gpa*100) / 100.0;
            student.get(i).setGPA(a);
        }
    }

    public String generateTranscript(Student s) {
        String output;
        output = s+ " has enrolled in "+ course.size() + " courses and obtained the following grades.\n";
        for(int i = 0; i < enrolling.size(); i++) 
            if(s.getStudentName().equals(enrolling.get(i).getStudent().getStudentName())){
                output = output +enrolling.get(i).getCourse().getCourseName() + " :" + enrolling.get(i).getGradePoints() + "\n";
            }

        output = output + "GPA :" + s.getGPA();
        return output;
    }
}


class Enrollment {
    /** 
     * here the course class is started and here wew are assigning the variables.
     */
    private Student student;
    private Course course;
    private int gradePoints;

    /**
     * we are creating a constructor with parameters of the student and course.
     * @param student as the parameter.
     * @param course as the parameter.
     */
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    /** 
     * @param we are passing the student as the parameter.
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /** 
     * @param we are passing the course as the parameter.
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /** 
     * @param we are passing the gradepoints as the parameter.
     */
    public void setGradePoints(int gradePoints) {
        this.gradePoints = gradePoints;
    }

    /** 
     * @return we are getting the student.
     */
    public Student getStudent() {
        return this.student;
    }

    /** 
     * @return we are getting the course.
     */
    public Course getCourse() {
        return this.course;
    }

    /** 
     * @return we are getting the gradepoints.
     */
    public int getGradePoints() {
        return this.gradePoints;
    }

    public String toString() {
        String output;
        output = student+" is enrolled in the ";
        output = output + course;
        output = output +"and grade points are :" +gradePoints+"\n";
        return output;
    }
}



class Student {
    /** 
     * here we are declaring the studentName as parameter.
     */
    private String studentName;
    private double gpa;

    /**
     * we are creating a constructor with parameters of studentname.
     * @param studentname as the parameter.
     */
    public Student(String studentName) {
        this.studentName = studentName;
    }

    /** 
     * @param we are passing the studentname as the parameter.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /** 
     * @return we are getting the studentname.
     */
    public String getStudentName() {
        return studentName;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public double getGPA() {
        return gpa;
    }

    public String toString() {
        return studentName;
    }
}


class Course {
    /** 
     * here the course class is started and here wew are assigning some variables.
     */
    private String courseName;
    private int creditPoints;

    /**
     * we are creating a constructor with parameters of the coursename and creditpoints.
     * @param coursename as the parameter.
     * @param creditpoints as the parameter.
     */
    public Course(String courseName, int creditPoints) {
        this.courseName = courseName;
        this.creditPoints = creditPoints;
    }

    /** 
     * @param we are passing the coursename as the parameter.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /** 
     * @param we are passing the creditpoints as the parameter.
     */
    public void setCredits(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    /** 
     * @return we are getting the coursename.
     */
    public String getCourseName() {
        return courseName;
    }

    /** 
     * @return we are getting the creditpoints.
     */
    public int getCreditPoints() {
        return creditPoints;
    }

    /** 
     * displaying all the valiables in the form of tostring method.
     */
    public String toString(){
        String output;              //code should be in a tab width of 2
        output = "course " +courseName + " ";
        output += "creditpoints is "+creditPoints + " ";
        return output;
    }
}
// test class
public class CourseManagementTest {

    public static void main(String[] args) {

        CourseManagementSystem cms = new CourseManagementSystem("IIIT-MSIT");

        /* create courses */
        Course c1 = new Course("IT Workshop", 2);
        Course c2 = new Course("Intro Programming", 4);
        cms.addCourse(c1);
        cms.addCourse(c2);

        /* create students */
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");
        Student s4 = new Student("Dexter");
        Student s5 = new Student("Emma");
        cms.addStudent(s1);
        cms.addStudent(s2);
        cms.addStudent(s3);
        cms.addStudent(s4);
        cms.addStudent(s5);

        /* enroll students */
        Course[] c = new Course[2];
        c[0] = c1;
        c[1] = c2;

        /* pass an array of course objects
         * enroll the student into every course */
        cms.enroll(s1, c);
        cms.enroll(s2, c);
        cms.enroll(s3, c);
        cms.enroll(s4, c);
        cms.enroll(s5, c);

        /*
         * Get the enrolled courses in the same order of enrollement
         */
        Enrollment[] courses = cms.getEnrollments();

        /* award grade points */
        cms.awardGrade(s1, c[0], 10);
        cms.awardGrade(s1, c[1], 8);
        cms.awardGrade(s2, c[0], 10);
        cms.awardGrade(s2, c[1], 6);
        cms.awardGrade(s3, c[0], 8);
        cms.awardGrade(s3, c[1], 8);
        cms.awardGrade(s4, c[0], 7);
        cms.awardGrade(s4, c[1], 9);
        cms.awardGrade(s5, c[0], 10);
        cms.awardGrade(s5, c[1], 10);

        /* compute GPA should compute the GPA for all the students 
         * Set the calculated GPA to the private instance variable of Student
         */
        cms.computeGPA();

        /* get GPA and print 
         * Expected Output for s1:
         * 8.67
         */
        System.out.println(s1.getGPA());
        System.out.println(s2.getGPA());
        System.out.println(s3.getGPA());
        System.out.println(s4.getGPA());
        System.out.println(s5.getGPA());

        /* generate transcript and print 
         * Expected Output for s1:
         * Alice has enrolled in 2 courses and obtained the following grades.
         * IT Workshop - 10
         * Intro Programming - 8
         * GPA is 8.67
         */
        System.out.println(cms.generateTranscript(s1));
        System.out.println(cms.generateTranscript(s2));
        System.out.println(cms.generateTranscript(s3));
        System.out.println(cms.generateTranscript(s4));
        System.out.println(cms.generateTranscript(s5));
    }
}