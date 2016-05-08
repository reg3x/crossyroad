/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author reg3x
 */
public class Menu {
    private JFrame menuFrame;
    private JFrame creditsFrame;
    private JLabel logoLabel;
    private ImageIcon logoIcon;
    private URL logoUrl;
    
    private JLabel creditsLabel;
    private ImageIcon creditsIcon;
    private URL creditsUrl;

    public Menu() {
        menuFrame = new JFrame("CrossyRoad - Menu");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLayout(null);
        menuFrame.setSize(728,782);
        menuFrame.setLocationRelativeTo(null); // center frame on monitor
        menuFrame.setResizable(false);
        
        logoUrl = this.getClass().getResource("/images/biglogo.jpg");
        logoIcon = new ImageIcon(logoUrl);
        logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(100, 30, logoIcon.getIconWidth(), logoIcon.getIconHeight());
        
        JButton newGameBtn = new JButton("Nuevo Juego");
        newGameBtn.setSize(150, 50);
        newGameBtn.setLocation(280, 400);
        
        JButton loadGameBtn = new JButton("Cargar Juego");
        loadGameBtn.setSize(150, 50);
        loadGameBtn.setLocation(280, 460);
        
        JButton saveGameBtn = new JButton("Grabar Juego");
        saveGameBtn.setSize(150, 50);
        saveGameBtn.setLocation(280, 520);
        
        JButton creditsBtn = new JButton("Creditos");
        creditsBtn.setSize(150, 30);
        creditsBtn.setLocation(280, 620);
        
        menuFrame.add(logoLabel);
        menuFrame.add(newGameBtn);
        menuFrame.add(loadGameBtn);
        menuFrame.add(saveGameBtn);
        menuFrame.add(creditsBtn);
        
        
        creditsFrame = new JFrame("Creditos");
        creditsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        creditsFrame.setLayout(null);
        creditsFrame.setSize(300,200);
        creditsFrame.setLocationRelativeTo(null); // center frame on monitor
        creditsFrame.setResizable(false);
        
        creditsUrl = this.getClass().getResource("/images/credits.png");
        creditsIcon = new ImageIcon(creditsUrl);
        creditsLabel = new JLabel(creditsIcon);
        creditsLabel.setBounds(0, 0, creditsIcon.getIconWidth(), creditsIcon.getIconHeight());
        
        creditsFrame.add(creditsLabel);
        
        creditsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creditsFrame.setVisible(true);
            }
        });
        
        
        newGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               CrossyRoad myGame = new CrossyRoad();
               myGame.start();
            }
        });
        
    }
    
    public void show(){
        menuFrame.setVisible(true);
    }
    
    public void hide(){
        menuFrame.setVisible(false);
    }
    
}
