package productClass;

import java.util.HashMap;
import java.util.Map;

public class ProductList {
    final Map<Integer, Product> mapOfProducts = new HashMap<>();

    public boolean add(int number, Product product) {
        if ((mapOfProducts.containsKey(number)) || (product.priceCop > 99)) {
            return false;
        }
        mapOfProducts.put(number, product);
        return true;
    }

    public void delete(int number) {
        mapOfProducts.remove(number);
    }

    public boolean changeName(int number, String name) {
        if (mapOfProducts.containsKey(number)) {
            mapOfProducts.get(number).name = name;
            return true;
        }
        return false;
    }

    public boolean changePrice(int number,int rub, int cop) {
        if (mapOfProducts.containsKey(number)) {
            mapOfProducts.get(number).priceRub = rub;
            mapOfProducts.get(number).priceCop = cop;
            return true;
        }
        return false;
    }

    public double getPrice(int number, int counter) {
            final int cost = counter * (100 * mapOfProducts.get(number).priceRub + mapOfProducts.get(number).priceCop);
            return ((double) cost) / 100;
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
