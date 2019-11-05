package Servises.ObjectManagers;

import Servises.Factory.*;

import java.util.ArrayList;

/**
 * ObjectCreator factory
 */
public class FactoryManager  implements IFactoryManager{
    private ArrayList<ObjectCreatorFab> factoryArray;
    public  FactoryManager() {
        factoryArray= new ArrayList<ObjectCreatorFab>();
        factoryArray.add(new BonusCardCreatorFab());
        factoryArray.add(new CatalogCreatorFab());
        factoryArray.add(new CustomerCreatorFab());
        factoryArray.add(new ItemCreatorFab());
        factoryArray.add(new RegularCustomerCreatorFab());
        factoryArray.add(new ShoppingCartCreatorFab());
    }

    @Override
    public ArrayList<ObjectCreatorFab> getFactory() {
        return factoryArray;
    }
}
