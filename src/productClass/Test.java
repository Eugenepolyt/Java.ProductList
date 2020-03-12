package productClass;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;



public class Test {
    @org.junit.Test
    public void addProduct() {
        final ProductList i = new ProductList();

        final Map<Integer, Product> check = new HashMap<>();
        check.put(1, new Product(new BigDecimal("1.47"),"марсианен"));
        check.put(2, new Product(new BigDecimal("1.47"),"марсиане"));


        assertNull(i.add(1, new Product(new BigDecimal("1.47"), "марс")));
        assertEquals(new Product(new BigDecimal("1.47"), "марс"), i.add(1, new Product(new BigDecimal("1.47"),"марсианен")));
        assertNull(i.add(2, new Product(new BigDecimal("1.47"),"марсиане")));


        assertEquals(check, i.mapOfProducts);



    }
    @org.junit.Test
    public void deleteProduct() {
        final ProductList i = new ProductList();
        final Map<Integer, Product> check = new HashMap<>();

        check.put(1, new Product(new BigDecimal("1.47"),"марсианен"));
        check.put(2, new Product(new BigDecimal("1.47"),"марсиане"));


        i.add(1, new Product(new BigDecimal("1.47"),"марсианен"));
        i.add(2, new Product(new BigDecimal("1.47"),"марсиане"));
        i.add(3, new Product(new BigDecimal("1.47"),"марсианенцы"));
        i.add(4, new Product(new BigDecimal("1.47"),"марсианец"));

        assertEquals(new Product(new BigDecimal("1.47"),"марсианенцы"), i.delete(3));
        i.delete(4);


        assertEquals(check, i.mapOfProducts);

    }

    @org.junit.Test
    public void changeName() {
        final ProductList i = new ProductList();

        final Map<Integer, Product> check = new HashMap<>();
        check.put(1, new Product(new BigDecimal("1.47"),"марсианен"));
        check.put(2, new Product(new BigDecimal("1.47"),"Кекс"));
        check.put(3, new Product(new BigDecimal("5.22"),"бублик"));
        check.put(4, new Product(new BigDecimal("5.24"),"марс"));

        i.add(1, new Product(new BigDecimal("1.47"),"марсианен"));
        i.add(2, new Product(new BigDecimal("1.47"),"марсиане"));
        i.add(3, new Product(new BigDecimal("5.22"),"твикс"));
        i.add(4, new Product(new BigDecimal("5.24"),"марс"));

        assertTrue(i.changeName(2, "Кекс"));
        assertTrue(i.changeName(3, "бублик"));
        assertFalse(i.changeName(8, "Кек"));

        assertEquals(check, i.mapOfProducts);
    }

    @org.junit.Test
    public void changePrice() {
        final ProductList i = new ProductList();

        final Map<Integer, Product> check = new HashMap<>();
        check.put(1, new Product(new BigDecimal("44.55"),"марсианен"));
        check.put(2, new Product(new BigDecimal("1.47"),"Кекс"));
        check.put(3, new Product(new BigDecimal("32.45"),"бублик"));
        check.put(4, new Product(new BigDecimal("5.24"),"марс"));

        i.add(1, new Product(new BigDecimal("1.47"),"марсианен"));
        i.add(2, new Product(new BigDecimal("1.47"),"Кекс"));
        i.add(3, new Product(new BigDecimal("5.2"),"бублик"));
        i.add(4, new Product(new BigDecimal("5.24"),"марс"));

        assertTrue(i.changePrice(1, new BigDecimal("44.55")));
        assertTrue(i.changePrice(3, new BigDecimal("32.45")));
        assertFalse(i.changePrice(9, new BigDecimal("45.45")));

        assertEquals(check, i.mapOfProducts);


    }

    @org.junit.Test
    public void getPrice() {
        final ProductList i = new ProductList();
        i.add(2, new Product(new BigDecimal("34.55"),"Марс"));
        i.add(1, new Product(new BigDecimal("68.11"),"Марс2"));

        assertEquals(new BigDecimal("310.95"), i.getPrice(2, 9));
        assertEquals(new BigDecimal("3064.95"), i.getPrice(1, 45));
    }




}


