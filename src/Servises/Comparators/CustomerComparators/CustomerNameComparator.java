package Servises.Comparators.CustomerComparators;

import Beans.Customer;

import java.util.Comparator;

public class CustomerNameComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer customer, Customer t1) {
        return customer.getName().compareTo(t1.getName());
    }

    @Override
    public String toString() {
        return "by Name";
    }
}
