/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import java.util.ArrayList;

/**
 *
 * @author reg3x
 * Esta Clase describe al Jugador
 */
public class Player {
    
    private String name;
    private int points;
    private int coins;
    private int lifes;
    private Mascot selectedMascot;
    private ArrayList<Mascot> storedMascots;
    private int YcloserToGoal;

    public Player(String name, int points, int coins, int lifes, Mascot selectedMascot, ArrayList<Mascot> storedMascots) {
        this.name = name;
        this.points = points;
        this.coins = coins;
        this.lifes = lifes;
        this.selectedMascot = selectedMascot;
        this.storedMascots = storedMascots;
    }
    
    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.coins = 0;
        this.YcloserToGoal = 99999;
        this.lifes = 3;
    }
    
    public void decreaseLife(){
        lifes--;
    }

    public int getPoints() {
        return points;
    }

    public int getCoins() {
        return coins;
    }

    public int getLifes() {
        return lifes;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
    
    public void IncreaseCoins(){
        coins++;
    }

    public int getYcloserToGoal() {
        return YcloserToGoal;
    }

    public void setYcloserToGoal(int YcloserToGoal) {
        this.YcloserToGoal = YcloserToGoal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public void setSelectedMascot(Mascot selectedMascot) {
        this.selectedMascot = selectedMascot;
    }
}
