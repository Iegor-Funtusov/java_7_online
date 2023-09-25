package ua.com.alevel.service.product;

import ua.com.alevel.persistence.entity.product.Product;

import java.util.Collection;

public interface ProductService {

    Collection<Product> findAll();
}
