package ua.com.alevel.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.api.data.request.product.ProductRequestDto;
import ua.com.alevel.api.data.response.product.ProductResponseDto;
import ua.com.alevel.facade.ProductFacade;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.service.product.ProductService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;

    @Override
    public void create(ProductRequestDto dto) {
        Product product = new Product();
        product.setDescription(dto.getDescription());
        product.setName(dto.getName());
        product.setProductBrand(dto.getProductBrand());
        productService.create(product);
    }

    @Override
    public void update(ProductRequestDto dto, Long id) {
        Product product = productService.findById(id);
        product.setDescription(dto.getDescription());
        product.setName(dto.getName());
        product.setProductBrand(dto.getProductBrand());
        productService.update(product);
    }

    @Override
    public ProductResponseDto findById(Long id) {
        return new ProductResponseDto(productService.findById(id));
    }

    @Override
    public Collection<ProductResponseDto> findAll() {
        return productService.findAll().stream().map(ProductResponseDto::new).toList();
    }
}
