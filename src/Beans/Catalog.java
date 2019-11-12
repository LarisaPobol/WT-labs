package beans;
import java.io.Serializable;
import java.util.Objects;

/**
 * java bean for catalog, contains fields for catalog's name and link to parent catalog
 */
public class Catalog extends ObjectCreator  implements Serializable {
    private String Name;
    private Catalog parentCatalog;


    public Catalog(String name) {
        Name = name;
    }

    public Catalog() {
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


    @Override
    public String toString() {
        return  Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Catalog)) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(getName(), catalog.getName()) &&
                Objects.equals(getParentCatalog(), catalog.getParentCatalog());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getParentCatalog());
    }

}
