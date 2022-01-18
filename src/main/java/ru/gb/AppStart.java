package ru.gb;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppStart {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Cart cart = context.getBean(Cart.class);
        cart.addProductToCart(2);
        cart.addProductToCart(4);
        cart.addProductToCart(5);
        cart.addProductToCart(1);
        cart.showAllProductsInCart();
        cart.deleteProductFromCart(4);
        cart.showAllProductsInCart();
        cart.addProductToCart(10);
        cart.deleteProductFromCart(10);
    }
}
