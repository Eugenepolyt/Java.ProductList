import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class test {
    @Test
    public void addProduct() {
        final ProductList i = new ProductList();
        assertTrue(i.add("Марс", new Product(55, 47,1)));
        assertFalse(i.add("Марс", new Product(55, 45,1)));
        assertTrue(i.add("Твикс", new Product(11, 17,1)));
        assertFalse(i.add("Марс", new Product(55, 47,1)));
        assertTrue(i.add("бубик", new Product(33, 13,1)));
    }

    @Test
    public void deleteProduct() {
        final ProductList i = new ProductList();
        i.add("Марс", new Product(68, 11,1));
        i.add("Марс3", new Product(68, 11,1));
        assertFalse(i.delete("Кек"));
        assertTrue(i.delete("Марс"));
        assertFalse(i.delete("Марс"));
        System.out.println(i.getMap());
    }

    @Test
    public void changeNBN() {
        final ProductList i = new ProductList();
        i.add("Марс", new Product(68, 11,1));
        i.add("Твикс", new Product(68, 11,1));
        HashMap<String, Product> map = new HashMap<String, Product>();
        Product prod = new Product(68,11,0);
        Product prod2 = new Product(68,11,1);
        map.put("Марс", prod);
        map.put("Сникерс", prod2);
        i.changeNameByName("Твикс", "Сникерс");
        assertFalse(i.changeNameByName("Не существует", "Аа"));
        assertEquals(map, i.getMap());
    }

    @Test
    public void changePBN() {
        final ProductList i = new ProductList();
        i.add("Марс", new Product(68, 11,1));
        i.add("Твикс", new Product(68, 11,1));
        HashMap<String, Product> map = new HashMap<String, Product>();
        Product prod = new Product(68,11,0);
        Product prod2 = new Product(65,22,1);
        map.put("Марс", prod);
        map.put("Твикс", prod2);
        i.changePriceByName("Твикс", new Product(65,22,5));
        assertFalse(i.changePriceByName("323", new Product(11,23,3)));
        assertEquals(map, i.getMap());
    }

    @Test
    public void changeNBNum() {
        final ProductList i = new ProductList();
        i.add("Марс", new Product(68, 11,1));
        i.add("Твикс", new Product(68, 11,1));
        HashMap<String, Product> map = new HashMap<String, Product>();
        Product prod = new Product(68,11,0);
        Product prod2 = new Product(68,11,1);
        map.put("Киткат", prod);
        map.put("Твикс", prod2);
        assertFalse(i.changeNameByNumber(44, "rt"));
        i.changeNameByNumber(0, "Киткат");
        assertEquals(map, i.getMap());
    }
    @Test
    public void changePBNum() {
        final ProductList i = new ProductList();
        i.add("Марс", new Product(68, 11,1));
        i.add("Твикс", new Product(68, 11,1));
        HashMap<String, Product> map = new HashMap<String, Product>();
        Product prod = new Product(68,11,0);
        Product prod2 = new Product(65,22,1);
        map.put("Марс", prod);
        map.put("Твикс", prod2);
        assertFalse(i.changePriceByNumber(44, new Product(11,23,3)));
        i.changePriceByNumber(1, new Product(65,22,5));
        assertEquals(map, i.getMap());
    }

    @Test
    public void getPrice() {
        final ProductList i = new ProductList();
        i.add("Марс", new Product(45, 20,1));
        i.add("Твикс", new Product(68, 30,1));
        i.add("Кекс", new Product(1, 55,1));
        i.add("Сникерс", new Product(5, 10,1));
        i.add("Жвачка", new Product(10, 20,1));
        i.add("Яйца", new Product(30, 67,1));
        i.delete("Кекс");
        i.add("Кекс", new Product(1, 55,1));
        assertEquals(226.0, i.getPrice(0, 5), 0.01);
        assertEquals(4.65, i.getPrice(6, 3), 0.01);
        assertEquals(406.8, i.getPrice(0, 9), 0.01);
        assertEquals(61.2, i.getPrice(4, 6), 0.01);


    }



}


