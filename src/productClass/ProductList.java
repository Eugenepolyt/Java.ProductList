package productClass;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductList {
    final Map<Integer, Product> mapOfProducts = new HashMap<>();

    public String add(int number, Product product) {
        Product previous = mapOfProducts.get(number);
        if (mapOfProducts.put(number, product) == null) {
            mapOfProducts.put(number, product);
            System.out.println("Продукт" + product + "\nдобавлен\n");
            return "Продукт добавлен";
        }
        System.out.println("Продукт " + previous + "\nзаменен на " + mapOfProducts.get(number) + "\n");
        return "Продукт заменен";
    }

    public String delete(int number) {
        Product previous = mapOfProducts.get(number);
        if (mapOfProducts.remove(number) == null) {
            System.out.println("Продукт не существует\n");
            return "Продукт не существует";
        }
        System.out.println("Продукт" + previous + "\nудален\n");
        return "Продукт удален";
    }

    public boolean changeName(int number, String name) {
        if (mapOfProducts.getOrDefault(number, new Product(new BigDecimal(1), new BigDecimal(1), "Default"))
                .equals(new Product(new BigDecimal(1), new BigDecimal(1), "Default"))) {
            return false;
        }
        mapOfProducts.get(number).name = name;
        return true;
    }

    public boolean changePrice(int number,BigDecimal rub, BigDecimal cop) {
        if (mapOfProducts.getOrDefault(number, new Product(new BigDecimal(1), new BigDecimal(1), "Default"))
                .equals(new Product(new BigDecimal(1), new BigDecimal(1), "Default"))) {
            return false;
        }
        mapOfProducts.get(number).priceRub = rub;
        mapOfProducts.get(number).priceCop = cop;
        return true;
    }

    public BigDecimal getPrice(int number, int counter) {
        if (mapOfProducts.containsKey(number)) {
            BigDecimal first = mapOfProducts.get(number).priceRub.multiply(BigDecimal.valueOf(100));
            BigDecimal second = first.add(mapOfProducts.get(number).priceCop);
            BigDecimal third = second.multiply(BigDecimal.valueOf(counter));
            return third.divide(BigDecimal.valueOf(100.0));
        }
        return new BigDecimal(0);
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
