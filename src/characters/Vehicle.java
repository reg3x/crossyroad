/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        //MAKE THE TIMER TIME A RANDOM NUMBER INSTEAD OF 5
        
        timer = new Timer(5 ,new ActionListener() {
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
