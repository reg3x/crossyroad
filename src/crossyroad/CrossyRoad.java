/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import characters.Coin;
import characters.Map;
import characters.Mascot;
import characters.Player;
import characters.Vehicle;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author reg3x
 */
public class CrossyRoad {

    private JFrame myFrame;
    private Player player;
    private Mascot mascot;
    private Map map;
    private Timer crashTimer;
    private Timer winTimer;
    private final int INITLEVEL;

    public CrossyRoad(Player player, int INITLEVEL) {
        this.player = player;
        this.INITLEVEL = INITLEVEL;
    }
    
    public CrossyRoad(){
        INITLEVEL = 1;
    }
    
    public void start(String playerName){
        
        loadLevel(INITLEVEL, playerName);
                
    }
    
    public void createCrashListener(){
        crashTimer = new Timer(2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle crashRect;
                crashRect = null;
                for(Vehicle vehicle: map.getVehicles()){
                    crashRect = mascot.getRectangle().intersection(vehicle.getRectangle());
                    if(crashRect.getWidth()>0 && crashRect.getHeight()>0){
                        System.out.println("there has been a Crash! ");
                        mascot.getLabel().setLocation(360,700);
                        player.decreaseLife();
                        if(player.getLifes()==0){
                            JOptionPane.showMessageDialog(null, "GAME OVER!!");
                            myFrame.setVisible(false);
                        }
                        break;
                    }
                } 
            }
        });
        crashTimer.start();
    }
    
    public void createWinLevelListener(){
        winTimer = new Timer(2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(mascot.getLabel().getY()<=0){
                    mascot.getLabel().setLocation(900, 900);
                    JOptionPane.showMessageDialog(null, "NIVEL "+map.getLevel()+" SUPERADO!!");
                    
                }
                
                Rectangle crashCoinRect;
                crashCoinRect = null;
                for(Coin coin: map.getCoins()){
                    crashCoinRect = mascot.getRectangle().intersection(coin.getRectangle());
                    if(crashCoinRect.getWidth()>0 && crashCoinRect.getHeight()>0){
                        System.out.println("Player Got a Coin! ");
                        player.IncreaseCoins();
                        coin.getLabel().setLocation(-100,-100);
                        System.out.println("toal coins: "+player.getCoins());
                        break;
                    }
                } 
                
            }
        });
        winTimer.start();
    }
    
    
    public void loadLevel(int level, String playerName){
        
        if(level==1){
            player = new Player(playerName);
            mascot = new Mascot("pollo.png", 360, 700);
        }
        
        JFrame myFrame = new JFrame("Crossy Road 0.1");   
        myFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        myFrame.setLayout(null);
        myFrame.setSize(728,782);
        myFrame.setLocationRelativeTo(null); // center frame on monitor
        myFrame.setResizable(false);
        myFrame.add(mascot.getLabel());
        
        
        map = new Map(1, "mapa.png", 0 , 0);
        
        for(Vehicle vehicle: map.getVehicles()){
            myFrame.add(vehicle.getLabel());
        }
        
        for(Coin coin: map.getCoins()){
            myFrame.add(coin.getLabel());
        }
        
        myFrame.add(map.getLabel());
        myFrame.setVisible(true);
        myFrame.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        mascot.getLabel().setLocation(mascot.getLabel().getX(), mascot.getLabel().getY()-30);
                        if(mascot.getLabel().getY()<player.getYcloserToGoal()){
                            player.setYcloserToGoal(mascot.getLabel().getY());
                            // le quitamos a posicion inicial de la mascota entre los px por paso
                            player.setPoints(700/30 - mascot.getLabel().getY()/30);
                            System.out.println("puntos acumulados:" +player.getPoints());
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        mascot.getLabel().setLocation(mascot.getLabel().getX(), mascot.getLabel().getY()+30);
                        break;
                    case KeyEvent.VK_LEFT:
                        mascot.getLabel().setLocation(mascot.getLabel().getX()-30, mascot.getLabel().getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        mascot.getLabel().setLocation(mascot.getLabel().getX()+30, mascot.getLabel().getY());
                        break;
                }
                //System.out.println("Key: "+e.getKeyCode());
            }
        });
        
        createCrashListener();
        createWinLevelListener();
        
    }
    
    public static void main(String[] args) {
        System.out.println("INICIANDO CROSSY ROAD");
        Menu menu = new Menu();
        
        menu.show();
        
    }
    
}
