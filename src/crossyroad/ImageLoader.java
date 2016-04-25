/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossyroad;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author reg3x
 */
public class ImageLoader {
    private static ImageLoader instance=null;

    private static final int MAX_IMAGES=6;
    public static final int MAPA=0;
    public static final int POLLO=1;
    public static final int CARRO=2;
    public static final int CAMION=3;
    public static final int AMBULANCIA=4;
    public static final int LIMO=5;

    private ImageIcon images[];

    private ImageLoader(){
        String filenames[]= new String[]{"mapa", "pollo", "carro","camion","ambulancia","limo"};        

        images = new ImageIcon[MAX_IMAGES];
        for(int i=0;i<MAX_IMAGES;i++){
            URL url = this.getClass().getResource("images/"+filenames[i]+".png");
            images[i] = new ImageIcon(url);
        }
    }

    public static ImageLoader getInstance(){
        if(instance==null)
          instance = new ImageLoader();

        return instance;
    
    }

    public ImageIcon getImage(int imageId){
        if(imageId<0 || imageId>=MAX_IMAGES)
            return null;
        
        System.out.println("retornando");
        return images[imageId];
    }
}
