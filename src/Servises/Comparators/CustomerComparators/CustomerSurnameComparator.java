package servises.comparators.customerComparators;

import beans.Customer;

import java.util.Comparator;

/**
 * compares 2 objects of Customer by surname
 */
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
