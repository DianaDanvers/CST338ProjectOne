import java.util.HashMap;

public class Instructor {

    Integer teachID;
    String teachName;
    String teachMail;
    String teachPhone;
    HashMap<Integer, Course> instructingCourse;

    // Constructor
    Instructor(Integer teachID, String teachName, String teachMail, String teachPhone) {
        this.teachID = teachID;
        this.teachName = teachName;
        this.teachMail = teachMail;
        this.teachPhone = teachPhone;
        this.instructingCourse = new HashMap<>();
    }

    // Getters
    Integer getTeachID() {
        return teachID;
    }
    String getTeachName() {
        return teachName;
    }
    String getTeachMail() {
        return teachMail;
    }
    String getTeachPhone() {
        return teachPhone;
    }

    // Few Setters
    void addCourse(Integer courseID, Course course){
        instructingCourse.put(courseID, course);
    }
    void deRegister(Integer courseID){
        instructingCourse.remove(courseID);
    }

    // Single real method: Being found by email
    void getMailLookup(){
        System.out.println("Employee Number: " + getTeachID());
        System.out.println("Name: " + getTeachName());
        System.out.println("Phone: " + getTeachPhone());
    }

    // Contains all the Courses the Instructor teaches
    String teachingCourses(){
        StringBuilder result = new StringBuilder();
        for(HashMap.Entry<Integer, Course> i : instructingCourse.entrySet()){
            result.append("\n" + i.getValue().getCourseID() + ": " + i.getValue().getCourseOcc() + " enrolled");
        }
        return result.toString();
    }

    @Override
    public String toString(){
        return "Instructor Number: " + getTeachID() + "\n" +
                "Instructor Name: " + getTeachName() + "\n" +
                "Courses Teaching: " + teachingCourses();
    }
}
