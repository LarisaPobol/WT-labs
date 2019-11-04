package Servises.Comparators.CustomerComparators;

import Beans.Customer;

import java.util.Comparator;

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
