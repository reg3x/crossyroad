/*
 * CrossyRoad 0.1 Licencia GPL
 * Autor: Diego Aguilera
 * Repositorio: https://github.com/reg3x/crossyroad
 * Email: diegoaguilera85@gmail.com
 */
package crossyroad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Esta clase describe el menu principal del juego.
 * @author reg3x
 */
public class Menu {
    private JFrame menuFrame;
    private JLabel logoLabel;
    private ImageIcon logoIcon;
    private URL logoUrl;
    
    private JFrame creditsFrame;
    private JLabel creditsLabel;
    private ImageIcon creditsIcon;
    private URL creditsUrl;
    
    private JFrame playerFrame;
    private JLabel nameLabel;
    private JTextField nameField;

    /**
     * Constructor por defecto de la clase Menu.
     */
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
        
        JButton exitGameBtn = new JButton("Salir");
        exitGameBtn.setSize(150, 50);
        exitGameBtn.setLocation(280, 480);
        
        JButton creditsBtn = new JButton("Creditos");
        creditsBtn.setSize(150, 30);
        creditsBtn.setLocation(280, 570);
        
        menuFrame.add(logoLabel);
        menuFrame.add(newGameBtn);
//        menuFrame.add(loadGameBtn);
//        menuFrame.add(saveGameBtn);
        menuFrame.add(creditsBtn);
        menuFrame.add(exitGameBtn);
        
        playerFrame = new JFrame("Jugador");
        playerFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        playerFrame.setLayout(null);
        playerFrame.setSize(300,200);
        playerFrame.setLocationRelativeTo(null); // center frame on monitor
        playerFrame.setResizable(false);
        
        nameLabel = new JLabel("Inserte su Nombre:");
        nameLabel.setBounds(80,30,140,10);
        nameField = new JTextField();
        nameField.setBounds(80,50,140,30);
        
        JButton acceptNameBtn = new JButton("Aceptar");
        acceptNameBtn.setSize(120, 30);
        acceptNameBtn.setLocation(20, 100);
        
        JButton cancelNameBtn = new JButton("Cancelar");
        cancelNameBtn.setSize(120, 30);
        cancelNameBtn.setLocation(160, 100);
        
        playerFrame.add(nameLabel);
        playerFrame.add(nameField);
        playerFrame.add(acceptNameBtn);
        playerFrame.add(cancelNameBtn);
        
        cancelNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerFrame.setVisible(false);
            }
        });
        
        acceptNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               CrossyRoad myGame = new CrossyRoad(nameField.getText(), 1);
               myGame.start();
               playerFrame.setVisible(false);
            }
        });
        
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
               playerFrame.setVisible(true);
            }
        });
        
        exitGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
    }
    
    /**
     * Muestra el Menu.
     */
    public void show(){
        menuFrame.setVisible(true);
    }
    
    /**
     * Esconde el Menu.
     */
    public void hide(){
        menuFrame.setVisible(false);
    }
    
}
