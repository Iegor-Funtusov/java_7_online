package ua.com.alevel.persistence.repository.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.dto.product.ProductVariantMinDto;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.persistence.repository.BaseRepository;

import java.util.Collection;

@Repository
public interface ProductVariantRepository extends BaseRepository<ProductVariant> {

    Collection<ProductVariant> findAllByProduct(Product product);

    @Query(value = "select distinct new ua.com.alevel.persistence.dto.product.ProductVariantMinDto(pv.product, pv.color, pv.cpu, pv.id) from ProductVariant  as pv")
    Collection<ProductVariantMinDto> findAllProductVariantMinDtoList();
}
