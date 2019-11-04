package Servises.Comparators.BonusCardComparators;

import Beans.BonusCard;

import java.util.Comparator;

public class BonusCardPersonalDiscountComparator  implements Comparator<BonusCard> {
    @Override
    public int compare(BonusCard bonusCard, BonusCard t1) {
        if (bonusCard.getPersonalDiscount() < t1.getPersonalDiscount()) return -1;
        else if (bonusCard.getPersonalDiscount() > t1.getPersonalDiscount()) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "by Personal Discount";
    }
}
