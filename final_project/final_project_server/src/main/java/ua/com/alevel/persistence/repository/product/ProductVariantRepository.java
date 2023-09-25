package ua.com.alevel.persistence.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.persistence.repository.BaseRepository;

@Repository
public interface ProductVariantRepository extends BaseRepository<ProductVariant> { }
