/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Course;
import Model.Game;
import Model.User;
import dnl.utils.text.table.TextTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Nipuna
 */
public class Program {

    private ArrayList<Course> coursesArray = new ArrayList<>();
    private ArrayList<Game> gameArray = new ArrayList<>();
    private ArrayList<User> userArray = new ArrayList<>();

    Program() {
    }

    public void courseAdding(Course course) {
        coursesArray.add(course);
    }

    public void gameAdding(Game game) {
        gameArray.add(game);
    }

    public void userAdding(User user) {
        userArray.add(user);
    }

    public static void main(String[] args) {
        /*Create an instance of the main program*/
        Program program = new Program();

        /*Create an instance of the Scanner*/
        Scanner input = new Scanner(System.in);

        /*
        * First you have to organize the games
        * Then, you can assign certain games to certain courses
        * After that, you should have student who can follow different courses
        * Finally you can let student's play games
         */
 /*Lets initialize the games*/
        System.out.println("Input games (to exit press 'n')");
        System.out.println("------------------------------------");
        String gameVal = "";
        while (!gameVal.equalsIgnoreCase("n")) {
            System.out.print("Do you want to add a Game? (y/n)");
            gameVal = input.nextLine();

            if (gameVal.equalsIgnoreCase("y")) {
                System.out.print("Game Id: ");
                String gameId = input.nextLine();
                System.out.print("Game Name: ");
                String gameName = input.nextLine();
                System.out.print("Game answer: ");
                String gameAnswer = input.nextLine();
                Game game = new Game(gameId, gameName, gameAnswer);
                program.gameAdding(game);
            } else {
                break;
            }
        }

        /*Initialization of courses*/
        System.out.println("");
        System.out.println("Input courses (to exit press 'n')");
        System.out.println("------------------------------------");
        String courseVal = "";
        while (!courseVal.equalsIgnoreCase("n")) {
            System.out.print("Do you want to add a course? (y/n)");
            courseVal = input.nextLine();

            boolean gamesAvailable = program.gameArray.size() != 0;
            if (gamesAvailable) {
                String gameColumns[] = {"Game Id", "Game Name"};
                Object gameData[][] = new String[program.gameArray.size()][2];
                for (int i = 0; i < program.gameArray.size(); i++) {
                    Game game = program.gameArray.get(i);
                    String gameDetail[] = {game.getGameIndex(), game.getGameName()};
                    gameData[i][0] = gameDetail[0];
                    gameData[i][1] = gameDetail[1];
                }

                TextTable gameTable = new TextTable(gameColumns, gameData);

                if (courseVal.equalsIgnoreCase("y")) {
                    System.out.print("Course Id: ");
                    String courseId = input.nextLine();
                    System.out.print("Course Name: ");
                    String courseName = input.nextLine();
                    System.out.print("Course Credits: ");
                    String courseCredits = input.nextLine();
                    double courseCredits_double = Double.parseDouble(courseCredits);
                    System.out.println("Select course games from the following table. (type games to be included in g1_id,g2_id,... format)");
                    gameTable.printTable();
                    String courseGameDetails = input.nextLine();
                    String courseGames[] = courseGameDetails.split(",");

                    Course course = new Course(courseId, courseName, courseCredits_double, courseGames);
                    program.courseAdding(course);
                } else {
                    break;
                }
            } else {
                System.out.println("There are no games available");
            }
        }

        /*Initialization of student details*/
        System.out.println("");
        System.out.println("Input student details (to exit press 'n')");
        System.out.println("------------------------------------");
        String userVal = "";
        while (!userVal.equalsIgnoreCase("n")) {

            String courseColumns[] = {"Course Id", "Course Name"};
            Object courseData[][] = new String[program.coursesArray.size()][2];
            for (int i = 0; i < program.coursesArray.size(); i++) {
                Course course = program.coursesArray.get(i);
                String courseDetail[] = {course.getCourseId(), course.getCourseName()};
                courseData[i][0] = courseDetail[0];
                courseData[i][1] = courseDetail[1];
            }

            TextTable courseTable = new TextTable(courseColumns, courseData);

            System.out.print("Do you want to add a Student? (y/n)");
            userVal = input.nextLine();

            if (userVal.equalsIgnoreCase("y")) {
                System.out.print("Student Name: ");
                String studentName = input.nextLine();
                System.out.print("Student Username: ");
                String username = input.nextLine();
                System.out.print("Student password: ");
                String password = input.nextLine();
                System.out.print("Select the courses you enrolled from the following table. (type courses and grades as c1_id:grade,c2_id:grade,...)");
                courseTable.printTable();
                String courseDetails = input.nextLine();
                HashMap<String, String> courseMap = new HashMap<String, String>();
                String coursesArray[] = courseDetails.split(",");
                for (String s : coursesArray) {
                    String values[] = s.split(":");
                    courseMap.put(values[0], values[1]);
                }
                HashMap<String, Integer> gameCount = new HashMap<>();
                User user = new User(studentName, username, password, courseMap, gameCount);
                program.userAdding(user);
            } else {
                break;
            }
        }

        /*Let students play games*/
        System.out.println("");
        System.out.println("Let the gaming begins");
        System.out.println("--------------------------");
        String gamingVal = "";
        while (!gamingVal.equalsIgnoreCase("n")) {
            System.out.print("Do you want to start a game? (y/n) ");
            gamingVal = input.nextLine();
            if (gamingVal.equalsIgnoreCase("y")) {
                System.out.print("Input username: ");
                String username = input.nextLine();

                String columnNames[] = {"Course ID", "Course Name", "Course Grade", "Course Games", "Game Ids"};
                ArrayList<String> studentCourses = new ArrayList<>();
                ArrayList<String> studentCredits = new ArrayList<>();

                /*
                ArrayList<String> gameKeys = new ArrayList<>();
                ArrayList<Integer> gameCount = new ArrayList<>();
                 */
                for (int i = 0; i < program.userArray.size(); i++) {
                    if (program.userArray.get(i).getUserName().equals(username)) {
                        User user = program.userArray.get(i);
                        HashMap<String, String> courseMap = user.getCourses();

                        //HashMap<String,Integer> gameC = user.getGameCount();
                        for (String s : courseMap.keySet()) {
                            studentCourses.add(s);
                            studentCredits.add(courseMap.get(s));
                        }
                        /*
                        for (String s : gameC.keySet()) {
                            gameKeys.add(s);
                            gameCount.add(gameC.get(s));
                        }*/
                    }
                }

                Object data[][] = new Object[studentCourses.size()][5];

                for (int i = 0; i < studentCourses.size(); i++) {
                    data[i][1] = studentCourses.get(i);
                    data[i][2] = studentCredits.get(i);
                    for (int j = 0; j < program.coursesArray.size(); j++) {
                        Course course = program.coursesArray.get(i);
                        if (course.getCourseId().equals(studentCourses.get(i))) {
                            data[i][0] = course.getCourseName();
                            String gameIdArray[] = course.getGames();
                            String gIDs = "";
                            ArrayList<String> gameNames = new ArrayList<>();
                            for (int k = 0; k < gameIdArray.length; k++) {
                                gIDs += gameIdArray[k] + ", ";
                                for (int m = 0; m < program.gameArray.size(); m++) {
                                    Game game = program.gameArray.get(m);
                                    if (game.getGameIndex().equals(gameIdArray[k])) {
                                        gameNames.add(game.getGameName());
                                    }
                                }
                            }
                            String gNames = "";
                            for (int k = 0; k < gameNames.size(); k++) {
                                gNames += gameNames.get(k) + ", ";
                            }

                            data[i][3] = gNames;
                            data[i][4] = gIDs;

                        }
                    }
                }

                TextTable detailsTable = new TextTable(columnNames, data);
                detailsTable.printTable();

                System.out.print("Input course: ");
                String course = input.nextLine();

                System.out.print("Input game you are going to play(Input game Id)");
                String game = input.nextLine();

                System.out.print("Input game answer: ");
                String gameAnswer = input.nextLine();

                for (int i = 0; i < program.gameArray.size(); i++) {
                    Game g = program.gameArray.get(i);
                    if (g.getGameIndex().equalsIgnoreCase(game)) {
                        boolean compareAnswer = g.getGameAnswer().equalsIgnoreCase(gameAnswer);
                        for (int j = 0; j < program.userArray.size(); j++) {
                            if (program.userArray.get(j).getUserName().equals(username)) {
                                User u = program.userArray.get(j);
                                for (int k = 0; k < program.coursesArray.size(); k++) {
                                    if(program.coursesArray.get(k).getCourseId().equalsIgnoreCase(course)){
                                        Course c = program.coursesArray.get(k);
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }

    }
}
