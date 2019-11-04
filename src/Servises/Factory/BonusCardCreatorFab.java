package Servises.Factory;

import Beans.BonusCard;
import Beans.ObjectCreator;

public class BonusCardCreatorFab extends ObjectCreatorFab{
    @Override
    public ObjectCreator Create() {
        return new BonusCard();
    }

    @Override
    public String toString() {
        return "Bonus Card";
    }
}

