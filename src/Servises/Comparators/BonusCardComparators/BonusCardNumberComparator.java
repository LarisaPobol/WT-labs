package servises.comparators.bonusCardComparators;

import beans.BonusCard;

import java.util.Comparator;

/**
 * compares 2 objects of BonusCard by Number
 */
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
