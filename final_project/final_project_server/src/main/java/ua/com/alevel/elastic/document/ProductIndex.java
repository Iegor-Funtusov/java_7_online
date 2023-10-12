package ua.com.alevel.elastic.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "productindex")
public class ProductIndex {

    @Id
    private String id;

    @Field(name = "productInfo", type = FieldType.Text)
    private String productInfo;

    @Field(name = "pvId", type = FieldType.Long)
    private Long pvId;

    @Field(name = "pId", type = FieldType.Long)
    private Long pId;
}
