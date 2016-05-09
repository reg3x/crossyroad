/*
 * CrossyRoad 0.1 Licencia GPL
 * Autor: Diego Aguilera
 * Email: diegoaguilera85@gmail.com
 */
package characters;

/**
 * Esta clase es utilizada para describir las monedas que apareceran en el juego
 * @author reg3x
 * 
 */
public class Coin extends GameObject{
    
    /**
     *
     * @param urlstring nombre del archivo de la imagen
     * @param xInit coordenada x inicial
     * @param yInit coordenada y inicial
     */
    public Coin(String urlstring, int xInit, int yInit) {
        super(urlstring, xInit, yInit);
    }
    
}
