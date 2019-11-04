package Servises.Comparators.CustomerComparators;

import Beans.Customer;

import java.util.Comparator;

public class CustomerSurnameComparator  implements Comparator<Customer> {
    @Override
    public int compare(Customer customer, Customer t1) {
        return customer.getSurname().compareTo(t1.getSurname());
    }

    @Override
    public String toString() {
        return "by Surname";
    }
}
