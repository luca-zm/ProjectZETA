package logic.model;

import javafx.scene.Scene;

public class Singleton {
	
    private static Singleton istance = new Singleton();
    public int flag;
    public Scene myscene;

    public static Singleton getInstance() {
        if(istance == null)
            istance = new Singleton();
        return istance;
    }

    private Singleton() {
    	flag = 0;
    }

    
    
    //Sezione Singleton per l'utente loggato
    public void logAS(int newFlag) {
    	
        flag = newFlag;
        
    }
    
    public int status(){
    	
        return flag;
        
    }

    
    //Sezione singleton per la scena
    public void saveScene(Scene newScene){
    	
        myscene = newScene;
        
    }
    
    public Scene getScene(){
    	
        return myscene;
        
    }

}
