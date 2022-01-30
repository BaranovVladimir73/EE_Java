package ru.gb.repository;

import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {

    List<Product> productList = new ArrayList<>();


    public List<Product> showAllProducts(){
        return new ArrayList<>(productList);
    }

    public Optional<Product> findProductById(int id){

        for (Product product:productList) {
            if (product.getId() == id){
                return Optional.of(productList.get(id));
            }
        }
        return Optional.empty();
    }

    public void addProductToRepository(Product product){
        productList.add(product);
    }
}
