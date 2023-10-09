package ua.com.alevel.persistence.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.persistence.repository.BaseRepository;

import java.util.Collection;

@Repository
public interface ProductVariantRepository extends BaseRepository<ProductVariant> {

    Collection<ProductVariant> findAllByProduct(Product product);
}
