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
public class Map extends GameObject{
    private int level;
   
    public Map(String urlstring, int xInit, int yInit, int level) {
        super(urlstring, xInit, yInit);
        this.level = level;
    }
   
}
