/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Course;
import Model.Game;
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

    Program() {
    }

    public void courseAdding(Course course) {
        coursesArray.add(course);
    }

    public void gameAdding(Game game) {
        gameArray.add(game);
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
        String gameVal = "";
        while (!gameVal.equalsIgnoreCase("n")) {
            System.out.print("Do you want to add a Game? (y/n)");
            gameVal = input.nextLine();

            if (gameVal.equalsIgnoreCase("y")) {
                System.out.print("Game Id: ");
                String gameId = input.nextLine();
                System.out.print("Game Name: ");
                String gameName = input.nextLine();
                System.out.println("Game answer: ");
                
                Game game = new Game(gameId, gameName);
                program.gameAdding(game);
            }else{
                break;
            }
        }
        
        /*Initialization of courses*/
        System.out.println("Input courses (to exit press 'n')");
        String courseVal = "";
        while (!courseVal.equalsIgnoreCase("n")) {
            System.out.print("Do you want to add a course? (y/n)");
            courseVal = input.nextLine();

            if (courseVal.equalsIgnoreCase("y")) {
                System.out.print("Course Id: ");
                String courseId = input.nextLine();
                System.out.print("Course Name: ");
                String courseName = input.nextLine();
                System.out.print("Course Credits: ");
                String courseCredits = input.nextLine();
            }else{
                break;
            }
        }
        
        
        System.out.println("Input student details (to exit press 'n')");
        String userVal = "";
        while(!userVal.equalsIgnoreCase("n")){
            System.out.print("Do you want to add a user? (y/n)");
            userVal = input.nextLine();
            
            if(userVal.equalsIgnoreCase("y")){
                System.out.print("Student Name: ");
                String studentName = input.nextLine();
                System.out.print("Student Username: ");
                String username = input.nextLine();
                System.out.print("Student password: ");
                String password = input.nextLine();
                System.out.print("Select the courses you enrolled: ");
                HashMap<String,String> courseMap = new HashMap<String, String>();
            }
        }
        
    }
}
