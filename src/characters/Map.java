/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import java.util.ArrayList;

/**
 *
 * @author reg3x
 */
public class Map extends GameObject{
    private int level;
    private int numRoads;
    private int limitLeft, limitRight, limitUp;
    private ArrayList<Integer> YRoadsCoordinates;
    private ArrayList<Vehicle> vehicles;
   
    public Map(int level, String urlstring, int xInit, int yInit) {
        super(urlstring, xInit, yInit);
        this.level = level;
        loadRoadsCoordinates();
        createCars();
    }
    
    public void createCars(){
//        vehicles.add(new Vehicle("carro.png",0, 590));
//        vehicles.add(new Vehicle("camion.png",650, 555));
//        vehicles.add(new Vehicle("ambulancia.png",0, 500));
//        vehicles.add(new Vehicle("limo.png",650, 340));
        
        // load cars evenly comming from left and right
        vehicles = new ArrayList<Vehicle>();
        for(int i=0;i<numRoads;i++){
            if((i%2)==0){
                vehicles.add(new Vehicle("carro.png", "MoveLeft",limitRight, YRoadsCoordinates.get(i), limitLeft));
            }
            else{
                vehicles.add(new Vehicle("carro.png", "MoveRight",limitLeft, YRoadsCoordinates.get(i), limitRight));
            }
        }
        
    }
    
    public void loadRoadsCoordinates(){
        YRoadsCoordinates = new ArrayList<>();
        switch(level){
            case 1:
                numRoads=4;
                limitLeft = 0;
                limitRight = 650;
                // TODO: SET LIMIT UP FOR WINNING
                YRoadsCoordinates.add(590);
                YRoadsCoordinates.add(555);
                YRoadsCoordinates.add(500);
                YRoadsCoordinates.add(340);
                break;
        }
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public int getLevel() {
        return level;
    }
   
    
    
}
