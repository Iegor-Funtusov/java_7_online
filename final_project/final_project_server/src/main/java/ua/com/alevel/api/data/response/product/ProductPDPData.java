package ua.com.alevel.api.data.response.product;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.entity.product.ProductDisplay;
import ua.com.alevel.persistence.entity.product.ProductImage;
import ua.com.alevel.persistence.entity.product.ProductVariant;
import ua.com.alevel.persistence.type.DisplayType;
import ua.com.alevel.persistence.type.OsType;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProductPDPData {

    private Long id;
    private String name;
    private String productBrand;
    private String description;
    private Double height;
    private Double width;
    private Double depth;
    private Double weight;
    private String battery;
    private Set<String> images;
    private Set<String> osList;
    private Set<String> cpuList;
    private Set<Integer> ramList;
    private Set<Integer> ssdList;
    private Set<String> colorList;
    private Set<String> cameraList;
    private Set<String> displayResolutionList;
    private Set<String> displaySizeList;
    private Set<String> displayTypeList;

    public ProductPDPData(Product product, Collection<ProductVariant> variants) {
        this.id = product.getId();
        this.name = product.getName();
        this.productBrand = product.getProductBrand().getBrand();
        this.description = product.getDescription();
        Set<ProductImage> productImages = product.getProductImages();
        if (CollectionUtils.isNotEmpty(productImages)) {
            this.images = productImages.stream().map(ProductImage::getImageUrl).collect(Collectors.toSet());
        }
        if (CollectionUtils.isNotEmpty(variants)) {
            this.height = variants.stream().map(ProductVariant::getHeight).findFirst().get();
            this.width = variants.stream().map(ProductVariant::getWidth).findFirst().get();
            this.depth = variants.stream().map(ProductVariant::getDepth).findFirst().get();
            this.weight = variants.stream().map(ProductVariant::getWeight).findFirst().get();
            this.battery = variants.stream().map(ProductVariant::getBattery).findFirst().get();
            this.osList = variants.stream().map(ProductVariant::getOs).map(OsType::getType).collect(Collectors.toSet());
            this.cpuList = variants.stream().map(ProductVariant::getCpu).collect(Collectors.toSet());
            this.ramList = variants.stream().map(ProductVariant::getRam).collect(Collectors.toSet());
            this.ssdList = variants.stream().map(ProductVariant::getSsd).collect(Collectors.toSet());
            this.colorList = variants.stream().map(ProductVariant::getColor).collect(Collectors.toSet());
            this.cameraList = variants.stream().map(ProductVariant::getCamera).collect(Collectors.toSet());
            Set<ProductDisplay> displays = variants.stream().map(ProductVariant::getProductDisplay).collect(Collectors.toSet());
            if (CollectionUtils.isNotEmpty(displays)) {
                this.displayResolutionList = displays.stream().map(ProductDisplay::getDisplayResolution).collect(Collectors.toSet());
                this.displaySizeList = displays.stream().map(ProductDisplay::getDisplaySize).collect(Collectors.toSet());
                this.displayTypeList = displays.stream().map(ProductDisplay::getDisplayType).map(DisplayType::name).collect(Collectors.toSet());
            }
        }
    }
}
