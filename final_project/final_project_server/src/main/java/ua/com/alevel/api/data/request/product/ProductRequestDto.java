package ua.com.alevel.api.data.request.product;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.api.data.request.RequestDto;
import ua.com.alevel.persistence.type.BrandType;

@Getter
@Setter
public class ProductRequestDto extends RequestDto {
    private String name;
    private String description;
    private BrandType productBrand;
}
