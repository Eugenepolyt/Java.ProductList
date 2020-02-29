package productClass;

public class Product {
    String name;
    int priceRub;
    int priceCop;

    Product (int priceRub, int priceCop, String name) {
        this.priceRub = priceRub;
        this.priceCop = priceCop;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public int getRub() {
        return priceRub;
    }

    public int getCop() {
        return priceCop;
    }
    public String getFull() {
        return priceRub + "," + priceCop;
    }

    @Override
    public String toString() {
        return "\n Имя продукта: " + name + "\n Цена: " + priceRub + "," + priceCop;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + priceRub;
        result = result * prime + priceCop;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || hashCode() != o.hashCode()) {
            return false;
        }
        Product other = (Product) o;
        return (other.name.equals(name)) && (other.priceRub == priceRub) && (other.priceCop == priceCop);
    }

}
