/*
 * CrossyRoad 0.1 Licencia GPL
 * Autor: Diego Aguilera
 * Repositorio: https://github.com/reg3x/crossyroad
 * Email: diegoaguilera85@gmail.com
 */
package characters;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 * Esta clase describe los mapas utilizados por el juego conteniendo informacion
 * del nivel del juego, numero de vias, los vehiculos que se moveran por las vias
 * los limites dle mapa, las coordenadas de las vias , las monedas y los trenes
 * @author reg3x
 */
public class Map extends GameObject{
    private int level;
    private int numRoads;
    private int limitLeft, limitRight, limitUp;
    private ArrayList<Integer> YRoadsCoordinates;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Coin> coins;
    private Vehicle train;
   
    /**
     *
     * @param level nivel del juego
     * @param xInit coordenadas x iniciales
     * @param yInit coordenadas y iniciales
     */
    public Map(int level, int xInit, int yInit) {
        super("mapa"+level+".png", xInit, yInit);
        this.level = level;
        loadRoadsCoordinates();
        createCars();
        createCoins();
        
        if(level==4){
            train = new Vehicle("train.png", "MoveRight", limitLeft, 300, limitRight);
        }
    }
    
    /**
     * metodo encargado de crear los vehiculos que perteneceran a este mapa de 
     * forma aleatorea, tanto en posicion como en tipo de vehiculo.
     */
    public void createCars(){
        vehicles = new ArrayList<Vehicle>();
        
        // load cars evenly comming from left and right
        for(int i=0;i<numRoads;i++){
            int Min =1;
            int Max =6;
            int carNum = Min+(int)(Math.random()*((Max-Min)+1));

            if((i%2)==0){
                vehicles.add(new Vehicle("car"+carNum+"left.png", "MoveLeft",limitRight, YRoadsCoordinates.get(i), limitLeft));
            }
            else{
                vehicles.add(new Vehicle("car"+carNum+".png", "MoveRight",limitLeft, YRoadsCoordinates.get(i), limitRight));
            }
        }   
    }
    
    /**
     * metodo encargado de crear las monedas que apareceran en el mapa aleatoreamente.
     */
    public void createCoins(){
        coins = new ArrayList<>();
        
        for(int i=0;i<10;i++){
            int xMin =1;
            int xMax =600;
            int XCoord = xMin+(int)(Math.random()*((xMax-xMin)+1));

            int yMin =1;
            int yMax =600;
            int yCoord = yMin+(int)(Math.random()*((yMax-yMin)+1));
            coins.add(new Coin("coin.png", XCoord+50, yCoord+50));
        }
    }
    
    /**
     * metodo utilizado para cargar las coordenadas de las vias por donde transitaran
     * los vehiculos del mapa.
     */
    public void loadRoadsCoordinates(){
        YRoadsCoordinates = new ArrayList<>();
        switch(level){
            case 1:
                numRoads=8;
                limitLeft = 0;
                limitRight = 650;
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
                numRoads = 8;
                limitLeft = 0;
                limitRight = 650;
                YRoadsCoordinates.add(600+12);
                YRoadsCoordinates.add(550+12);
                YRoadsCoordinates.add(500+12);
                YRoadsCoordinates.add(450+12);
                YRoadsCoordinates.add(300+12);
                YRoadsCoordinates.add(250+12);
                YRoadsCoordinates.add(100+12);
                YRoadsCoordinates.add(50+12);
                break;
            case 3: case 4:
                numRoads = 8;
                YRoadsCoordinates.add(600+12);
                YRoadsCoordinates.add(550+12);
                YRoadsCoordinates.add(500+12);
                YRoadsCoordinates.add(450+12);
                YRoadsCoordinates.add(400+12);
                YRoadsCoordinates.add(350+12);
                YRoadsCoordinates.add(100+12);
                YRoadsCoordinates.add(50+12);
        }
    }

    /**
     *
     * @return los vehiculos del mapa.
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     *
     * @return el nivel del mapa.
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * @return monedas del mapa.
     */
    public ArrayList<Coin> getCoins() {
        return coins;
    }

    /**
     *
     * @return tren del mapa.
     */
    public Vehicle getTrain() {
        return train;
    }
    
}
