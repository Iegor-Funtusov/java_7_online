package ua.com.alevel.facade.product.integration;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.alevel.api.data.request.product.ProductRequestDto;
import ua.com.alevel.api.data.response.product.ProductResponseDto;
import ua.com.alevel.facade.ProductFacade;
import ua.com.alevel.util.TestUtil;

import java.util.Collection;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductFacadeTest {

    @Autowired
    private ProductFacade facade;

    private static ProductRequestDto dto = new ProductRequestDto();

    @BeforeAll
    static void setUp() {
        dto.setDescription(TestUtil.TEST_PRODUCT_DESCRIPTION_BEFORE);
        dto.setName(TestUtil.TEST_PRODUCT_NAME);
        dto.setProductBrand(TestUtil.TEST_PRODUCT_BRAND);
    }

    @Test
    @Order(1)
    public void shouldBeCreateProduct() {
        // given
        Collection<ProductResponseDto> collection = facade.findAll();
        long sizeBefore = collection.size();
        facade.create(dto);

        // when
        collection = facade.findAll();

        // then
        Assertions.assertEquals(collection.size(), sizeBefore + 1);
    }

    @Test
    @Order(2)
    public void shouldBeUpdateProduct() {
        // given
        dto.setDescription(TestUtil.TEST_PRODUCT_DESCRIPTION_AFTER);
        facade.update(dto, TestUtil.TEST_ID);

        // when
        ProductResponseDto dto1 = facade.findById(TestUtil.TEST_ID);

        // then
        Assertions.assertEquals(dto1.getId(), TestUtil.TEST_ID);
        Assertions.assertEquals(dto1.getName(), TestUtil.TEST_PRODUCT_NAME);
        Assertions.assertEquals(dto1.getProductBrand(), TestUtil.TEST_PRODUCT_BRAND);
        Assertions.assertEquals(dto1.getDescription(), TestUtil.TEST_PRODUCT_DESCRIPTION_AFTER);
    }
}
