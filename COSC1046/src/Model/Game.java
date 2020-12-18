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
public class Game {

    private String gameIndex;
    private String gameName;
    private String gameAnswer;

    /*Default constructor*/
    public Game() {
    }

    /*Parameterized Constructor*/
    public Game(String gameIndex, String gameName, String gameAnswer) {
        this.gameName = gameName;
        this.gameIndex = gameIndex;
        this.gameAnswer = gameAnswer;
    }

    /**
     * @return the gameName
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * @param gameName the gameName to set
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * @return the gameIndex
     */
    public String getGameIndex() {
        return gameIndex;
    }

    /**
     * @param gameIndex the gameIndex to set
     */
    public void setGameIndex(String gameIndex) {
        this.gameIndex = gameIndex;
    }

    /**
     * @return the gameAnswer
     */
    public String getGameAnswer() {
        return gameAnswer;
    }

    /**
     * @param gameAnswer the gameAnswer to set
     */
    public void setGameAnswer(String gameAnswer) {
        this.gameAnswer = gameAnswer;
    }
}
