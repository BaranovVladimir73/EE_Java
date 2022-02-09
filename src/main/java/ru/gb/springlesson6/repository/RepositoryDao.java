package ru.gb.springlesson6.repository;

import ru.gb.springlesson6.entity.Product;

public interface RepositoryDao {

    Iterable<Product> showAllProducts();
    void addProduct(Product product);
    void deleteProductById(Long id);
    Product editProduct(Product product);
    Product findById(Long id);
}
