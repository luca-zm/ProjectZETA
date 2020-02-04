package laptopeco.logic.model;

import java.util.ArrayList;
import java.util.List;

public class CatalogueSingleton {

    private ArrayList<Product> singletonCatalogue;
    
    private static class LazyCointainer {
        private static final CatalogueSingleton sigletonInstance = new CatalogueSingleton(null);
    }

    protected CatalogueSingleton(ArrayList<Product> catalogue) {
        this.singletonCatalogue = catalogue;
    }

    public void singletonOperation1(){
    	  throw new UnsupportedOperationException();
    }

    public List<Product> getSingletonCatalogue() {
        return singletonCatalogue;
    }

    public static final CatalogueSingleton getSingletonInstance() {
        return LazyCointainer.sigletonInstance;
    }

}
