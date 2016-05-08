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
    private ArrayList<Coin> coins;
   
    public Map(int level, int xInit, int yInit) {
        super("mapa"+level+".png", xInit, yInit);
        this.level = level;
        loadRoadsCoordinates();
        createCars();
        createCoins();
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
    
    public void createCoins(){
        coins = new ArrayList<>();
        
        for(int i=0;i<5;i++){
            coins.add(new Coin("coin.png", i*60, i*60));
        }
    }
    
    public void loadRoadsCoordinates(){
        YRoadsCoordinates = new ArrayList<>();
        switch(level){
            case 1:
                numRoads=8;
                limitLeft = 0;
                limitRight = 650;
                // TODO: SET LIMIT UP FOR WINNING
                YRoadsCoordinates.add(600+12);
                YRoadsCoordinates.add(550+12);
                YRoadsCoordinates.add(500+12);
                YRoadsCoordinates.add(450+12);
                YRoadsCoordinates.add(300+12);
                YRoadsCoordinates.add(250+12);
                YRoadsCoordinates.add(200+12);
                YRoadsCoordinates.add(150+12);
                break;
            
            case 2:
                numRoads = 2;
                limitLeft = 0;
                limitRight = 650;
                YRoadsCoordinates.add(490);
                YRoadsCoordinates.add(455);
        }
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<Coin> getCoins() {
        return coins;
    }
   
    
    
}
