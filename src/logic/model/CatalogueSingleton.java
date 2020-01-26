package logic.model;

import java.util.ArrayList;

public class CatalogueSingleton {

    private ArrayList<Product> singletonCatalogue;
    
    private static class LazyCointainer {
        private final static CatalogueSingleton sigletonInstance = new CatalogueSingleton(null);
    }

    protected CatalogueSingleton(ArrayList<Product> catalogue) {
        this.singletonCatalogue = catalogue;
    }

    public void singletonOperation1() {
    }

    public ArrayList<Product> getSingletonCatalogue() {
        return singletonCatalogue;
    }

    public static final CatalogueSingleton getSingletonInstance() {
        return LazyCointainer.sigletonInstance;
    }

}
