package Servises.Comparators.CustomerComparators;

import Beans.Customer;

import java.util.Comparator;

public class CustomerEmailComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer customer, Customer t1) {
        return customer.getEmail().compareTo(t1.getEmail());
    }

    @Override
    public String toString() {
        return "by Email";
    }
}
