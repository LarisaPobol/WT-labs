package servises.comparators.regularCustomerComparators;


import beans.RegularCustomer;

import java.util.Comparator;

/**
 * compares 2 objects of RegularCustomer by bonus card numbers
 */
public class RegularCustomerBonusCardComparator  implements Comparator<RegularCustomer> {
    @Override
    public int compare(RegularCustomer regularCustomer, RegularCustomer t1) {
        return regularCustomer.getBonusCard().getBonusCardNumber().compareTo(t1.getBonusCard().getBonusCardNumber());
    }

    @Override
    public String toString() {
        return "by Bonus Card Number";
    }
}
