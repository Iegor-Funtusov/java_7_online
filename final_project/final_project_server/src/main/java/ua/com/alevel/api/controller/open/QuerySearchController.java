package ua.com.alevel.api.controller.open;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.api.data.response.ResponseData;
import ua.com.alevel.elastic.document.QuerySearch;
import ua.com.alevel.service.search.QuerySearchService;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/api/open/queries")
public class QuerySearchController {

    private final QuerySearchService querySearchService;

    @GetMapping
    public ResponseEntity<ResponseData<Collection<QuerySearch>>> find(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(new ResponseData<>(querySearchService.findAll(page, size)));
    }
}
