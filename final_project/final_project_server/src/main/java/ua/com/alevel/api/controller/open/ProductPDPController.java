package ua.com.alevel.api.controller.open;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.api.data.response.ResponseData;
import ua.com.alevel.api.data.response.product.ProductPDPData;
import ua.com.alevel.facade.ProductPDPFacade;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/open/products/{id}")
public class ProductPDPController {

    private final ProductPDPFacade productPDPFacade;

    @GetMapping
    public ResponseEntity<ResponseData<ProductPDPData>> findProduct(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseData<>(productPDPFacade.findById(id)));
    }
}
