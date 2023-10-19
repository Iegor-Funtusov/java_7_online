package ua.com.alevel.service.search.impl;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.com.alevel.elastic.document.QuerySearch;
import ua.com.alevel.elastic.repository.QuerySearchRepository;
import ua.com.alevel.service.search.QuerySearchService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class QuerySearchServiceImpl implements QuerySearchService {

    private final QuerySearchRepository querySearchRepository;

    @Override
    public void save(String query) {
        if (StringUtils.isNotBlank(query) && !querySearchRepository.existsByQuery(query)) {
            QuerySearch querySearch = new QuerySearch();
            querySearch.setQuery(query);
            querySearchRepository.save(querySearch);
        }
    }

    @Override
    public Collection<QuerySearch> findAll(int page, int size) {
        return querySearchRepository.findAll(PageRequest.of(page - 1, size)).getContent();
    }
}
