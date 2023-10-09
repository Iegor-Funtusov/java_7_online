package ua.com.alevel.facade;

import ua.com.alevel.api.data.response.product.ProductPDPData;

public interface ProductPDPFacade {

    ProductPDPData findById(Long id);
}
