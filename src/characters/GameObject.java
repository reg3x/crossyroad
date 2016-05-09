/*
 * CrossyRoad 0.1 Licencia GPL
 * Autor: Diego Aguilera
 * Email: diegoaguilera85@gmail.com
 */
package characters;

import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Esta clase es utilizada para describir todos aquellos objetos del juego que
 * deben ser pintados en la pantalla, contiene los atributos necesarios para 
 * asegurar que cada instancia pueda ser dibujada y ademas posea las caracteristicas
 * necesarias para determinar si hay colision entre instancias.
 * @author reg3x
 */
public class GameObject {
    private JLabel label;
    private ImageIcon icon;
    private URL url;
    private Rectangle rect;
    private int xInit, yInit;
    
    /**
     *
     * @param urlstring nombre del archivo de la imagen
     * @param xInit coordenada x inicial
     * @param yInit coordenada y inicial
     */
    public GameObject(String urlstring, int xInit, int yInit) {
        url = this.getClass().getResource("/images/"+urlstring);
        icon = new ImageIcon(url);
        label = new JLabel(icon);
        this.xInit = xInit;
        this.yInit = yInit;
        label.setBounds(xInit, yInit, icon.getIconWidth(), icon.getIconHeight());
        rect = label.getBounds();
    }

    /**
     *
     * @return etiqueta
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     *
     * @return el icono
     */
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     *
     * @return coordenada en x inicial
     */
    public int getxInit() {
        return xInit;
    }

    /**
     *
     * @return coordenada en y inicial
     */
    public int getyInit() {
        return yInit;
    }

    /**
     *
     * @return url con la direccion
     */
    public URL getUrl() {
        return url;
    }

    /**
     *
     * @return
     */
    public Rectangle getRect() {
        return rect;
    }
    
    /**
     *
     * @return construye y retorna el rectangulo
     */
    public Rectangle getRectangle(){
        rect = label.getBounds();
        return rect;
    }

}
