package Servises.Comparators.BonusCardComparators;

import Beans.BonusCard;

import java.util.Comparator;

public class BonusCardNumberComparator  implements Comparator<BonusCard> {
    @Override
    public int compare(BonusCard bonusCard, BonusCard t1) {
        return bonusCard.getBonusCardNumber().compareTo(t1.getBonusCardNumber());
    }

    @Override
    public String toString() {
        return "by Number";
    }
}
