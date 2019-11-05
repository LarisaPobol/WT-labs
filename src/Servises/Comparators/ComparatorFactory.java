package Servises.Comparators;

import Beans.*;
import Beans.ObjectCreator;
import Servises.Comparators.BonusCardComparators.*;

import Servises.Comparators.CatalogComparators.CatalogNameComparator;
import Servises.Comparators.CatalogComparators.CatalogParentCatalogComparator;
import Servises.Comparators.CustomerComparators.*;
import Servises.Comparators.ItemComparators.*;
import Servises.Comparators.RegularCustomerComparators.RegularCustomerBonusCardComparator;
import Servises.Comparators.ShoppingCartComparators.ShoppingCartClientIdComparator;
import Servises.Comparators.ShoppingCartComparators.ShoppingCartIdComparator;


import java.util.ArrayList;
import java.util.Comparator;

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

    public ArrayList<Comparator> getListOfComparators(int index){
        return comparatorArray.get(index);
    }

    public Comparator getNeededComparator(int listIndex, int comparatorIndex) {
        return comparatorArray.get(listIndex).get(comparatorIndex);
    }

}
