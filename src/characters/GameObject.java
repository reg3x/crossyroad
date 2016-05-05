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
    private JLabel label;
    private ImageIcon icon;
    private URL url;
    private Rectangle rect;
    private int xInit, yInit;
    
    public GameObject(String urlstring, int xInit, int yInit) {
        url = this.getClass().getResource(urlstring);
        System.out.println(url);
        icon = new ImageIcon(url);
        label = new JLabel(icon);
        this.xInit = xInit;
        this.yInit = yInit;
        label.setBounds(xInit, yInit, icon.getIconWidth(), icon.getIconHeight());
        rect = label.getBounds();
    }

    public JLabel getEtiqueta() {
        return label;
    }

    public ImageIcon getIcono() {
        return icon;
    }

    public URL getUrl() {
        return url;
    }

    public Rectangle getRect() {
        return rect;
    }
    
    public Rectangle getRectangle(){
        rect = label.getBounds();
        return rect;
    }

    public int getxInicial() {
        return xInit;
    }

    public int getyInicial() {
        return yInit;
    }
}
