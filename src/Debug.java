import java.util.Scanner;

public class Debug {
    void main(){
        School SCD = new School("SCD");

        Integer num = 0;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter testCase you wish to run. \n[1 - 12, 13(schoolDemo1), 14(schoolDemo2), 15(schoolDemo3)]: ");

        String numString = myObj.nextLine();  // Read user input
        num = Integer.valueOf(numString);

        switch(num){
            case 1:
                //txt
                SCD.readData(".//src//testCases//test1.txt");

//                SCD.addInstructor(100,"Y. Byun","ybyun@csumb.edu","111-111-1111");
//                SCD.addCourse(301,"CST301 - Course 301",100,"BIT 101");
//                SCD.addStudent(7777, "Alice Otter");

                // Code
                System.out.println("\n\n===== ANSWER: 1 Instructor (Y. Byun), 1 Course (CST338), 1 Student (Alice Otter) =====\n");
                SCD.schoolInfo();

                break;
            case 2:
                //txt
                // SCD.readData("C:\\tmp\\test2.txt");
                SCD.readData(".//src//testCases//test1.txt");

//                SCD.addInstructor(100,"Y. Byun","ybyun@csumb.edu","111-111-1111");
//                SCD.addCourse(301,"CST301 - Course 301",100,"BIT 101");
//                SCD.addStudent(7777, "Alice Otter");

                System.out.println("\n\n===== ANSWER: 3 fail messages. One instructor fail, one course fail, one student fail. =====\n");

                SCD.readData(".//src//testCases//test2.txt");

//                SCD.addInstructor(200,"B. BBB","bbb@csumb.edu","222-222-2222");
//                SCD.addInstructor(300,"C. CCC","ccc@csumb.edu","333-333-3333");
//                SCD.addInstructor(100,"A. AAA","aaa@csumb.edu","111-111-0000");
//                SCD.addInstructor(400,"D. DDD","ddd@csumb.edu","444-444-4444");
//                SCD.addInstructor(500,"E. EEE","eee@csumb.edu","555-555-5555");
//                SCD.addCourse(301,"CST301 - Course 301",50,"BIT 101");
//                SCD.addCourse(302,"CST302 - Course 302",40,"BIT 102");
//                SCD.addCourse(303,"CST303 - Course 303",30,"BIT 104");
//                SCD.addCourse(338,"CST338 - Course 338",10,"BIT 104");
//                SCD.addCourse(305,"CST305 - Course 305",10,"BIT 105");
//                SCD.addCourse(306,"CST306 - Course 306",10,"BIT 101");
//                SCD.addCourse(307,"CST307 - Course 307",20,"BIT 102");
//                SCD.addStudent(8888,"Bob Otter");
//                SCD.addStudent(7777,"Unknown Otter");

                break;
            case 3:
                //  SCD.readData("C:\\tmp\\test3.txt");
                SCD.readData(".//src//testCases//test3.txt");

//                SCD.addInstructor(100,"A. AAA","aaa@csumb.edu","111-111-0000");
//                SCD.addInstructor(200,"B. BBB","bbb@csumb.edu","222-222-2222");
//                SCD.addInstructor(300,"C. CCC","ccc@csumb.edu","333-333-3333");
//                SCD.addInstructor(400,"D. DDD","ddd@csumb.edu","444-444-4444");
//                SCD.addInstructor(500,"E. EEE","eee@csumb.edu","555-555-5555");
                System.out.println("\n\n===== ANSWER: The program should display three failed course additions. =====\n");
//                SCD.addCourse(301,"CST301 - Course 301",50,"BIT 101");
//                SCD.addCourse(302,"CST302 - Course 302",40,"BIT 102");
//                SCD.addCourse(303,"CST303 - Course 303",30,"BIT 104");
//                SCD.addCourse(338,"CST338 - Course 338",10,"BIT 104");
//                SCD.addCourse(305,"CST305 - Course 305",10,"BIT 105");
//                SCD.addCourse(306,"CST306 - Course 306",10,"BIT 101");
//                SCD.addCourse(307,"CST307 - Course 307",20,"BIT 102");
//                SCD.addStudent(7777,"Alice Otter");

                //Code
                SCD.addCourse(301, "CST301 - Incorrect Course A", 10, "ERROR301");
                SCD.addCourse(308, "CST308 - Course 308", 30, "BIT103");
                SCD.addCourse(309, "CST309 - Course 309", 40, "BIT104");
                SCD.addCourse(308, "CST308 - Incorrect Course B", 10, "ERROR308");
                SCD.addCourse(305, "CST305 - Incorrect Course C", 10, "ERROR305");
                SCD.addCourse(310, "CST310 - Course 310", 50, "BIT105");
                break;
            case 4:
                //       SCD.readData("C:\\tmp\\test4.txt");
                SCD.readData(".//src//testCases//test4.txt");

//                SCD.addInstructor(100,"A. AAA","aaa@csumb.edu","111-111-1111");
//                SCD.addCourse(301,"CST301 - Course 301",100,"BIT 101");
//                SCD.addStudent(7777,"Alice Otter");

                // Code
                SCD.addInstructor(200, "B. BBB", "bbb@csumb.edu", "222-222-2222");
                SCD.addInstructor(300, "C. CCC", "ccc@csumb.edu", "333-333-3333");
                SCD.addCourse(302, "CST302 - Course 302", 20, "BIT102");
                SCD.addCourse(303, "CST303 - Course 303", 30, "BIT103");
                SCD.addCourse(304, "CST304 - Course 304", 10, "BIT104");
                SCD.addCourse(305, "CST305 - Course 305", 20, "BIT105");
                SCD.assignInstructor (301, 100);
                SCD.assignInstructor (302, 200);
                SCD.assignInstructor (303, 300);
                System.out.println("\n\n===== ANSWER: Two error messages for non-existing instructors. =====\n");
                SCD.assignInstructor (304, 400);
                SCD.assignInstructor (305, 500);
                break;
            case 5:
                Course course305;

                //   SCD.readData("C:\\tmp\\test5.txt");
                SCD.readData(".//src//testCases//test5.txt");

//                SCD.addInstructor(100,"A. AAA","aaa@csumb.edu","111-111-0000");
//                SCD.addInstructor(200,"B. BBB","bbb@csumb.edu","222-222-2222");
//                SCD.addInstructor(300,"C. CCC","ccc@csumb.edu","333-333-3333");
//                SCD.addInstructor(400,"D. DDD","ddd@csumb.edu","444-444-4444");
//                SCD.addInstructor(500,"E. EEE","eee@csumb.edu","555-555-5555");
//                SCD.addCourse(301,"CST301 - Course 301",50,"BIT 101");
//                SCD.addCourse(302,"CST302 - Course 302",40,"BIT 102");
//                SCD.addCourse(303,"CST303 - Course 303",30,"BIT 104");
//                SCD.addCourse(338,"CST338 - Course 338",10,"BIT 104");
//                SCD.addCourse(305,"CST305 - Course 305",10,"BIT 105");
//                SCD.addCourse(306,"CST306 - Course 306",10,"BIT 101");
//                SCD.addCourse(307,"CST307 - Course 307",20,"BIT 102");
//                SCD.addStudent(1111,"AAA AAAAA");
//                SCD.addStudent(2222,"FFF FFFFF");

                // Code
                SCD.assignInstructor (305, 100);
                SCD.register (305, 1111);
                SCD.register (305, 2222);
                SCD.putScore (305, 1111, 100.0);
                SCD.putScore (305, 2222, 50.0);

                course305 = SCD.getCourse(305);
                course305.updateLocation("ERROR ROOM");
                course305.updateLocation("BIT 104");

                System.out.println("\n\n===== ANSWER: CST305 (A. AAA, Course 305) at BIT 104 with 2 students (AVG: 75.00) =====\n");
                SCD.courseInfo(305);
                break;
            case 6:
                //        SCD.readData("C:\\tmp\\test6.txt");
                SCD.readData(".//src//testCases//test6.txt");

//                SCD.addInstructor(100,"A. AAA","aaa@csumb.edu","111-111-0000");
//                SCD.addInstructor(200,"B. BBB","bbb@csumb.edu","222-222-2222");
//                SCD.addInstructor(300,"C. CCC","ccc@csumb.edu","333-333-3333");
//                SCD.addInstructor(400,"D. DDD","ddd@csumb.edu","444-444-4444");
//                SCD.addInstructor(500,"E. EEE","eee@csumb.edu","555-555-5555");
//                SCD.addCourse(301,"CST301 - Course 301",50,"BIT 101");
//                SCD.addCourse(302,"CST302 - Course 302",40,"BIT 102");
//                SCD.addCourse(303,"CST303 - Course 303",30,"BIT 104");
//                SCD.addStudent(1111,"AA AAAA");
//                SCD.addStudent(2222,"BB BBBB");
//                SCD.addStudent(3333,"CC CCCC");

                SCD.assignInstructor (301, 300);
                SCD.assignInstructor (302, 300);
                SCD.assignInstructor (303, 300);
                SCD.register (301, 1111);
                SCD.register (301, 2222);
                SCD.register (301, 3333);
                SCD.register (302, 3333);
                SCD.register (302, 2222);
                SCD.register (302, 1111);
                SCD.register (303, 1111);
                SCD.register (303, 2222);
                SCD.register (303, 3333);
                SCD.unRegister  (303, 1111);
                SCD.unRegister  (303, 2222);
                SCD.unRegister  (303, 3333);

                System.out.println("\n\n===== ANSWER: 3 Courses with 301 (3 enrolled), 302 (3 enrolled) and 303 (0 enrolled) =====\n");
                SCD.courseInfo();
                break;
            case 7:
                //   SCD.readData("C:\\tmp\\test7.txt");
                SCD.readData(".//src//testCases//test7.txt");

//                SCD.addInstructor(300,"C. CCC","ccc@csumb.edu","333-333-3333");
//                SCD.addCourse(301,"CST301 - Course 301",50,"BIT 101");
//                SCD.addCourse(302,"CST302 - Course 302",40,"BIT 102");
//                SCD.addStudent(1111,"AA AAAA");
//                SCD.addStudent(2222,"BB BBBB");

                // Code
                SCD.register (301, 1111);
                SCD.register (301, 2222);

                System.out.println("\n\n===== ANSWER: 1 course deletion should be failed. =====\n");
                SCD.deleteCourse(301);
                SCD.deleteCourse(302);
                break;
            case 8:
                //  SCD.readData("C:\\tmp\\test8.txt");
                SCD.readData(".//src//testCases//test8.txt");

//                SCD.addInstructor(300,"C. CCC","ccc@csumb.edu","333-333-3333");
//                SCD.addCourse(301,"CST301 - Course 301",50,"BIT 101");
//                SCD.addCourse(302,"CST302 - Course 302",40,"BIT 102");
//                SCD.addCourse(304, "CST304 - Course 304", 10, "BIT104");
//                SCD.addCourse(305, "CST305 - Course 305", 20, "BIT105");
//                SCD.addStudent(1111,"AA AAAA");

                // Code
                SCD.addStudent(2222, "BB BBBB");
                SCD.addStudent(3333, "CC CCCC");
                SCD.addStudent(4444, "DD DDDD");
                SCD.addStudent(5555, "FF FFFF");

                SCD.assignInstructor (301, 300);
                SCD.register (301, 1111);
                SCD.register (301, 2222);
                SCD.register (301, 3333);
                SCD.register (301, 4444);
                SCD.register (301, 5555);

                SCD.putScore (301, 1111, 95.0);
                SCD.putScore (301, 2222, 85.0);
                SCD.putScore (301, 3333, 75.0);
                SCD.putScore (301, 4444, 65.0);
                SCD.putScore (301, 5555, 55.0);

                System.out.println("\n\n===== ANSWER: Course 301 with 5 students enrolled (AVG: 75.00) =====\n");
                SCD.courseInfo(301);
                break;
            case 9:
                //  SCD.readData("C:\\tmp\\test9.txt");
                SCD.readData(".//src//testCases//test9.txt");

//                SCD.addInstructor(300,"C. CCC","ccc@csumb.edu","333-333-3333");
//                SCD.addCourse(301,"CST301 - Course 301",300,"BIT 101");
//                SCD.addCourse(302,"CST302 - Course 302",300,"BIT 102");
//                SCD.addCourse(303,"CST303 - Course 303",300,"BIT 103");
//                SCD.addCourse(304,"CST304 - Course 304",300,"BIT 104");
//                SCD.addStudent(1111,"AA AAAA");
//                SCD.addStudent(2222,"BB BBBB");
//                SCD.addStudent(3333,"CC CCCC");

                // Code
                SCD.assignInstructor (301, 300);
                SCD.assignInstructor (302, 300);
                SCD.register (301, 1111);
                SCD.register (301, 2222);
                SCD.register (301, 3333);
                SCD.register (302, 2222);

                SCD.putScore (301, 1111, 95.0);
                SCD.putScore (301, 2222, 85.5);
                SCD.putScore (301, 3333, 75.0);
                SCD.putScore (302, 2222, 84.5);


                Student student1 = SCD.getStudent(2222);
                System.out.println("\n\n===== ANSWER: Student BB BBBB - 2 courses enrolled. (AVG: 85.0)  =====\n");
                System.out.println(student1);
                break;
            case 10:
                //  SCD.readData("C:\\tmp\\test10.txt");
                SCD.readData(".//src//testCases//test10.txt");

//                SCD.addInstructor(200,"B. BBB","bbb@csumb.edu","222-222-2222");
//                SCD.addInstructor(300,"C. CCC","ccc@csumb.edu","333-333-3333");
//                SCD.addInstructor(100,"A. AAA","aaa@csumb.edu","111-111-0000");
//                SCD.addInstructor(400,"D. DDD","ddd@csumb.edu","444-444-4444");
//                SCD.addInstructor(500,"E. EEE","eee@csumb.edu","555-555-5555");
//                SCD.addCourse(301,"CST301 - Course 301",300,"BIT 101");
//                SCD.addStudent(1111,"AA AAAA");

                // Code
                System.out.println("\n\n===== ANSWER: No employee with the email =====\n");
                SCD.searchByEmail("ccc@csu.edu");

                System.out.println("\n\n===== ANSWER: Employee Number: 300, Name: CCC =====\n");
                SCD.searchByEmail("ccc@csumb.edu");
                break;
            case 11:
                //    SCD.readData("C:\\tmp\\test11.txt");
                SCD.readData(".//src//testCases//test11.txt");

//                SCD.addInstructor(300,"C. CCC","ccc@csumb.edu","333-333-3333");
//                SCD.addCourse(301,"CST301 - Course 301",300,"BIT 101");
//                SCD.addCourse(302,"CST302 - Course 302",300,"BIT 102");
//
//                SCD.addStudent(1111,"AA AAAA");
//                SCD.addStudent(2222,"BB BBBB");
//                SCD.addStudent(3333,"CC CCCC");

                // Code
                SCD.assignInstructor (301, 300);
                SCD.assignInstructor (302, 300);
                SCD.register (301, 1111);
                SCD.register (301, 2222);
                SCD.register (302, 1111);
                SCD.register (302, 2222);

                SCD.putScore (301, 1111, 100.0);
                SCD.putScore (301, 2222, 100.0);
                SCD.putScore (302, 1111, 100.0);
                SCD.putScore (302, 2222, 100.0);

                SCD.graduateStudent(1111);

                System.out.println("\n\n===== ANSWER: There are 2 courses. Each course has only one student. =====\n");
                SCD.courseInfo();
                break;
            case 12:
                //SCD.readData("C:\\tmp\\test12.txt");
                SCD.readData(".//src//testCases//test12.txt");

//                SCD.addInstructor(300,"C. CCC","ccc@csumb.edu","333-333-3333");
//                SCD.addCourse(301,"CST301 - Course 301",300,"BIT 101");
//                SCD.addCourse(302,"CST302 - Course 302",300,"BIT 102");
//                SCD.addStudent(1111,"AA AAAA");
//                SCD.addStudent(2222,"BB BBBB");
//                SCD.addStudent(3333,"CC CCCC");

                // Code
                SCD.assignInstructor (301, 300);
                SCD.assignInstructor (302, 300);
                SCD.register (301, 1111);
                SCD.register (301, 2222);

                SCD.putScore (301, 1111, 100.0);
                SCD.putScore (301, 2222, 100.0);

                SCD.deleteCourse(301);
                SCD.deleteCourse(302);
                System.out.println("\n\n===== ANSWER: Only 1 course (301 with 2 enrolled). =====\n");
                SCD.courseInfo();
                break;
            case 13:
                System.out.println("===== Read Data 1 =====");
                // SCD.readData("C:\\tmp\\test1.txt");
                SCD.readData(".//src//testCases//demoTest1.txt");

//                SCD.addInstructor(100,"Y. Byun","ybyun@csumb.edu","111-111-1111");
//                SCD.addInstructor(200,"S. Narayan","sathya@csumb.edu","222-222-2222");
//                SCD.addInstructor(300,"M. Lara","lara@csumb.edu","333-333-3333");
//                SCD.addInstructor(250,"S. Bude","bude@csumb.edu","444-444-4444");
//                SCD.addCourse(338,"CST338 - Software Design",35,"BIT 104");
//                SCD.addCourse(205,"CST205 - Multimedia Design and Programming",3,"BIT 118");
//                SCD.addCourse(306,"CST306 - Game Engine Programming",55,"BIT 101");
//                SCD.addStudent(7777, "Alice Otter");
//                SCD.addStudent(8888, "Bob Otter");

                System.out.println("\n===== School Info 1 =====");
                SCD.schoolInfo();

                System.out.println("\n===== Read Data 2 =====");
                //  SCD.readData("C:\\tmp\\test2.txt");
                SCD.readData(".//src//testCases//demoTest2.txt");

//                SCD.addInstructor(500,"G. Bruns","bruns@csumb.edu","555-222-2222");
//                SCD.addInstructor(300,"O. Doe","doe@csumb.edu","444-333-3333");
//                SCD.addCourse(336,"CST336 - Internet Programming",3,"Library 1010");
//                SCD.addStudent(7777,"Unknown Otter");
//                SCD.addStudent(9999,"John Doe");

                System.out.println("\n===== School Info 2 =====");
                SCD.schoolInfo();

                System.out.println("\n===== Search by email =====");
                SCD.searchByEmail("ybyun@csumb.edu");

                System.out.println("\n===== Search by email (fail) =====");
                SCD.searchByEmail("byun@csumb.edu");

                System.out.println("\n===== End of SchoolDemo1 =====");
                break;
            case 14:
                Course course1;

                System.out.println("===== Read Data =====");
                //   SCD.readData("C:\\tmp\\test1.txt");
                SCD.readData(".//src//testCases//demoTest1.txt");

//                SCD.addInstructor(100,"Y. Byun","ybyun@csumb.edu","111-111-1111");
//                SCD.addInstructor(200,"S. Narayan","sathya@csumb.edu","222-222-2222");
//                SCD.addInstructor(300,"M. Lara","lara@csumb.edu","333-333-3333");
//                SCD.addInstructor(250,"S. Bude","bude@csumb.edu","444-444-4444");
//                SCD.addCourse(338,"CST338 - Software Design",35,"BIT 104");
//                SCD.addCourse(205,"CST205 - Multimedia Design and Programming",3,"BIT 118");
//                SCD.addCourse(306,"CST306 - Game Engine Programming",55,"BIT 101");
//                SCD.addStudent(7777, "Alice Otter");
//                SCD.addStudent(8888, "Bob Otter");

                SCD.addInstructor(700, "E. Tao", "tao@csumb.edu", "777-777-1234");
                SCD.addCourse(300, "CST300 – ProSem", 70, "BIT 110");
                SCD.addCourse(499, "CST499 – iOS Dev", 15, "BIT 104");

                SCD.assignInstructor (205, 200);
                SCD.assignInstructor (306, 100);
                SCD.register (306, 7777);
                SCD.register (306, 8888);
                SCD.putScore (306, 7777, 98.54);
                SCD.unRegister (306, 8888);

                System.out.println("\n===== Error Messages =====");
                SCD.addCourse(306, "CST306 – GUI Dev", 25, "BIT 120");
                SCD.putScore (306, 8888, 58.75);
                SCD.register (306, 9999);
                SCD.assignInstructor (499, 900);

                System.out.println("\n===== Detailed Course Info =====");
                SCD.courseInfo(306);

                course1 = SCD.getCourse(205);
                course1.updateLocation("Library 104");
                System.out.println("\n===== Detailed Course Info 2 =====");
                SCD.courseInfo(205);

                System.out.println("\n===== Detailed Course Info 3 =====");
                SCD.courseInfo();

                SCD.deleteCourse(306);
                SCD.deleteCourse(338);
                System.out.println("\n===== Detailed Course Info 4 =====");
                SCD.courseInfo();

                System.out.println("\n===== Good Job! Bye! =====");
                break;
            case 15:
                Instructor instructor2;
                Student student2 = null;

                System.out.println("===== Read Data =====");
                //  SCD.readData("C:\\tmp\\test1.txt");
                SCD.readData(".//src//testCases//demoTest1.txt");

//                SCD.addInstructor(100,"Y. Byun","ybyun@csumb.edu","111-111-1111");
//                SCD.addInstructor(200,"S. Narayan","sathya@csumb.edu","222-222-2222");
//                SCD.addInstructor(300,"M. Lara","lara@csumb.edu","333-333-3333");
//                SCD.addInstructor(250,"S. Bude","bude@csumb.edu","444-444-4444");
//                SCD.addCourse(338,"CST338 - Software Design",35,"BIT 104");
//                SCD.addCourse(205,"CST205 - Multimedia Design and Programming",3,"BIT 118");
//                SCD.addCourse(306,"CST306 - Game Engine Programming",55,"BIT 101");
//                SCD.addStudent(7777, "Alice Otter");
//                SCD.addStudent(8888, "Bob Otter");

                SCD.assignInstructor (306,200);
                SCD.assignInstructor (205,200);
                SCD.addStudent(5555, "Chris Watson");
                SCD.addStudent(9999, "Mike Watson");

                SCD.register (205, 5555);
                SCD.register (205, 7777);
                SCD.register (306, 7777);
                SCD.register (205, 8888);
                SCD.putScore (205, 5555, 50.0);
                SCD.putScore (205, 7777, 100.0);
                SCD.putScore (306, 7777, 100.0);
                SCD.putScore (205, 8888, 50.0);

                System.out.println("\n===== Error Messages =====");
                SCD.register (205, 9999);

                SCD.unRegister (205, 8888);
                System.out.println("\n===== Detailed Course Info 5 =====");
                SCD.courseInfo(205);

                instructor2 = SCD.getInstructor(205);
                System.out.println("\n===== Detailed Instructor Info =====");
                System.out.println(instructor2);

                student2 = SCD.getStudent(7777);
                System.out.println("\n===== Detailed Student Info =====");
                System.out.println(student2);

                SCD.graduateStudent(7777);
                System.out.println("\n===== Detailed Student Info 2 =====");

                if (SCD.getStudent(7777) == null)
                    System.out.println("No student information. ");

                System.out.println("\n===== Detailed Course Info 6 =====");
                SCD.courseInfo(205);

                System.out.println("\n===== Good Job! Bye! =====");
                break;
            default:
                System.out.println("OH SHIT");
                break;
        }
    }
}
