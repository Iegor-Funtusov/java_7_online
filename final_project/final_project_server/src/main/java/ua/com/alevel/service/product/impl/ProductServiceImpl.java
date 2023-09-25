package ua.com.alevel.service.product.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.repository.product.ProductRepository;
import ua.com.alevel.service.product.ProductService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Collection<Product> findAll() {
        return productRepository.findAll();
    }
}
