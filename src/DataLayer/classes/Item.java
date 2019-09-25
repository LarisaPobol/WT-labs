package DataLayer.classes;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {
    private int id;
    private float price;
    private int amount;
    private  String name;
    private Catalog catalog;

    public Item(int id, float price, int amount, String name, Catalog catalog) {
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.name = name;
        this.catalog = catalog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getId() == item.getId() &&
                Float.compare(item.getPrice(), getPrice()) == 0 &&
                getAmount() == item.getAmount() &&
                Objects.equals(getName(), item.getName()) &&
                Objects.equals(getCatalog(), item.getCatalog());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getAmount(), getName(), getCatalog());
    }
}
