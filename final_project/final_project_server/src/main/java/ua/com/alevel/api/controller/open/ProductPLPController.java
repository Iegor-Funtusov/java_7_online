package ua.com.alevel.api.controller.open;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.api.data.response.product.ProductPLPData;
import ua.com.alevel.api.data.response.ResponseData;
import ua.com.alevel.facade.ProductPLPFacade;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open/products")
public class ProductPLPController {

    private final ProductPLPFacade productPLPFacade;

    @GetMapping
    public ResponseEntity<ResponseData<Collection<ProductPLPData>>> getProducts() {
        return ResponseEntity.ok(new ResponseData<>(productPLPFacade.getProducts()));
    }
}
