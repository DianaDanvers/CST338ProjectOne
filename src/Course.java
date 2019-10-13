
import java.util.HashMap;

public class Course {
    Integer courseID;
    String courseName;
    Integer courseCap;
    String courseRoom;

    HashMap<Integer,Double> gradeBook;
    Instructor instructor;

    // Constructor
    Course(Integer courseID, String courseName, Integer courseCap, String courseRoom) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCap = courseCap;
        this.courseRoom = courseRoom;
        this.gradeBook = new HashMap<>();
        this.instructor = new Instructor(999999,"XXX","XXX@XGMAIL.COM","XXX-XXX-XXX");
    }

    // Getters
    Integer getCourseID() {
        return courseID;
    }
    String getCourseName() {
        return courseName;
    }
    Integer getCourseCap() {
        return courseCap;
    }
    String getCourseRoom() {
        return courseRoom;
    }
    Integer getCourseOcc(){
        return gradeBook.size();
    }
    Instructor getInstructor() {
        return instructor;
    }

    // Necessary Setters
    void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    void updateLocation(String newRoom) {
        this.courseRoom = newRoom;
    }
    void updateGradeBook(Integer studentID, Double courseScore){
        this.gradeBook.put(studentID,courseScore);
    }
    void register(Integer studentID){
        this.gradeBook.put(studentID, 0.0);
    }
    void deRegister(Integer studentID){
        this.gradeBook.remove(studentID);
    }

    // Checks if there is room for Students
    Boolean availability(){
        return getCourseCap() - getCourseOcc() > 0;
    }
    Boolean enrolledStudent(Integer studentID) {
        return gradeBook.containsKey(studentID);
    }
    Boolean isEmpty(){
        return getCourseOcc() == 0;
    }

    // Deleting the Course: Unassigned Instructor, clear gradeBook (Extra: I think garbage collector would do this but I didn't risk it)
    void shutDown() {
        instructor.deRegister(getCourseID());
        gradeBook.clear();
        this.instructor = null;
    }

    // Returns grades
    Double getCourseAvg(){
        Double culm = 0.0;
        for(HashMap.Entry<Integer , Double> i : gradeBook.entrySet()){
            culm += i.getValue();
        }
        Double i = (culm / gradeBook.size());
        return i.isNaN(i) ? 0.0 : i;
    }
    Double getMyGrades(Integer studentID){
        return gradeBook.get(studentID);
    }

    @Override
    public String toString(){
        return "Course Number: " + getCourseID() +
                "\nInstructor " + getInstructor().getTeachName() +
                "\nCourse Title: " + getCourseName() +
                "\nRoom: " + getCourseRoom() +
                "\nTotal Enrolled: " + getCourseOcc() +
                "\nCourse Average: " + getCourseAvg();
    }
}
