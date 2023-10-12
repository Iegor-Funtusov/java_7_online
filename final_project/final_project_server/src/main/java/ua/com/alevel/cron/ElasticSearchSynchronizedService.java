package ua.com.alevel.cron;

import lombok.AllArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.com.alevel.elastic.document.ProductIndex;
import ua.com.alevel.elastic.repository.ProductIndexRepository;
import ua.com.alevel.persistence.dto.product.ProductVariantMinDto;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.repository.product.ProductVariantRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class ElasticSearchSynchronizedService {

    private final ProductIndexRepository productIndexRepository;
    private final ProductVariantRepository productVariantRepository;
    private final ElasticsearchOperations elasticsearchOperations;

//    @Scheduled(cron = "*/10 * * * * *")
    public void synchronizedDocuments() {
        System.out.println("ElasticSearchSynchronizedService.synchronizedDocuments");
        elasticsearchOperations.indexOps(ProductIndex.class).refresh();
        productIndexRepository.deleteAll();
        productIndexRepository.saveAll(generateProductIndices());
        System.out.println("ElasticSearchSynchronizedService.finish");
    }

    private Collection<ProductIndex> generateProductIndices() {
        Collection<ProductVariantMinDto> productVariants = productVariantRepository.findAllProductVariantMinDtoList();
        List<ProductIndex> productIndices = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(productVariants)) {
            productIndices = productVariants
                    .stream()
                    .map(pv -> {
                        ProductIndex productIndex = new ProductIndex();
                        StringBuilder sb = new StringBuilder();
                        Product product = pv.product();
                        if (product != null) {
                            sb.append(product.getName());
                            sb.append(", ");
                            sb.append(pv.color());
                            sb.append(", ");
                            sb.append(pv.cpu());
                            productIndex.setPId(product.getId());
                        }
                        productIndex.setProductInfo(sb.toString());
                        productIndex.setPvId(pv.pvId());
                        return productIndex;
                    })
                    .toList();
        }
        return productIndices;
    }
}
