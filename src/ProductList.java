import java.util.*;

public class ProductList {
    private final Map<String, Product> mapOfProducts = new HashMap<>();
    private int count = 0;
    public Map<String, Product> getMap() {
        return mapOfProducts;
    }

    public boolean add(String name, Product product) {
        if (mapOfProducts.containsKey(name)) {
            return false;
        }
        product.number = count;
        mapOfProducts.put(name, product);
        count++;
        return true;

    }

    public boolean delete(String name) {
        if (mapOfProducts.containsKey(name)) {
            mapOfProducts.remove(name);
            return true;
        } else return false;

    }

    public boolean changeNameByName(String name, String changingName) {
        if (mapOfProducts.containsKey(name)) {
            mapOfProducts.put(changingName, mapOfProducts.get(name));
            mapOfProducts.remove(name);
            return true;
        }
        return false;
    }

    public boolean changePriceByName(String name, Product product) {
        if (mapOfProducts.containsKey(name)) {
            int i = mapOfProducts.get(name).number;
            mapOfProducts.remove(name);
            mapOfProducts.put(name, product);
            mapOfProducts.get(name).number = i;
            return true;
        }
        return false;
    }

    public boolean changeNameByNumber(int number, String name) {
        for (Map.Entry<String, Product> entry : mapOfProducts.entrySet()) {
            if (entry.getValue().number == number) {
                mapOfProducts.put(name, entry.getValue());
                mapOfProducts.remove(entry.getKey());
                return true;
            }
        }
        return false;
    }

    public boolean changePriceByNumber(int number, Product product) {
        for (Map.Entry<String, Product> entry : mapOfProducts.entrySet()) {
            if (entry.getValue().number == number) {
                product.number = number;
                String name = entry.getKey();
                mapOfProducts.remove(entry.getKey());
                mapOfProducts.put(name, product);
                return true;
            }
        }
        return false;
    }

    public float getPrice(int number, int counter) {
        for (Map.Entry<String, Product> entry : mapOfProducts.entrySet()) {
            if (entry.getValue().number == number) {
                final float f = (float) entry.getValue().getCop();
                return ((entry.getValue().priceRub + (f / 100)) * counter);
            }
        }
        return (float) 0.0;
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
