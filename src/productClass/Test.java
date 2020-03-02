package productClass;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;



public class Test {
    @org.junit.Test
    public void addProduct() {
        final ProductList i = new ProductList();

        final Map<Integer, Product> check = new HashMap<>();
        check.put(1, new Product(new BigDecimal(1), new BigDecimal(47),"марсианен"));
        check.put(2, new Product(new BigDecimal(1), new BigDecimal(47),"марсиане"));



        assertEquals("Продукт добавлен",i.add(1, new Product(new BigDecimal(1), new BigDecimal(47),"марс")));
        assertEquals("Продукт заменен",i.add(1, new Product(new BigDecimal(1), new BigDecimal(47),"марсианен")));
        assertEquals("Продукт добавлен",i.add(2, new Product(new BigDecimal(1), new BigDecimal(47),"марсиане")));

        assertEquals(check, i.mapOfProducts);



    }

    @org.junit.Test
    public void deleteProduct() {
        final ProductList i = new ProductList();
        final Map<Integer, Product> check = new HashMap<>();
        check.put(2, new Product(new BigDecimal(45), new BigDecimal(34),"Кекс"));
        check.put(1, new Product(new BigDecimal(21), new BigDecimal(11),"Марс2"));
        check.put(6, new Product(new BigDecimal(41), new BigDecimal(3),"Марс6"));
        check.put(4, new Product(new BigDecimal(78), new BigDecimal(22),"Марс4"));

        i.add(2, new Product(new BigDecimal(45), new BigDecimal(34),"Кекс"));
        i.add(1, new Product(new BigDecimal(21), new BigDecimal(11),"Марс2"));
        i.add(3, new Product(new BigDecimal(32), new BigDecimal(45),"Марс3"));
        i.add(6, new Product(new BigDecimal(41), new BigDecimal(3),"Марс6"));
        i.add(4, new Product(new BigDecimal(78), new BigDecimal(22),"Марс4"));
        i.add(5, new Product(new BigDecimal(11), new BigDecimal(11),"Марс5"));

        assertEquals("Продукт удален",i.delete(3));
        assertEquals("Продукт удален",i.delete(5));
        assertEquals("Продукт не существует",i.delete(9));

        assertEquals(check, i.mapOfProducts);

    }

    @org.junit.Test
    public void changeName() {
        final ProductList i = new ProductList();

        final Map<Integer, Product> check = new HashMap<>();
        check.put(2, new Product(new BigDecimal(45), new BigDecimal(34),"Кекс"));
        check.put(1, new Product(new BigDecimal(21), new BigDecimal(11),"Марс2"));
        check.put(3, new Product(new BigDecimal(32), new BigDecimal(45),"Марс3"));
        check.put(6, new Product(new BigDecimal(41), new BigDecimal(3),"Марс6"));
        check.put(5, new Product(new BigDecimal(11), new BigDecimal(11),"Бублик"));
        check.put(4, new Product(new BigDecimal(78), new BigDecimal(22),"Марс4"));

        i.add(2, new Product(new BigDecimal(45), new BigDecimal(34),"Марс"));
        i.add(1, new Product(new BigDecimal(21), new BigDecimal(11),"Марс2"));
        i.add(3, new Product(new BigDecimal(32), new BigDecimal(45),"Марс3"));
        i.add(6, new Product(new BigDecimal(41), new BigDecimal(3),"Марс6"));
        i.add(4, new Product(new BigDecimal(78), new BigDecimal(22),"Марс4"));
        i.add(5, new Product(new BigDecimal(11), new BigDecimal(11),"Марс5"));

        assertTrue(i.changeName(2, "Кекс"));
        assertTrue(i.changeName(5, "Бублик"));
        assertFalse(i.changeName(8, "Кек"));

        assertEquals(check, i.mapOfProducts);
    }

    @org.junit.Test
    public void changePrice() {
        final Map<Integer, Product> check = new HashMap<>();
        check.put(2, new Product(new BigDecimal(45), new BigDecimal(34),"Марс"));
        check.put(1, new Product(new BigDecimal(45), new BigDecimal(55),"Марс2"));
        check.put(3, new Product(new BigDecimal(32), new BigDecimal(45),"Марс3"));
        check.put(6, new Product(new BigDecimal(41), new BigDecimal(3),"Марс6"));
        check.put(5, new Product(new BigDecimal(11), new BigDecimal(11),"Марс5"));
        check.put(4, new Product(new BigDecimal(78), new BigDecimal(22),"Марс4"));


        final ProductList i = new ProductList();
        i.add(2, new Product(new BigDecimal(45), new BigDecimal(34),"Марс"));
        i.add(1, new Product(new BigDecimal(21), new BigDecimal(11),"Марс2"));
        i.add(3, new Product(new BigDecimal(99), new BigDecimal(5),"Марс3"));
        i.add(6, new Product(new BigDecimal(41), new BigDecimal(3),"Марс6"));
        i.add(4, new Product(new BigDecimal(78), new BigDecimal(22),"Марс4"));
        i.add(5, new Product(new BigDecimal(11), new BigDecimal(11),"Марс5"));

        assertTrue(i.changePrice(1, new BigDecimal(45),new BigDecimal(55)));
        assertTrue(i.changePrice(3, new BigDecimal(32),new BigDecimal(45)));
        assertFalse(i.changePrice(9, new BigDecimal(45),new BigDecimal(45)));

        assertEquals(check, i.mapOfProducts);


    }

    @org.junit.Test
    public void getPrice() {
        final ProductList i = new ProductList();
        i.add(2, new Product(new BigDecimal(34), new BigDecimal(55),"Марс"));
        i.add(1, new Product(new BigDecimal(68), new BigDecimal(11),"Марс2"));

        assertEquals(new BigDecimal("310.95"), i.getPrice(2, 9));
        assertEquals(new BigDecimal("3064.95"), i.getPrice(1, 45));
    }




}


