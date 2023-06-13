package com.example.controllers.Add;

import com.example.tables.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AddProductControllerTest {
    @Test
    void nullNameProduct() {
        AddProductController addProduct = new AddProductController();
        Product product = new Product("", 1, 9, "no");
        assertEquals(product, addProduct.newProd("", "1", "no", "9"));
    }
    @Test
    void nullIdUnit() {
        AddProductController addProduct = new AddProductController();
        Product product = new Product("a", 0, 9, "no");
        assertEquals(product, addProduct.newProd("a", "0", "no", "9"));
    }
    @Test
    void nullCount() {
        AddProductController addProduct = new AddProductController();
        Product product = new Product("a", 1, 0, "no");
        assertEquals(product, addProduct.newProd("a", "1", "no", "0"));
    }
    @Test
    void nullDes() {
        AddProductController addProduct = new AddProductController();
        Product product = new Product("b", 1, 9, "");
        assertEquals(product, addProduct.newProd("b", "1", "", "9"));
    }
    @Test
    void fNameProduct() {
        AddProductController addProduct = new AddProductController();
        assertNull(addProduct.newProd("@", "1", "no", "9"));
    }
    @Test
    void fIdUnit() {
        AddProductController addProduct = new AddProductController();
        assertNull(addProduct.newProd("a", "", "no", "9"));
    }
    @Test
    void fCount() {
        AddProductController addProduct = new AddProductController();
        assertNull(addProduct.newProd("a", "1", "no", "f"));
    }
    @Test
    void fDes() {
        AddProductController addProduct = new AddProductController();
        assertNull(addProduct.newProd("b", "1", "+7", "9"));
    }
    @Test
    void TestNameProduct() {
        AddProductController addProduct = new AddProductController();
        Product product = new Product("apple", 1, 9, "no");
        assertEquals(product, addProduct.newProd("apple", "1", "no", "9"));
    }
}