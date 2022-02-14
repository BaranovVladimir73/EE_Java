package ru.gb.springdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.springdata.entity.Product;
import ru.gb.springdata.repository.RepositoryDao;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final RepositoryDao repositoryDao;

    @Transactional(readOnly = true)
    public List<Product> findAll(Sort sort) {
        return repositoryDao.findAll(sort);
    }


    public Product save(Product product){
        if (product.getId() != null) {
            Optional<Product> productFromDbOptional = repositoryDao.findById(product.getId());
            if (productFromDbOptional.isPresent()) {
                Product productFromDb = productFromDbOptional.get();
                productFromDb.setTitle(product.getTitle());
                productFromDb.setCost(product.getCost());
                productFromDb.setCreatedBy(product.getCreatedBy());
                productFromDb.setCreatedDate(product.getCreatedDate());
                productFromDb.setLastModifiedBy(product.getLastModifiedBy());
                productFromDb.setLastModifiedDate(product.getLastModifiedDate());
                return repositoryDao.save(productFromDb);
            }
        }
        return repositoryDao.save(product);
    }

    @Transactional(readOnly = true)
    public Product findById(Long id){
        return repositoryDao.findProductById(id).get();
    }
    @Transactional
    public void deleteProductById(Long id){
        repositoryDao.deleteProductById(id);
    }

}
