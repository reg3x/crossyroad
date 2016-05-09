/*
 * CrossyRoad 0.1 Licencia GPL
 * Autor: Diego Aguilera
 * Email: diegoaguilera85@gmail.com
 */
package characters;

import javax.swing.ImageIcon;

/**
 * Esta clase describe la mascota que sera utilizada por el jugador.
 * @author reg3x
 */
public class Mascot extends GameObject {
    private ImageIcon leftIcon,rightIcon,upIcon, downIcon;
    
    /**
     *
     * @param upIconUrl direccion del icono superior
     * @param downIconUrl direccion del icono inferior
     * @param leftIconUrl direccion del icono izquierdo
     * @param rightIconUrl direccion del icono derecho 
     * @param xInit coordenada x inicial
     * @param yInit coordenada y inicial
     */
    public Mascot(String upIconUrl, String downIconUrl,String leftIconUrl,String rightIconUrl, int xInit, int yInit) {
        super(upIconUrl, xInit, yInit);
        upIcon = new ImageIcon(this.getClass().getResource("/images/"+upIconUrl));
        downIcon = new ImageIcon(this.getClass().getResource("/images/"+downIconUrl));
        leftIcon = new ImageIcon(this.getClass().getResource("/images/"+leftIconUrl));
        rightIcon = new ImageIcon(this.getClass().getResource("/images/"+rightIconUrl));
    }

    /**
     *
     * @return icono izquierdo de la mascota
     */
    public ImageIcon getLeftIcon() {
        return leftIcon;
    }

    /**
     *
     * @return icono derecho de la mascota
     */
    public ImageIcon getRightIcon() {
        return rightIcon;
    }

    /**
     *
     * @return icono superior de la mascota
     */
    public ImageIcon getUpIcon() {
        return upIcon;
    }

    /**
     *
     * @return icono inferior de la mascota
     */
    public ImageIcon getDownIcon() {
        return downIcon;
    }
    
    
    
}
