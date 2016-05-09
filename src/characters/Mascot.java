/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import javax.swing.ImageIcon;

/**
 *
 * @author diegoaguilerazambrano
 */
public class Mascot extends GameObject {
    private ImageIcon leftIcon,rightIcon,upIcon, downIcon;
    
    public Mascot(String upIconUrl, String downIconUrl,String leftIconUrl,String rightIconUrl, int xInit, int yInit) {
        super(upIconUrl, xInit, yInit);
        upIcon = new ImageIcon(this.getClass().getResource("/images/"+upIconUrl));
        downIcon = new ImageIcon(this.getClass().getResource("/images/"+downIconUrl));
        leftIcon = new ImageIcon(this.getClass().getResource("/images/"+leftIconUrl));
        rightIcon = new ImageIcon(this.getClass().getResource("/images/"+rightIconUrl));
    }

    public ImageIcon getLeftIcon() {
        return leftIcon;
    }

    public ImageIcon getRightIcon() {
        return rightIcon;
    }

    public ImageIcon getUpIcon() {
        return upIcon;
    }

    public ImageIcon getDownIcon() {
        return downIcon;
    }
    
    
    
}
