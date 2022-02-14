package ru.gb.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springdata.entity.Product;


import java.util.Optional;

public interface RepositoryDao extends JpaRepository<Product, Long> {

    Optional<Product> findProductById(Long id);
    void deleteProductById(Long id);


}
