/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author reg3x
 */
public class GameObject {
    private JLabel etiqueta;
    private ImageIcon icono;
    private URL url;
    private Rectangle rect;
    private int xInicial, yInicial;
    
    public GameObject(String urlstring, int xInicial, int yInicial) {
        url = this.getClass().getResource(urlstring);
        System.out.println(url);
        icono = new ImageIcon(url);
        etiqueta = new JLabel(icono);
        this.xInicial = xInicial;
        this.yInicial = yInicial;
        etiqueta.setBounds(xInicial, yInicial, icono.getIconWidth(), icono.getIconHeight());
        rect = etiqueta.getBounds();
    }

    public JLabel getEtiqueta() {
        return etiqueta;
    }

    public ImageIcon getIcono() {
        return icono;
    }

    public URL getUrl() {
        return url;
    }

    public Rectangle getRect() {
        return rect;
    }
    
    public Rectangle getRectangle(){
        rect = etiqueta.getBounds();
        return rect;
    }

    public int getxInicial() {
        return xInicial;
    }

    public int getyInicial() {
        return yInicial;
    }
}
