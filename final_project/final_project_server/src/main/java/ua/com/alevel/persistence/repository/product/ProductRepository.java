package ua.com.alevel.persistence.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.repository.BaseRepository;

@Repository
public interface ProductRepository extends BaseRepository<Product> { }
