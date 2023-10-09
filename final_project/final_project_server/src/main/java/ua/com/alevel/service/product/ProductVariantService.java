package ua.com.alevel.service.product;

import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.service.CrudService;

import java.util.Collection;

public interface ProductVariantService extends CrudService<ProductVariant> {
    Collection<ProductVariant> findAllByProduct(Product product);
}
