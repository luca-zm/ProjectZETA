package logic.model;

import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Singleton {
	
    private static Singleton istance = new Singleton();
    private AbstractUser user = null;
    public int flag;
    public Scene myscene;
    public String mydescr;
    public String img;

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

	public AbstractUser getUser() {
		return user;
	}

	public void setUser(AbstractUser user) {
		this.user = user;
	}

	public void saveDescription(String description) {
		mydescr = description;
		
	}
	public String getDescr() {
		return mydescr;
	}

	public void saveImage(String image) {
		img = image;
		
	}
	public String getImage() {
		return img;
	}
    
    

}
