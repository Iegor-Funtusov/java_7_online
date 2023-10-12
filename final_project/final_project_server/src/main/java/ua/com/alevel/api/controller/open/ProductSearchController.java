package ua.com.alevel.api.controller.open;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.api.data.response.ResponseData;
import ua.com.alevel.elastic.document.ProductIndex;
import ua.com.alevel.service.search.ProductSearchService;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/api/open/products/search")
public class ProductSearchController {

    private final ProductSearchService productSearchService;

    @GetMapping
    public ResponseEntity<ResponseData<Collection<ProductIndex>>> search(@RequestParam String query) {
        return ResponseEntity.ok(new ResponseData<>(productSearchService.search(query)));
    }
}
