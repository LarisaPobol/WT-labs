package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShoppingCart extends ObjectCreator implements Serializable {
    private Integer Id;
    private Integer clientId;

    public ShoppingCart() {

    }

    @Override
    public String toString() {
        return Id.toString() + '\'';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCart)) return false;
        ShoppingCart that = (ShoppingCart) o;
        return getId() == that.getId() &&
                getClientId() == that.getClientId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClientId());
    }


}
