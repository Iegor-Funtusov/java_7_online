package ua.com.alevel.facade;

import ua.com.alevel.api.data.request.product.ProductRequestDto;
import ua.com.alevel.api.data.response.product.ProductResponseDto;

public interface ProductFacade extends CrudFacade<ProductRequestDto, ProductResponseDto> { }
