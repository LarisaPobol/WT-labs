package DataLayer.classes;

import java.io.Serializable;
import java.util.Objects;

public class BonusCard  implements Serializable {
    private String bonusCardNumber;
    private int clientId;
    private float personalDiscount;

    public BonusCard(int clientId) {
        this.clientId = clientId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getBonusCardNumber() {
        return bonusCardNumber;
    }

    public void setBonusCardNumber(String bonusCardNumber) {
        this.bonusCardNumber = bonusCardNumber;
    }

    public float getPersonalDiscount() {
        return personalDiscount;
    }

    public void setPersonalDiscount(float personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BonusCard)) return false;
        BonusCard bonusCard = (BonusCard) o;
        return getClientId() == bonusCard.getClientId() &&
                Float.compare(bonusCard.getPersonalDiscount(), getPersonalDiscount()) == 0 &&
                Objects.equals(getBonusCardNumber(), bonusCard.getBonusCardNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBonusCardNumber(), getClientId(), getPersonalDiscount());
    }
}
