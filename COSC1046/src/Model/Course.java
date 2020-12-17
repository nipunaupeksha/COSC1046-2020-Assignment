/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Nipuna
 */
public class Course {
    private String courseId;
    private String courseName;
    private double courseCredit;
    private String[] games;
    
    /*Default Constructor*/
    public Course(){}
    
    /*Parameterized Constructor*/
    public Course(String courseName, double courseCredit, String []games, String courseId){
        this.courseName = courseName;
        this.courseCredit = courseCredit;
        this.games = games;
        this.courseId = courseId;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the courseCredit
     */
    public double getCourseCredit() {
        return courseCredit;
    }

    /**
     * @param courseCredit the courseCredit to set
     */
    public void setCourseCredit(double courseCredit) {
        this.courseCredit = courseCredit;
    }

    /**
     * @return the games
     */
    public String[] getGames() {
        return games;
    }

    /**
     * @param games the games to set
     */
    public void setGames(String[] games) {
        this.games = games;
    }

    /**
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
}
