/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

/**
 *
 * @author reg3x
 */
public class Player extends GameObject{
    
    private int points;
    private int lifes;
    
    public Player(String urlstring, int xInicial, int yInicial) {
        super(urlstring, xInicial, yInicial);
    }
    
}
