package ua.com.alevel.api.data.response;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductImage;

import java.util.ArrayList;
import java.util.Set;

@Getter
@Setter
public class ProductPLPData {

    private Long id;
    private String brand;
    private String name;
    private String image;
//    private String price;

    public ProductPLPData(Product product) {
        this.id = product.getId();
        this.brand = product.getProductBrand().getBrand();
        this.name = product.getName();
        Set<ProductImage> productImages = product.getProductImages();
        if (CollectionUtils.isNotEmpty(productImages)) {
            ProductImage productImage = productImages
                    .stream()
                    .filter(ProductImage::getMainImage)
                    .findFirst()
                    .orElse(new ArrayList<>(productImages).get(0));
            this.image = productImage.getImageUrl();
        }
    }
}
