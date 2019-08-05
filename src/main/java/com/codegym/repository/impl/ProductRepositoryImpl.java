package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private static List<Product> productList;

    {
        productList = new ArrayList<>();
        productList.add(new Product(0, "May tinh", 1000.5, "phuc vu cong viec", "Cong Ty MT"));
        productList.add(new Product(1, "May in", 1200.5, "photo tai lieu", "Cong Ty MI"));
        productList.add(new Product(2, "Dien thoai", 2000.5, "goi dien", "Cong Ty DT"));
        productList.add(new Product(3, "Dieu hoa", 3300.5, "lam mat", "Cong Ty DH"));
        productList.add(new Product(4, "Tu lanh", 1400.5, "luu tru thuc pham", "Cong Ty TL"));
        productList.add(new Product(5, "Bong dien", 100.5, "phat sang", "Cong Ty BD"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int id, Product product) {
        int index = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                index = i;
                break;
            }
        }
        productList.set(index, product);
    }

    @Override
    public void remove(int id) {
        Product product = this.findById(id);
        productList.remove(product);

    }

    @Override
    public Product findById(int id) {
        int index = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return productList.get(index);
    }

    @Override
    public Product findByName(String name) {
        for (Product product : productList) {
            String temp = product.getName();
            if (temp.equals(name)) {
                return product;
            }
        }
        return null;
    }
}
