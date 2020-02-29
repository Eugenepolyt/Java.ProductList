package productClass;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Test {
    @org.junit.Test
    public void addProduct() {
        final ProductList i = new ProductList();

        final Map<Integer, Product> check = new HashMap<>();
        check.put(1, new Product(1, 47,"марс"));
        check.put(3, new Product(55, 34,"твикс"));

        assertTrue(i.add(1, new Product(1, 47,"марс")));
        assertFalse(i.add(2, new Product(55, 345,"твикс")));
        assertTrue(i.add(3, new Product(55, 34,"твикс")));

        assertEquals(check, i.mapOfProducts);


    }

    @org.junit.Test
    public void deleteProduct() {
        final ProductList i = new ProductList();
        final Map<Integer, Product> check = new HashMap<>();
        check.put(2, new Product(45, 34,"Кекс"));
        check.put(1, new Product(21, 11,"Марс2"));
        check.put(6, new Product(41, 3,"Марс6"));
        check.put(4, new Product(78, 22,"Марс4"));

        i.add(2, new Product(45, 34,"Кекс"));
        i.add(1, new Product(21, 11,"Марс2"));
        i.add(3, new Product(32, 45,"Марс3"));
        i.add(6, new Product(41, 3,"Марс6"));
        i.add(4, new Product(78, 22,"Марс4"));
        i.add(5, new Product(11, 11,"Марс5"));

        i.delete(3);
        i.delete(5);

        assertEquals(check, i.mapOfProducts);

    }

    @org.junit.Test
    public void changeName() {
        final ProductList i = new ProductList();

        final Map<Integer, Product> check = new HashMap<>();
        check.put(2, new Product(45, 34,"Кекс"));
        check.put(1, new Product(21, 11,"Марс2"));
        check.put(3, new Product(32, 45,"Марс3"));
        check.put(6, new Product(41, 3,"Марс6"));
        check.put(5, new Product(11, 11,"Бублик"));
        check.put(4, new Product(78, 22,"Марс4"));

        i.add(2, new Product(45, 34,"Марс"));
        i.add(1, new Product(21, 11,"Марс2"));
        i.add(3, new Product(32, 45,"Марс3"));
        i.add(6, new Product(41, 3,"Марс6"));
        i.add(4, new Product(78, 22,"Марс4"));
        i.add(5, new Product(11, 11,"Марс5"));

        assertTrue(i.changeName(2, "Кекс"));
        assertTrue(i.changeName(5, "Бублик"));
        assertFalse(i.changeName(8, "Кек"));

        assertEquals(check, i.mapOfProducts);
    }

    @org.junit.Test
    public void changePrice() {
        final Map<Integer, Product> check = new HashMap<>();
        check.put(2, new Product(45, 34,"Марс"));
        check.put(1, new Product(45, 55,"Марс2"));
        check.put(3, new Product(32, 45,"Марс3"));
        check.put(6, new Product(41, 3,"Марс6"));
        check.put(5, new Product(11, 11,"Марс5"));
        check.put(4, new Product(78, 22,"Марс4"));


        final ProductList i = new ProductList();
        i.add(2, new Product(45, 34,"Марс"));
        i.add(1, new Product(21, 11,"Марс2"));
        i.add(3, new Product(99, 5,"Марс3"));
        i.add(6, new Product(41, 3,"Марс6"));
        i.add(4, new Product(78, 22,"Марс4"));
        i.add(5, new Product(11, 11,"Марс5"));

        assertTrue(i.changePrice(1, 45,55));
        assertTrue(i.changePrice(3, 32,45));
        assertFalse(i.changePrice(9, 32,45));

        assertEquals(check, i.mapOfProducts);


    }

    @org.junit.Test
    public void getPrice() {
        final ProductList i = new ProductList();
        i.add(2, new Product(34, 55,"Марс"));
        i.add(1, new Product(68, 11,"Марс2"));

        assertEquals(310.95, i.getPrice(2, 9), 0.01);
        assertEquals(3064.95, i.getPrice(1, 45), 0.01);

    }




}


