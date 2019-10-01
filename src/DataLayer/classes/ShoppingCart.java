package DataLayer.Classes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ShoppingCart extends ObjectCreator implements Serializable {
    private int Id;
    private int clientId;
    private List<Item> itemsInShoppingCart;

    public ShoppingCart(int id, int clientId) {
        Id = id;
        this.clientId = clientId;
    }

    public ShoppingCart() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public List<Item> getItemsInShoppingCart() {
        return itemsInShoppingCart;
    }

    public void setItemsInShoppingCart(List<Item> itemsInShoppingCart) {
        this.itemsInShoppingCart = itemsInShoppingCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCart)) return false;
        ShoppingCart that = (ShoppingCart) o;
        return getId() == that.getId() &&
                getClientId() == that.getClientId() &&
                Objects.equals(getItemsInShoppingCart(), that.getItemsInShoppingCart());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getClientId(), getItemsInShoppingCart());
    }

    @Override
    public ObjectCreator Create() {
        return new ShoppingCart();
    }
}
