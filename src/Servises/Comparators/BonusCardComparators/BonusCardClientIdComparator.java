package Servises.Comparators.BonusCardComparators;

import Beans.BonusCard;

import java.util.Comparator;

public class BonusCardClientIdComparator implements Comparator<BonusCard> {
    @Override
    public int compare(BonusCard bonusCard, BonusCard bonusCardOther) {
        if (bonusCard.getClientId() < bonusCardOther.getClientId()) return -1;
        else if (bonusCard.getClientId() >bonusCardOther.getClientId()) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "by Client Id ";
    }
}
