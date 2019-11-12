package servises.comparators;

import servises.comparators.bonusCardComparators.*;

import servises.comparators.catalogComparators.CatalogNameComparator;
import servises.comparators.catalogComparators.CatalogParentCatalogComparator;
import servises.comparators.customerComparators.*;
import servises.comparators.itemComparators.*;
import servises.comparators.regularCustomerComparators.RegularCustomerBonusCardComparator;
import servises.comparators.shoppingCartComparators.ShoppingCartClientIdComparator;
import servises.comparators.shoppingCartComparators.ShoppingCartIdComparator;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator factory
 */
public class ComparatorFactory {
    private ArrayList<ArrayList<Comparator>> comparatorArray;

    public ArrayList<ArrayList<Comparator>> getComparatorArray() {
        return comparatorArray;
    }

    public ComparatorFactory() {
        comparatorArray = new ArrayList<ArrayList<Comparator>>();
        ArrayList<Comparator> itemComparators = new ArrayList<>();
        itemComparators.add(new ItemAmountComparator());
        itemComparators.add(new ItemCatalogComparator());
        itemComparators.add(new ItemIdComparator());
        itemComparators.add(new ItemNameComparator());
        itemComparators.add(new ItemPriceComparator());

        ArrayList<Comparator> bonusCardComparators = new ArrayList<>();
        bonusCardComparators.add(new BonusCardNumberComparator());
        bonusCardComparators.add(new BonusCardPersonalDiscountComparator());

        ArrayList<Comparator> catalogComparators = new ArrayList<>();
        catalogComparators.add(new CatalogNameComparator());
        catalogComparators.add(new CatalogParentCatalogComparator());

        ArrayList<Comparator> customerComparators = new ArrayList<>();
        customerComparators.add(new CustomerEmailComparator());
        customerComparators.add(new CustomerNameComparator());
        customerComparators.add(new CustomerPhoneNumberComparator());
        customerComparators.add(new CustomerShoppingCartComparator());
        customerComparators.add(new CustomerSurnameComparator());

        ArrayList<Comparator> regularCustomerComparators = new ArrayList<>();
        regularCustomerComparators.add(new RegularCustomerBonusCardComparator());

        ArrayList<Comparator> shoppingCartComparators = new ArrayList<>();
        shoppingCartComparators.add(new ShoppingCartClientIdComparator());
        shoppingCartComparators.add(new ShoppingCartIdComparator());


        comparatorArray.add(bonusCardComparators);
        comparatorArray.add(catalogComparators);
        comparatorArray.add(customerComparators);
        comparatorArray.add(itemComparators);
        comparatorArray.add(regularCustomerComparators);
        comparatorArray.add(shoppingCartComparators);
    }

    /**
     * returns list of comparators for selected by index type of objects
     * @param index index of type of objects
     * @return list of comparators
     */
    public List getListOfComparators(int index){
        return comparatorArray.get(index);
    }

    /**
     * returns comparator selected by index for selected by index type of objects
     * @param listIndex index of type of objects
     * @param comparatorIndex index of comparator
     * @return object type of comparator
     */
    public Comparator getNeededComparator(int listIndex, int comparatorIndex) {
        return comparatorArray.get(listIndex).get(comparatorIndex);
    }

}
