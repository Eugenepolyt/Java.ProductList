package productClass;


import java.math.BigDecimal;

public class Product {
    String name;
    BigDecimal price;

    Product (BigDecimal price, String name) {
        final String priceStr = Double.toString(price.doubleValue());
        final int cop = Integer.parseInt(priceStr.substring(priceStr.indexOf(".") + 1));
        if (price.intValue() <= 0 || cop > 99 || cop <= 0) {
            throw new IllegalArgumentException();
        }
        else {
            this.price = price;
        }
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public int getRub() {
        return price.intValue();
    }

    public double getCop() {
        final String priceStr = Double.toString(price.doubleValue());
        return Integer.parseInt(priceStr.substring(priceStr.indexOf(".") + 1));
    }

    public BigDecimal getFull() {
        return price;
    }

    @Override
    public String toString() {
        return "\n Имя продукта: " + name + "\n Цена: " + price ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + name.hashCode();
        result = result * prime + price.intValue();
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
        return (other.name.equals(name)) && (other.price.equals(price));
    }

}
