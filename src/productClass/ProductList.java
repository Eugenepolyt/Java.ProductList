package productClass;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductList {
    final Map<Integer, Product> mapOfProducts = new HashMap<>();

    public Object add(int number, Product product) {
        return mapOfProducts.put(number, product);
    }

    public Object delete(int number) {
        return mapOfProducts.remove(number);
    }

    public boolean changeName(int number, String name) {
        if (mapOfProducts.get(number) == null) {
            return false;
        }
        mapOfProducts.get(number).name = name;
        return true;
    }

    public boolean changePrice(int number, BigDecimal price) {
        if (mapOfProducts.get(number) == null) {
            return false;
        }
        mapOfProducts.get(number).price = price;
        return true;
    }

    public BigDecimal getPrice(int number, int counter) {
        if (!mapOfProducts.containsKey(number)) {
            return new BigDecimal(0);
        }
        return mapOfProducts.get(number).price.multiply(BigDecimal.valueOf(counter));
    }


    @Override
    public int hashCode() {
        return mapOfProducts.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        ProductList other = (ProductList ) o;
        return mapOfProducts.equals(other.mapOfProducts);
    }


}
