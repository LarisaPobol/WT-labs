package Beans;

import java.io.Serializable;
import java.util.Objects;

public class RegularCustomer extends Customer implements Serializable {
    private BonusCard bonusCard;

    public RegularCustomer(String name, String surname, String phoneNumber, String email) {
        super(name, surname, phoneNumber, email);
    }

    public RegularCustomer() {
        super();
    }

    @Override
    public String toString() {
        return super.getName() + ' ' + super.getSurname();
    }

    public BonusCard getBonusCard() {
        return bonusCard;
    }

    public void setBonusCard(BonusCard bonusCard) {
        this.bonusCard = bonusCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegularCustomer)) return false;
        if (!super.equals(o)) return false;
        RegularCustomer that = (RegularCustomer) o;
        return Objects.equals(getBonusCard(), that.getBonusCard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBonusCard());
    }

}
