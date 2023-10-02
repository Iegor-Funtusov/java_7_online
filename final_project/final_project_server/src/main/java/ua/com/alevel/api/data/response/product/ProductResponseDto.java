package ua.com.alevel.api.data.response.product;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.api.data.response.ResponseDto;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.type.BrandType;

@Getter
@Setter
public class ProductResponseDto extends ResponseDto {
    private String name;
    private String description;
    private BrandType productBrand;

    public ProductResponseDto(Product product) {
        super.setId(product.getId());
        this.name = product.getName();
        this.description = product.getDescription();
        this.productBrand = product.getProductBrand();
    }
}
