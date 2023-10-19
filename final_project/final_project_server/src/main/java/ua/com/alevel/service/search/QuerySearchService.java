package ua.com.alevel.service.search;

import ua.com.alevel.elastic.document.QuerySearch;

import java.util.Collection;

public interface QuerySearchService {

    void save(String query);
    Collection<QuerySearch> findAll(int page, int size);
}
