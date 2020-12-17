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
    private String gameName;
    private String gameIndex;
    
    /*Default constructor*/
    public Game(){}
    
    /*Parameterized Constructor*/
    public Game(String gameIndex,String gameName){
        this.gameName = gameName;
        this.gameIndex = gameIndex;
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
}
