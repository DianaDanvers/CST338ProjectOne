import java.util.HashMap;

class Student {

    Integer studentID;
    String studentName;
    HashMap<Integer, Course> studentGrades;

    // Constructor
    Student(Integer studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentGrades = new HashMap<>();
    }

    // Getters
    Integer getStudentID() {
        return studentID;
    }
    String getStudentName() {
        return studentName;
    }
    HashMap<Integer, Course> getStudentGrades(){
        return studentGrades;
    }

    // Adds/removes Courses that Student is enrolled in
    void register(Integer courseID, Course course){
        studentGrades.put(courseID, course);
    }
    void deRegister(Integer courseID){
        studentGrades.remove(courseID);
    }

    // Remove Student from all Courses they are enrolled in
    void graduate() {
        for (HashMap.Entry<Integer, Course> i : studentGrades.entrySet()) {
            i.getValue().deRegister(getStudentID());
        }
        studentGrades.clear();
    }

    // Get grades
    String getGradeBook(){
        StringBuilder result = new StringBuilder();
        for(HashMap.Entry<Integer, Course> i : studentGrades.entrySet()) {
            result.append(i.getKey()).append(": ").append(i.getValue().getMyGrades(getStudentID())).append("\n");
        }
        return result.toString();
    }
    Double getStudentAvg(){
        Double avg = 0.0;
        for(HashMap.Entry<Integer, Course> i : getStudentGrades().entrySet()) {
            avg += i.getValue().getMyGrades(getStudentID());
        }
        Double x = avg / studentGrades.size();
        return x.isNaN(x) ? 0.0 : x;
    }

    @Override
    public String toString(){
        return "Student Name: " + getStudentName() + "\n"+
                "Student ID: " + getStudentID() + "\n" +
                "Course" + (studentGrades.size() <= 1 ? " " : "s " ) + "enrolled \n" +
                getGradeBook() +
                "Class Avg: " + getStudentAvg() + "\n";
    }
}
