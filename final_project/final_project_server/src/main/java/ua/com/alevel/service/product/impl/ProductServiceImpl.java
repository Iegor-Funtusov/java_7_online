package ua.com.alevel.service.product.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.exception.EntityNotFoundException;
import ua.com.alevel.exception.NotValidDataException;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.repository.product.ProductRepository;
import ua.com.alevel.service.product.ProductService;
import ua.com.alevel.util.ExceptionUtil;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void create(Product entity) {
        isValidProduct(entity);
        productRepository.save(entity);
    }

    @Override
    public void update(Product entity) {
        isValidProduct(entity);
        isValidId(entity.getId());
        productRepository.save(entity);
    }

    @Override
    public Product findById(Long id) {
        isValidId(id);
        return productRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.ENTITY_IS_NOT_PRESENT));
    }

    @Override
    public Collection<Product> findAll() {
        return productRepository.findAll();
    }

    private void isValidProduct(Product product) {
        if (product == null) {
            throw new NotValidDataException(ExceptionUtil.PRODUCT_IS_NOT_PRESENT);
        }
        if (product.getName() == null) {
            throw new NotValidDataException(ExceptionUtil.PRODUCT_NAME_IS_NOT_PRESENT);
        }
        if (product.getProductBrand() == null) {
            throw new NotValidDataException(ExceptionUtil.PRODUCT_BRAND_IS_NOT_PRESENT);
        }
    }

    private void isValidId(Long id) {
        if (id == null) {
            throw new EntityNotFoundException(ExceptionUtil.ENTITY_ID_IS_NOT_PRESENT);
        }
    }
}
