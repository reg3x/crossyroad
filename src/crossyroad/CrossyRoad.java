/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import characters.Map;
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
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author reg3x
 */
public class CrossyRoad {

    private JFrame myFrame;
    private Player player;
    private Map map;
    private ArrayList<Vehicle> vehicles;
    
    private Image imagen;
    private JLabel mapa,pollo,carro,camion,ambulancia,limo;        
    Timer timerCarro,timerAmbulancia,timerCamion,timerLimo;
    
    
    public void iniciar(){
        JFrame myFrame = new JFrame("Crossy Road 0.1");   
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(null);
        myFrame.setSize(728,782);
        myFrame.setLocationRelativeTo(null); // center frame on monitor
        myFrame.setResizable(false);

//        ImageLoader loader = ImageLoader.getInstance();
//        ImageIcon icon;
        player = new Player("pollo.png", 360, 700);
        myFrame.add(player.getLabel());

//        icon = loader.getImage(ImageLoader.POLLO);
//        pollo = new JLabel(icon);
//        pollo.setBounds(360, 700, icon.getIconWidth(), icon.getIconHeight());
//        myFrame.add(pollo);
    
        vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Vehicle("carro.png",0, 590));
        vehicles.add(new Vehicle("camion.png",650, 555));
        vehicles.add(new Vehicle("ambulancia.png",0, 500));
        vehicles.add(new Vehicle("limo.png",650, 340));
        map = new Map("mapa.png",0, 0);
        
        for(Vehicle vehicle: vehicles){
            myFrame.add(vehicle.getLabel());
        }
        myFrame.add(map.getLabel());
//        icon = loader.getImage(ImageLoader.CARRO);
//        carro = new JLabel(icon);
//        carro.setBounds(0, 590, icon.getIconWidth(), icon.getIconHeight());
//        myFrame.add(carro);
        
//        icon = loader.getImage(ImageLoader.CAMION);
//        camion = new JLabel(icon);
//        camion.setBounds(650, 555, icon.getIconWidth(), icon.getIconHeight());
//        myFrame.add(camion);
//        
//        icon = loader.getImage(ImageLoader.AMBULANCIA);
//        ambulancia = new JLabel(icon);
//        ambulancia.setBounds(0, 500, icon.getIconWidth(), icon.getIconHeight());
//        myFrame.add(ambulancia);
//        
//        icon = loader.getImage(ImageLoader.LIMO);
//        limo = new JLabel(icon);
//        limo.setBounds(650, 340, icon.getIconWidth(), icon.getIconHeight());
//        myFrame.add(limo);
                
//        icon = loader.getImage(ImageLoader.MAPA);
//        mapa = new JLabel(icon);
//        mapa.setBounds(0,0, icon.getIconWidth(), icon.getIconHeight());
//        myFrame.add(mapa);
        
        myFrame.setVisible(true);
        
//        myFrame.addKeyListener(new KeyAdapter(){
//            @Override
//            public void keyPressed(KeyEvent e) {
//                
//                switch(e.getKeyCode()){
//                    case KeyEvent.VK_UP:
//                        pollo.setLocation(pollo.getX(), pollo.getY()-10);
//                        break;
//                    case KeyEvent.VK_DOWN:
//                        pollo.setLocation(pollo.getX(), pollo.getY()+10);
//                        break;
//                    case KeyEvent.VK_LEFT:
//                        pollo.setLocation(pollo.getX()-10, pollo.getY());
//                        break;
//                    case KeyEvent.VK_RIGHT:
//                        pollo.setLocation(pollo.getX()+10, pollo.getY());
//                        break;
//                }
//                System.out.println("Key: "+e.getKeyCode());
//            }
//        });
//        
//        timerCarro = new Timer(5, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                
//                if(carro.getX()<728){
//                    carro.setLocation(carro.getX()+1, carro.getY());
//                }else{
//                    carro.setLocation(0,590);
//                }
//                if(chequearColision()){
//                    colision();
//                }
//                
//                if(limo.getX()>0){
//                    limo.setLocation(limo.getX()-1, limo.getY());
//                }else{
//                    limo.setLocation(650, 340);
//                }
//                
//                
//                if(chequearColision()){
//                    colision();
//                }
//                
//            }
//        });
//        
//        timerAmbulancia = new Timer(4, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(ambulancia.getX()<728){
//                    ambulancia.setLocation(ambulancia.getX()+1, ambulancia.getY());
//                }else{
//                    ambulancia.setLocation(0, 500);
//                }
//                if(chequearColision()){
//                    colision();
//                }
//            }
//        });
//        
//        timerCamion = new Timer(7, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(camion.getX()>0){
//                    camion.setLocation(camion.getX()-1, camion.getY());
//                }else{
//                    camion.setLocation(650, 555);
//                }
//                if(chequearColision()){
//                    colision();
//                }
//            }
//        });
//        
//        timerCarro.start();
//        timerAmbulancia.start();
//        timerCamion.start();
    }
    
    public Boolean chequearColision(){
        Rectangle carroRect = carro.getBounds();
        Rectangle camionRect = camion.getBounds();
        Rectangle ambulanciaRect = ambulancia.getBounds();
        Rectangle limoRect = limo.getBounds();
        
        Rectangle colisionCarroRect = SwingUtilities.computeIntersection(pollo.getX(), pollo.getY(), pollo.getWidth(), pollo.getHeight(), carroRect);
        Rectangle colisionCamionRect = SwingUtilities.computeIntersection(pollo.getX(), pollo.getY(), pollo.getWidth(), pollo.getHeight(), camionRect);
        Rectangle colisionAmbulanciaRect = SwingUtilities.computeIntersection(pollo.getX(), pollo.getY(), pollo.getWidth(), pollo.getHeight(), ambulanciaRect);
        Rectangle colisionLimoRect = SwingUtilities.computeIntersection(pollo.getX(), pollo.getY(), pollo.getWidth(), pollo.getHeight(), limoRect);
        
        boolean colisionConCarro = colisionCarroRect.getWidth()>0 && colisionCarroRect.getHeight()>0;
        boolean colisionConCamion = colisionCamionRect.getWidth()>0 && colisionCamionRect.getHeight()>0;
        boolean colisionConAmbulancia = colisionAmbulanciaRect.getWidth()>0 && colisionAmbulanciaRect.getHeight()>0;
        boolean colisionConLimo = colisionLimoRect.getWidth()>0 && colisionLimoRect.getHeight()>0;
        
        return(colisionConCarro || colisionConCamion || colisionConAmbulancia || colisionConLimo);
    }
    
    public void colision(){
        pollo.setLocation(360, 700);
    }
    
    public static void main(String[] args) {
        System.out.println("INICIANDO CROSSY ROAD");
        CrossyRoad myGame = new CrossyRoad();
        myGame.iniciar();
    }
    
}
