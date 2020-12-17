/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;

/**
 *
 * @author Nipuna
 */
public class User {
    private String studentName;
    private String userName;
    private String password;
    private HashMap<String, String> courses;
    private HashMap<String,Integer> gameCount;
    
    /*Default constructor*/
    public User(){}
    
    /*Parameterized Constructor*/
    public User(String studentName,String username, String password, HashMap<String, String> courses, HashMap<String,Integer>gameCount){
        this.studentName = studentName;
        this.userName = username;
        this.password = password;
        this.courses = courses;
        this.gameCount = gameCount;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the courses
     */
    public HashMap<String, String> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(HashMap<String, String> courses) {
        this.courses = courses;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the gameCount
     */
    public HashMap<String,Integer> getGameCount() {
        return gameCount;
    }

    /**
     * @param gameCount the gameCount to set
     */
    public void setGameCount(HashMap<String,Integer> gameCount) {
        this.gameCount = gameCount;
    }
    
}
