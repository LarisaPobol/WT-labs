package servises.comparators.customerComparators;

import beans.Customer;

import java.util.Comparator;

/**
 * compares 2 objects of Customer by phone number
 */
public class CustomerPhoneNumberComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer customer, Customer t1) {
        return customer.getPhoneNumber().compareTo(t1.getPhoneNumber());
    }

    @Override
    public String toString() {
        return "by Phone Number";
    }
}
