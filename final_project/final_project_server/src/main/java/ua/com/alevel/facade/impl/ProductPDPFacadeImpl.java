package ua.com.alevel.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.api.data.response.product.ProductPDPData;
import ua.com.alevel.facade.ProductPDPFacade;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.service.product.ProductService;
import ua.com.alevel.service.product.ProductVariantService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductPDPFacadeImpl implements ProductPDPFacade {

    private final ProductService productService;
    private final ProductVariantService productVariantService;

    @Override
    public ProductPDPData findById(Long id) {
        Product product = productService.findById(id);
        Collection<ProductVariant> productVariants = productVariantService.findAllByProduct(product);
        return new ProductPDPData(product, productVariants);
    }
}
