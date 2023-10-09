package ua.com.alevel.service.product.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.persistence.repository.product.ProductVariantRepository;
import ua.com.alevel.service.product.ProductVariantService;

import java.util.Collection;

@Service
@Transactional
@AllArgsConstructor
public class ProductVariantServiceImpl implements ProductVariantService {

    private ProductVariantRepository productVariantRepository;

    @Override
    public void create(ProductVariant entity) {

    }

    @Override
    public void update(ProductVariant entity) {

    }

    @Override
    public ProductVariant findById(Long id) {
        return null;
    }

    @Override
    public Collection<ProductVariant> findAll() {
        return null;
    }

    @Override
    public Collection<ProductVariant> findAllByProduct(Product product) {
        return productVariantRepository.findAllByProduct(product);
    }
}
