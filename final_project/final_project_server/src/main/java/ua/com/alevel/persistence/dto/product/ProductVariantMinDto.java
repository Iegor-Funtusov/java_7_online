package ua.com.alevel.persistence.dto.product;

import ua.com.alevel.persistence.entity.product.Product;

public record ProductVariantMinDto(Product product, String color, String cpu, Long pvId) { }
