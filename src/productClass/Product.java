package productClass;


import java.math.BigDecimal;

public class Product {
    String name;
    BigDecimal priceRub;
    BigDecimal priceCop;

    Product (BigDecimal priceRub, BigDecimal priceCop, String name) {
        if (priceRub.intValue() <= 0 || priceCop.intValue() <= 0 || priceCop.intValue() > 99) {
            throw new IllegalArgumentException();
        }
        else {
            this.priceRub = priceRub;
            this.priceCop = priceCop;
        }
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public BigDecimal getRub() {
        return priceRub;
    }

    public BigDecimal getCop() {
        return priceCop;
    }

    public String getFull() {
        return priceRub + "." + priceCop;
    }

    @Override
    public String toString() {
        return "\n Имя продукта: " + name + "\n Цена: " + priceRub + "," + priceCop;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + name.hashCode();
        result = result * prime + priceRub.intValue();
        result = result * prime + priceCop.intValue();
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
        return (other.name.equals(name)) && (other.priceRub.equals(priceRub)) && (other.priceCop.equals(priceCop));
    }

}
