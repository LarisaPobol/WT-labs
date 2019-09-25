package DataLayer.classes;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Catalog implements Serializable {
    private String Name;
    private Catalog parentCatalog;
    private List<Catalog> subCatalogues;
    private List<Item> catalogItems;

    public Catalog(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Catalog getParentCatalog() {
        return parentCatalog;
    }

    public void setParentCatalog(Catalog parentCatalog) {
        this.parentCatalog = parentCatalog;
    }

    public List<Catalog> getSubCatalogues() {
        return subCatalogues;
    }

    public void setSubCatalogues(List<Catalog> subCatalogues) {
        this.subCatalogues = subCatalogues;
    }

    public List<Item> getCatalogItems() {
        return catalogItems;
    }

    public void setCatalogItems(List<Item> catalogItems) {
        this.catalogItems = catalogItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Catalog)) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(getName(), catalog.getName()) &&
                Objects.equals(getParentCatalog(), catalog.getParentCatalog()) &&
                Objects.equals(getSubCatalogues(), catalog.getSubCatalogues()) &&
                Objects.equals(getCatalogItems(), catalog.getCatalogItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getParentCatalog(), getSubCatalogues(), getCatalogItems());
    }
}
