package servises.comparators.customerComparators;

import beans.Customer;

import java.util.Comparator;

/**
 * compares 2 objects of Customer by email
 */
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
