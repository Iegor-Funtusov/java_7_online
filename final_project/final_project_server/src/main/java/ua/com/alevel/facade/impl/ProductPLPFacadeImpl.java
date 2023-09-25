package ua.com.alevel.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.api.data.response.ProductPLPData;
import ua.com.alevel.facade.ProductPLPFacade;
import ua.com.alevel.service.product.ProductService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductPLPFacadeImpl implements ProductPLPFacade {

    private final ProductService productService;

    @Override
    public Collection<ProductPLPData> getProducts() {
        return productService.findAll().stream().map(ProductPLPData::new).toList();
    }
}
