package ua.com.alevel.elastic.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "querysearch")
public class QuerySearch {

    @Id
    private String id;

    @Field(name = "query", type = FieldType.Text)
    private String query;
}
