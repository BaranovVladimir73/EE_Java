package ru.gb.javarest.dao;

import org.springframework.stereotype.Repository;
import ru.gb.javarest.entity.Product;


import java.util.ArrayList;
import java.util.List;


@Repository
public class Cart {

    private List<Product> cartList = new ArrayList<>();

    public void addProduct(Product product){
        cartList.add(product);
        System.out.println(cartList.toString());
    }



    public void deleteProductById(int id){

        cartList.remove(id-1);

    }

    public List<Product> getCartList(){
        return cartList;
    }



}
