package ua.com.alevel.service.product.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.alevel.exception.EntityNotFoundException;
import ua.com.alevel.exception.NotValidDataException;
import ua.com.alevel.persistence.entity.product.Product;
import ua.com.alevel.persistence.repository.product.ProductRepository;
import ua.com.alevel.service.product.impl.ProductServiceImpl;
import ua.com.alevel.util.ExceptionUtil;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static ua.com.alevel.util.TestUtil.*;

@SpringBootTest
public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl service;

    @Mock
    private ProductRepository productRepository;

    private Product product = new Product();

    @Test
    public void shouldBeCreateProductThenProductIsNull() {
        // given
        product = null;

        // when
        Exception thrown = Assertions.assertThrows(NotValidDataException.class, () -> service.create(product));

        // then
        assertThat(thrown).isInstanceOf(NotValidDataException.class);
        assertThat(thrown.getMessage()).isEqualTo(ExceptionUtil.PRODUCT_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeCreateProductThenProductNameIsNull() {
        // given
        product = new Product();
        product.setName(null);

        // when
        Exception thrown = Assertions.assertThrows(NotValidDataException.class, () -> service.create(product));

        // then
        assertThat(thrown).isInstanceOf(NotValidDataException.class);
        assertThat(thrown.getMessage()).isEqualTo(ExceptionUtil.PRODUCT_NAME_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeCreateProductThenProductBrandIsNull() {
        // given
        product = new Product();
        product.setName(TEST_PRODUCT_NAME);
        product.setProductBrand(null);

        // when
        Exception thrown = Assertions.assertThrows(NotValidDataException.class, () -> service.create(product));

        // then
        assertThat(thrown).isInstanceOf(NotValidDataException.class);
        assertThat(thrown.getMessage()).isEqualTo(ExceptionUtil.PRODUCT_BRAND_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeCreateProductThenProductIsValid() {
        // given
        product = new Product();
        product.setName(TEST_PRODUCT_NAME);
        product.setProductBrand(TEST_PRODUCT_BRAND);

        // when
        service.create(product);

        // then
        Mockito.verify(productRepository, Mockito.times(1)).save(product);
    }

    @Test
    public void shouldBeFindByIdProductThenIdIsNull() {
        // given
        final Long id = null;

        // when
        Exception thrown = Assertions.assertThrows(EntityNotFoundException.class, () -> service.findById(id));

        // then
        assertThat(thrown).isInstanceOf(EntityNotFoundException.class);
        assertThat(thrown.getMessage()).isEqualTo(ExceptionUtil.ENTITY_ID_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeFindByIdProductThenProductNotFoundById() {
        // given
        Mockito.when(productRepository.findById(TEST_ID)).thenReturn(Optional.empty());

        // when
        Exception thrown = Assertions.assertThrows(EntityNotFoundException.class, () -> service.findById(TEST_ID));

        // then
        Mockito.verify(productRepository, Mockito.times(1)).findById(TEST_ID);
        assertThat(thrown).isInstanceOf(EntityNotFoundException.class);
        assertThat(thrown.getMessage()).isEqualTo(ExceptionUtil.ENTITY_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeFindByIdProductThenProductExistsById() {
        // given
        product.setId(TEST_ID);
        Mockito.when(productRepository.findById(TEST_ID)).thenReturn(Optional.of(product));

        // when
        product = service.findById(TEST_ID);

        // then
        Mockito.verify(productRepository, Mockito.times(1)).findById(TEST_ID);
        assertThat(product).isNotNull();
        assertThat(product.getId()).isEqualTo(TEST_ID);
    }
}
