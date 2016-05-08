/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author reg3x
 */
public class Vehicle extends GameObject {
    String movementDirection;
    Timer timer;
    int xlimit;
    

    public Vehicle(String urlstring, String movementDirection , int xInit, int yInit, int xlimit) {
        super(urlstring, xInit, yInit);
        this.movementDirection = movementDirection;
        this.xlimit = xlimit;
        startAutomaticMovement();
    }
    
    public void startAutomaticMovement(){
                
        ArrayList<Integer> speeds;
        speeds = new ArrayList<>();
        speeds.add(2);
        speeds.add(5);
        speeds.add(8);
        speeds.add(12);
        int Min =1;
        int Max =4;
        int speed = Min+(int)(Math.random()*((Max-Min)+1));
        
        
        timer = new Timer(speeds.get(speed-1) ,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                switch(movementDirection){
                    case "MoveLeft":
                        if(getLabel().getX()>0){
                            getLabel().setLocation(getLabel().getX()-1, getLabel().getY());
                        }else{
                            getLabel().setLocation(650, getyInit());
                        }
                        break;
                    case "MoveRight":
                        if(getLabel().getX()<728){
                            getLabel().setLocation(getLabel().getX()+1, getLabel().getY());
                        }else{
                            getLabel().setLocation(0, getyInit());
                        }
                        break;
                }
            }
        });
        timer.start();
        
    }

    
}
