package ua.com.alevel.service.search.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.elastic.document.ProductIndex;
import ua.com.alevel.elastic.repository.ProductIndexRepository;
import ua.com.alevel.service.search.ProductSearchService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductSearchServiceImpl implements ProductSearchService {

    private final ProductIndexRepository productIndexRepository;

    @Override
    public Collection<ProductIndex> search(String query) {
        return productIndexRepository.findFirst10ByProductInfoContainsIgnoreCase(query);
    }
}
