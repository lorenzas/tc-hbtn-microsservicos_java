package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Integer id) {
        return list.stream().filter(product -> id.equals(Math.toIntExact(product.getId()))).findFirst().orElse(null);
    }

    public void addProduct(Product s) {
        list.add(s);
    }

    public void updateProduct(Product s) {
        Product product = getProductById(Math.toIntExact(s.getId()));
        Collections.replaceAll(list, product, s);
    }

    public void removeProduct(Product s) {
        list.remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        listOfProducts.forEach(product -> addProduct(product));
    }
}