package servises.factory;

import beans.BonusCard;
import beans.ObjectCreator;

/**
 * factory for BonusCard
 */
public class BonusCardCreatorFab extends ObjectCreatorFab{
    @Override
    public ObjectCreator create() {
        return new BonusCard();
    }

    @Override
    public String toString() {
        return "Bonus Card";
    }
}

