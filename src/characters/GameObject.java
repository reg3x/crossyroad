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
        System.out.println("got urlstring parameter: "+urlstring);
        url = this.getClass().getResource("/images/"+urlstring);
        System.out.println("using url:"+url);
        icon = new ImageIcon(url);
        label = new JLabel(icon);
        this.xInit = xInit;
        this.yInit = yInit;
        label.setBounds(xInit, yInit, icon.getIconWidth(), icon.getIconHeight());
        rect = label.getBounds();
    }

    public JLabel getLabel() {
        return label;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public int getxInit() {
        return xInit;
    }

    public int getyInit() {
        return yInit;
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

}
