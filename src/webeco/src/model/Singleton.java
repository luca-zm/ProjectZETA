package model;


public class Singleton {
	
    private static Singleton istance = new Singleton();
    private AbstractUser user = null;
    public int flag;

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
