package ru.gb;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> productList = new ArrayList();

    public ProductRepository() {
        productList.add(new Product(1, "apple", 100.99D));
        productList.add(new Product(2, "fish", 300.99D));
        productList.add(new Product(3, "meat", 470.99D));
        productList.add(new Product(4, "tomato", 120.99D));
        productList.add(new Product(5, "tea", 300.99D));
        productList.add(new Product(6, "coffee", 400.99D));
        productList.add(new Product(7, "bread", 50.99D));
    }

    public List<Product> getAllProductFromRepository() {
        return productList;
    }

    public Product getProductFromRepository(int id) {

        for (Product product: productList) {
            if (id == product.getId()){
                return product;
            }
        }
        return null;

    }
}
