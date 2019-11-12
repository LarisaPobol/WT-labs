package servises.comparators.customerComparators;

import beans.Customer;

import java.util.Comparator;

/**
 * compares 2 objects of Customer by name
 */
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
