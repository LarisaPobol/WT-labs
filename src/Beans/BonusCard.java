package Beans;
import java.io.Serializable;
import java.util.Objects;

public class BonusCard extends ObjectCreator implements Serializable  {
    private String bonusCardNumber;
    private Integer clientId;
    private Float personalDiscount;

    public BonusCard() {
    }

    public ObjectCreator Create() {
        return new BonusCard();
    }
    public BonusCard(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return bonusCardNumber + '\'';
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getBonusCardNumber() {
        return bonusCardNumber;
    }

    public void setBonusCardNumber(String bonusCardNumber) {
        this.bonusCardNumber = bonusCardNumber;
    }

    public Float getPersonalDiscount() {
        return personalDiscount;
    }

    public void setPersonalDiscount(Float personalDiscount) {
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
