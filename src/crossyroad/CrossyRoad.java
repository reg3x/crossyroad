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
    
    private JLabel playerNameLabel;
    private JLabel playerLifeLabel;
    private JLabel playerPointsLabel;
    private JLabel playerCoinsLabel;
    private JLabel TimeLabel;
    
    private double startTime;
    private double endTime;
    private int timeSec;

    public CrossyRoad(String playerName, int INITLEVEL) {
        this.INITLEVEL = INITLEVEL;
        player = new Player(playerName);
        mascot = new Mascot("goku_up.png", "goku_down.png","goku_left.png", "goku_right.png" ,360, 700);
    }
    
    public CrossyRoad(){
        INITLEVEL = 1;
    }
    
    public void start(){
        
        loadLevel(INITLEVEL);
                
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
                        playerLifeLabel.setText(Integer.toString(player.getLifes()));
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
                    loadLevel(map.getLevel()+1);   
                }
                
                Rectangle crashCoinRect;
                crashCoinRect = null;
                for(Coin coin: map.getCoins()){
                    crashCoinRect = mascot.getRectangle().intersection(coin.getRectangle());
                    if(crashCoinRect.getWidth()>0 && crashCoinRect.getHeight()>0){
                        System.out.println("Player Got a Coin! ");
                        player.IncreaseCoins();
                        playerCoinsLabel.setText(Integer.toString(player.getCoins()));
                        coin.getLabel().setLocation(-100,-100);
                        System.out.println("toal coins: "+player.getCoins());
                        break;
                    }
                } 
                
                
                endTime = System.currentTimeMillis();
                System.out.println("startTime:"+startTime);
                System.out.println("endTime:"+endTime);
                timeSec = (int)((endTime-startTime)/1000);
                TimeLabel.setText(Integer.toString(timeSec));
                
            }
        });
        winTimer.start();
    }
    
    
    public void loadLevel(int level){
        System.out.println("PLAYER IS: "+player.getName());
        player.setYcloserToGoal(9999); // initialize coordinates
        
        if(level!=1){
            destroyPreviousLevel();
        }
        
        if(level==3){
            System.exit(0);
        }
        
        myFrame = new JFrame("Crossy Road 0.1");   
        myFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        myFrame.setLayout(null);
        myFrame.setSize(728,782);
        myFrame.setLocationRelativeTo(null); // center frame on monitor
        myFrame.setResizable(false);
        
        playerNameLabel = new JLabel(player.getName());
        playerNameLabel.setBounds(90,16,100,20);
        myFrame.add(playerNameLabel);
        
        playerPointsLabel = new JLabel(Integer.toString(player.getPoints()));
        playerPointsLabel.setBounds(250,16,100,20);
        myFrame.add(playerPointsLabel);
        
        TimeLabel = new JLabel(Integer.toString(0));
        TimeLabel.setBounds(410,16,100,20);
        myFrame.add(TimeLabel);
        
        playerCoinsLabel = new JLabel(Integer.toString(player.getCoins()));
        playerCoinsLabel.setBounds(550,16,100,20);
        myFrame.add(playerCoinsLabel);
        
        playerLifeLabel = new JLabel(Integer.toString(player.getLifes()));
        playerLifeLabel.setBounds(670,16,100,20);
        myFrame.add(playerLifeLabel);
        
        myFrame.add(mascot.getLabel());
        mascot.getLabel().setLocation(360, 700);
        
        map = new Map(level, 0 , 0);
        
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
                        mascot.getLabel().setIcon(mascot.getUpIcon());
                        mascot.getLabel().setLocation(mascot.getLabel().getX(), mascot.getLabel().getY()-50);
                        if(mascot.getLabel().getY()<player.getYcloserToGoal()){
                            player.setYcloserToGoal(mascot.getLabel().getY());
                            player.increasePoints(1);
                            playerPointsLabel.setText(Integer.toString(player.getPoints()));
                            System.out.println("puntos acumulados:" +player.getPoints());
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        mascot.getLabel().setIcon(mascot.getDownIcon());
                        mascot.getLabel().setLocation(mascot.getLabel().getX(), mascot.getLabel().getY()+50);
                        break;
                    case KeyEvent.VK_LEFT:
                        mascot.getLabel().setIcon(mascot.getLeftIcon());
                        mascot.getLabel().setLocation(mascot.getLabel().getX()-50, mascot.getLabel().getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        mascot.getLabel().setIcon(mascot.getRightIcon());
                        mascot.getLabel().setLocation(mascot.getLabel().getX()+50, mascot.getLabel().getY());
                        break;
                }
                //System.out.println("Key: "+e.getKeyCode());
            }
        });
        
        createCrashListener();
        
        if(level==1){
            startTime = System.currentTimeMillis();
        }
        
        createWinLevelListener();
        
    }
    
    public void destroyPreviousLevel(){
        crashTimer.stop();
        winTimer.stop();
//        crashTimer=null;
//        winTimer=null;
//        map=null;
        myFrame.setVisible(false);
//        myFrame=null;
    }
    
    public static void main(String[] args) {
        System.out.println("INICIANDO CROSSY ROAD");
        Menu menu = new Menu();
        
        menu.show();
        
    }
    
}
