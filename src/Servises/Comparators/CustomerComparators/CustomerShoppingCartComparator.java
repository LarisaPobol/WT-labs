package Servises.Comparators.CustomerComparators;

import Beans.Customer;

import java.util.Comparator;

public class CustomerShoppingCartComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer customer, Customer t1) {
        if (customer.getShoppingCart().getId()< t1.getShoppingCart().getId()) return -1;
        else if (customer.getShoppingCart().getId() >t1.getShoppingCart().getId()) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "by ShoppingCart";
    }
}
