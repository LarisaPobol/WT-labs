package servises.factory;

import beans.ObjectCreator;
import beans.RegularCustomer;

/**
 * factory for RegularCustomer
 */
public class RegularCustomerCreatorFab extends ObjectCreatorFab{
    @Override
    public ObjectCreator create() {
        return new RegularCustomer();
    }

    @Override
    public String toString() {
        return "Regular Customer";
    }
}
