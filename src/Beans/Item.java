package Beans;

import java.io.Serializable;
import java.util.Objects;

public class Item  extends ObjectCreator implements Serializable {
    private Integer id;
    private Float price;
    private Integer amount;
    private  String name;
    private Catalog catalog;


    public Item() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name + '\'';
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
