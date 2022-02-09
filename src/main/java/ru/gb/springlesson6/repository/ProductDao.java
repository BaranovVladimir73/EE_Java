package ru.gb.springlesson6.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.springlesson6.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
@Component
public class ProductDao implements RepositoryDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Product> showAllProducts() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void deleteProductById(Long id) {
        Product savedProduct = findById(id);
        entityManager.remove(savedProduct);
    }

    @Override
    public Product editProduct(Product product) {
        entityManager.merge(product);
        return product;
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> query = entityManager.createNamedQuery("Product.findById", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
