/*
 * CrossyRoad 0.1 Licencia GPL
 * Autor: Diego Aguilera
 * Email: diegoaguilera85@gmail.com
 */
package characters;

import java.util.ArrayList;

/**
 * Esta clase describe al jugador y guarda la informacion del mismo durante toda
 * la partida como: las monedas, los puntos, las vidas, las mascotas, etc.
 * @author reg3x
 */
public class Player {
    
    private String name;
    private int points;
    private int coins;
    private int lifes;
    private Mascot selectedMascot;
    private ArrayList<Mascot> storedMascots;
    private int YcloserToGoal;

    /**
     *
     * @param name nombre del jugador
     * @param points puntos del jugador
     * @param coins monedas del jugador
     * @param lifes vidas del jugador
     * @param selectedMascot mascota seleccionada
     * @param storedMascots mascotas almacenadas
     */
    public Player(String name, int points, int coins, int lifes, Mascot selectedMascot, ArrayList<Mascot> storedMascots) {
        this.name = name;
        this.points = points;
        this.coins = coins;
        this.lifes = lifes;
        this.selectedMascot = selectedMascot;
        this.storedMascots = storedMascots;
    }
    
    /**
     *
     * @param name nombre del jugador
     */
    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.coins = 0;
        this.YcloserToGoal = 99999;
        this.lifes = 5;
    }
    
    /**
     * Decrementa las vidas del jugador
     */
    public void decreaseLife(){
        lifes--;
    }

    /**
     *
     * @return los puntos del jugador
     */
    public int getPoints() {
        return points;
    }

    /**
     *
     * @return las monedas del jugador
     */
    public int getCoins() {
        return coins;
    }

    /**
     *
     * @return las vidas del jugador
     */
    public int getLifes() {
        return lifes;
    }

    /**
     *
     * @param points puntos del jugador
     */
    public void setPoints(int points) {
        this.points = points;
    }
    
    /**
     *
     * @param points puntos del jugador
     */
    public void increasePoints(int points){
        this.points += points;
    }

    /**
     *
     * @param coins monedas del jugador
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }
    
    /**
     * Incrementa las monedas
     */
    public void IncreaseCoins(){
        coins++;
    }

    /**
     *
     * @return posicion y del jugador al momento de avanzar mas a la meta
     */
    public int getYcloserToGoal() {
        return YcloserToGoal;
    }

    /**
     *
     * @param YcloserToGoal posicion y del jugador al momento de avanzar mas a la meta
     */
    public void setYcloserToGoal(int YcloserToGoal) {
        this.YcloserToGoal = YcloserToGoal;
    }

    /**
     *
     * @param name nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param lifes vidas
     */
    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    /**
     *
     * @param selectedMascot mascota seleccionada
     */
    public void setSelectedMascot(Mascot selectedMascot) {
        this.selectedMascot = selectedMascot;
    }

    /**
     *
     * @return nombre del jugador
     */
    public String getName() {
        return name;
    }
}
