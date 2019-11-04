package Servises.Factory;

import Beans.Customer;
import Beans.ObjectCreator;

public class CustomerCreatorFab extends ObjectCreatorFab{
    @Override
    public ObjectCreator Create() {
        return new Customer();
    }

    @Override
    public String toString() {
        return "Customer";
    }
}
