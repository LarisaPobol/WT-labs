package servises.factory;

import beans.Customer;
import beans.ObjectCreator;

/**
 * factory for Customer
 */
public class CustomerCreatorFab extends ObjectCreatorFab{
    @Override
    public ObjectCreator create() {
        return new Customer();
    }

    @Override
    public String toString() {
        return "Customer";
    }
}
