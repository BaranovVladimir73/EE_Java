package ru.gb;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private ProductRepository repository;
    private List<Product> productListInCart;

    public Cart(ProductRepository repository) {
        this.repository = repository;
        productListInCart = new ArrayList();
    }

    public void addProductToCart(int id) {
        if (repository.getProductFromRepository(id) != null) {
            Product product = repository.getProductFromRepository(id);
            productListInCart.add(product);
        } else {
            System.out.println("Этого продукта нет на складе");
        }

    }

    public void deleteProductFromCart(int id) {

        for (Product product: productListInCart) {
            if (product.getId() == id){
                productListInCart.remove(product);
                return;
            }
        }
        System.out.println("Этого продукта нет в корзине");

    }

    public void showAllProductsInCart() {
        System.out.println("Корзина содержит следующие продукты:");

        for (Product product: productListInCart) {
            System.out.println(product.toString());
        }

    }

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductRepository getRepository() {
        return repository;
    }
}
