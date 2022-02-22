package ru.gb.javarest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.javarest.dao.Cart;
import ru.gb.javarest.dao.ProductDao;
import ru.gb.javarest.dto.ProductDto;
import ru.gb.javarest.entity.Product;
import ru.gb.javarest.entity.enums.Status;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductDao productDao;
    private final Cart cart;

    public ProductDto save(ProductDto productDto) {
        Product savingProduct;
        Optional<Product> productFromDbOptional = Optional.empty();
        if (productDto.getId() != null) {
            productFromDbOptional = productDao.findById(productDto.getId());
        }
        savingProduct = productFromDbOptional.orElseGet(Product::new);
        savingProduct.setTitle(productDto.getTitle());
        savingProduct.setDate(productDto.getDate());
        savingProduct.setCost(productDto.getCost());
        savingProduct.setStatus(productDto.getStatus());

        savingProduct = productDao.save(savingProduct);
        productDto.setId(savingProduct.getId());
        return productDto;
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void deleteById(Long id) {
        try {
            productDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("There isn't product with id {}", id);
        }

    }

    public void addProductToCart(Product product){
        cart.addProduct(product);
    }

    public void deleteProductFromCart(int id){

        cart.deleteProductById(id);

    }


    public List<Product> showAllProductFromCart(){
        return cart.getCartList();
    }







    public void disableById(Long id) {
        productDao.findById(id).ifPresent(
                p -> {
                    p.setStatus(Status.DISABLE);
                    productDao.save(p);
                }
        );
    }

    public List<Product> findAllActive() {
        return productDao.findAllByStatus(Status.ACTIVE);
    }


    public List<Product> findAllActive(int page, int size) {
        return productDao.findAllByStatus(Status.ACTIVE, PageRequest.of(page, size));
    }

    public List<Product> findAllActiveSortedById(Sort.Direction direction) {
        return productDao.findAllByStatus(Status.ACTIVE, Sort.by(direction, "id"));
    }

    public List<Product> findAllActiveSortedById(int page, int size, Sort.Direction direction) {
        return productDao.findAllByStatus(Status.ACTIVE, PageRequest.of(page, size, Sort.by(direction, "id")));
    }

    @Transactional(propagation = Propagation.NEVER)
    public long count() {
        System.out.println(productDao.count());
        // какая-то логика
        return productDao.count();
    }
}
