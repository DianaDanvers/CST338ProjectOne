import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
/*
    Title: ProjectOne
    Abstract: This project is to emulate the functionality of a university's database.
    In this program, the User can create a School, which holds three objects: Students, Courses, and Instructors.
    The User may perform: queries to info on all three objects, add Courses, assigned Instructors to Courses, and register Students for Courses.
    The queried info is explicitly calculating averages! Courses show Student averages, Students show average of all their Courses' scores.
    Student's Course scores may be updated, should they be enrolled in that Course. Courses may only be deleted when nobody is enrolled.
    Instructors are required to update the scores as well as know how many Students are enrolled in their Course(s).
    Author: Diana Andersen
    Date: 10/5/19

    Class Notes: All methods query if the Object exists or not first
 */

public class School {
    private HashMap<Integer, Instructor> instructors;
    private HashMap<Integer, Student> students;
    private HashMap<Integer, Course> courses;
    private String schoolName;

    // Constructor
    School(String schoolName) {
        this.schoolName = schoolName;
        instructors = new HashMap<>();
        students = new HashMap<>();
        courses = new HashMap<>();
    }

    // Getters
    Course getCourse(Integer courseID) {
        return courses.getOrDefault(courseID, null);
    }
    Student getStudent(Integer studentID) {
        return students.getOrDefault(studentID, null);
    }
    Instructor getInstructor(Integer courseID) {
        // Lookup is done by courseID, returns Instructor assigned to that course
        return doesExist(courseID, "c", "") ? courses.get(courseID).getInstructor() : null;
    }

    void addCourse(Integer courseID, String courseName, Integer courseCap, String courseRoom) {
        String error = "\nCourse addition failed - ";
        if (!courses.containsKey(courseID)) {
            Course x = new Course(courseID, courseName, courseCap, courseRoom);
            courses.put(courseID, x);
            return;
        }
        System.out.println(error + "Course number " + courseID + " already used.");
    }

    void deleteCourse(Integer courseID) {
        String error = "\nCourse deletion failed – ";
        if (doesExist(courseID, "c", error)) {
            if(!courses.get(courseID).isEmpty()){
                System.out.println(error + "Enrolled student" + (courses.get(courseID).getCourseOcc() <= 1 ? " " : "s " ) + "in " + courseID + ".");
            }
            else {
                courses.get(courseID).shutDown();
                courses.remove(courseID);
            }
        }
    }

    void addStudent(Integer studentID, String studentName) {
        String error = "\nStudent addition failed - ";
        if (!students.containsKey(studentID)) {
            Student x = new Student(studentID, studentName);
            students.put(studentID, x);
            return;
        }
        System.out.println(error + "Student ID " + studentID + " already used.");
    }

    void addInstructor(Integer teachID, String teachName, String teachMail, String teachPhone) {
        String error = "\nInstructor addition failed - ";
        if (!instructors.containsKey(teachID)) {
            Instructor x = new Instructor(teachID, teachName, teachMail, teachPhone);
            instructors.put(teachID, x);
            return;
        }
        System.out.println(error + "Employee number " + teachID + " already used.");
    }

    void schoolInfo() {
        // Displays all School Info
        System.out.println("School Name: " + schoolName);
        System.out.println("Instructor Information");
        for (HashMap.Entry<Integer, Instructor> i : instructors.entrySet()) {
            System.out.println(i.getValue().getTeachName());
        }
        System.out.println("Course Information");
        for (HashMap.Entry<Integer, Course> i : courses.entrySet()) {
            System.out.println(i.getValue().getCourseName());
        }
        System.out.println("Student Information");
        for (HashMap.Entry<Integer, Student> i : students.entrySet()) {
            System.out.println(i.getValue().getStudentName());
        }
    }

    void courseInfo() {
        // Displays Course Info by "courseID: NumEnrolled"
        System.out.println("Number of Courses: " + courses.size());
        for (HashMap.Entry<Integer, Course> i : courses.entrySet()) {
            System.out.println(i.getKey() + ": " + i.getValue().getCourseOcc() + " enrolled");
        }
    }

    void courseInfo(Integer courseID) {
        // Print Course Info on queried courseID
        String error = "\nCourse info failed - ";
        if (doesExist(courseID, "c", error)) {
            System.out.println(courses.get(courseID));
        }
    }


    void register(Integer courseID, Integer studentID) {
        String error = "\nRegistration failed - ";
        // Checks if Student enrolled in Course
        if (doesExist(courseID, "c", error) && doesExist(studentID, "s", error) && doesExist(courseID, "a", error)){
            if(!courses.get(courseID).enrolledStudent(studentID)) {
                courses.get(courseID).register(studentID);
                students.get(studentID).register(courseID, courses.get(courseID));
            } else {
                System.out.println(error + "Student " + studentID + " (" + students.get(studentID).getStudentName() + ") is already enrolled in " + courseID + ".");
            }
        }
    }

    void unRegister(Integer courseID, Integer studentID) {
        String error = "\nDeregistration error - ";
        // Checks if Student enrolled in Course to deregister
        if (doesExist(courseID, "c", error) && doesExist(studentID, "s", error)){
            if(courses.get(courseID).enrolledStudent(studentID)){
                courses.get(courseID).deRegister(studentID);
                students.get(studentID).deRegister(courseID);
            }
        }
    }

    void readData(String txt) {
        // Reads data in, String parsing is hardcoded for project
        File file = new File(txt);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                addItem(scanner, "i");
                addItem(scanner, "c");
                addItem(scanner, "s");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.close();
        System.out.println("Done");

    }

    void assignInstructor(Integer courseID, Integer teachID) {
        String error = "\nCourse assignment failed - ";
        if (doesExist(courseID, "c", error) && doesExist(teachID, "i", error)) {
            courses.get(courseID).setInstructor(instructors.get(teachID));
            instructors.get(teachID).addCourse(courseID, courses.get(courseID));
        }
    }

    void graduateStudent(Integer studentID) {
        String error = "\nGraduation failed - ";
        if (doesExist(studentID, "s", error)) {
            students.get(studentID).graduate();
            students.remove(studentID);
        }
    }

    void searchByEmail(String email) {
        // Instructor lookup by their email
        System.out.println("Search key : " + email);
        for (HashMap.Entry<Integer, Instructor> i : instructors.entrySet()) {
            if (i.getValue().getTeachMail().equals(email)) {
                i.getValue().getMailLookup();
                return;
            }
        }
        System.out.println("No employee with email " + email);
    }

    void putScore(Integer courseID, Integer studentID, Number score) {
        Double courseScore = score.doubleValue();
        String error = "\nGrade addition failed - ";
        // Checks if Student enrolled in Course
        if (doesExist(studentID, "s", error) && doesExist(courseID, "c", error)){
            if(courses.get(courseID).enrolledStudent(studentID)){
                courses.get(courseID).updateGradeBook(studentID, courseScore);
            } else {
                System.out.println(error + "Student " + studentID + " (" + students.get(studentID).getStudentName() + ") is not enrolled in " + courseID + ".");
            }
        }
    }

    boolean doesExist(Integer checkID, String type, String error) {
        // Global sanity check: Does Object exist?
        StringBuilder result = new StringBuilder(error);
        switch (type.substring(0,1)) {
            case "s":
                if (!students.containsKey(checkID)) {
                    result.append("Student ").append(checkID).append(" does not exist.");
                }
                break;
            case "i":
                if (!instructors.containsKey(checkID)) {
                    result.append("Employee  ").append(checkID).append(" does not exist.");
                }
                break;
            case "c":
                if (!courses.containsKey(checkID)) {
                    result.append("Course  ").append(checkID).append(" does not exist.");
                }
                break;
            case "a":
                if (!courses.get(checkID).availability()) {
                    result.append("class " + checkID + " is full!");
                }
                break;
            default:
                System.out.println("You Done Goofed");
                break;
        }
        if (!result.toString().equals(error)) {
            System.out.println(result);
            return false;
        }
        return true;
    }

    void addItem(Scanner scanner, String type){
        // Hardcoded parsing. User guarantees numLines of data, three times: Instructor, Course, Students in order. Vulnerable to User Error
        String info = "";
        String error = "Add Object Failed - Error";
        String numLines = scanner.nextLine();
        for(int i = 0; i < Integer.valueOf(numLines); i++) {
            info = scanner.nextLine();
            String[] infoArray = info.split(",");

            switch (type) {
                case "i":
                    addInstructor(Integer.valueOf(infoArray[0]), infoArray[1], infoArray[2], infoArray[3]);
                    break;
                case "c":
                    addCourse(Integer.valueOf(infoArray[0]), infoArray[1], Integer.valueOf(infoArray[2]), infoArray[3]);
                    break;
                case "s":
                    addStudent(Integer.valueOf(infoArray[0]), infoArray[1]);
                    break;
                default:
                    System.out.println(error);
                    break;
            }
        }
    }
}
















