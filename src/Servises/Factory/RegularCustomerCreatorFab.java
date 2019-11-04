package Servises.Factory;

import Beans.ObjectCreator;
import Beans.RegularCustomer;

public class RegularCustomerCreatorFab extends ObjectCreatorFab{
    @Override
    public ObjectCreator Create() {
        return new RegularCustomer();
    }

    @Override
    public String toString() {
        return "Regular Customer";
    }
}
