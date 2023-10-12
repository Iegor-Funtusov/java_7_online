package ua.com.alevel.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.elastic.document.ProductIndex;

import java.util.List;

@Repository
public interface ProductIndexRepository extends ElasticsearchRepository<ProductIndex, String> {

    List<ProductIndex> findFirst10ByProductInfoContainsIgnoreCase(String query);
//    List<ProductIndex> findFirst10B
}
