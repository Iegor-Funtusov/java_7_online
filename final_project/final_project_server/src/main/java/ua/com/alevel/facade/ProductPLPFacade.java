package ua.com.alevel.facade;

import ua.com.alevel.api.data.response.ProductPLPData;

import java.util.Collection;

public interface ProductPLPFacade {

    Collection<ProductPLPData> getProducts();
}
