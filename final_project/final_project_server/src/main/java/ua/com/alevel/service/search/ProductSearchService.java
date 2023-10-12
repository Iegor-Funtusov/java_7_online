package ua.com.alevel.service.search;

import ua.com.alevel.elastic.document.ProductIndex;

import java.util.Collection;

public interface ProductSearchService {

    Collection<ProductIndex> search(String query);
}
