package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class ProductsRepositoryJdbcImplTest {
    ProductsRepository productsRepository;
    EmbeddedDatabase dataSource;

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(1L, "Bounty", 1000),
            new Product(2L, "Kit-kat", 50),
            new Product(3L, "Alenka", 150),
            new Product(4L, "Milkyway", 100),
            new Product(5L, "Chocopie", 300)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(2L, "Kit-kat", 50);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(3L, "Alenka", 150);
    final Product EXPECTED_SAVED_PRODUCT = new Product(6L, "Choc", 300);

    @BeforeEach
    void init() {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        productsRepository = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    void testFindAll() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());
    }

    @Test
    void testFindById() throws SQLException {
        Assertions.assertEquals(productsRepository.findById(2L).get(), EXPECTED_FIND_BY_ID_PRODUCT);
    }

    @Test
    void testUpdate() throws SQLException {
        productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(productsRepository.findById(3L).get(), EXPECTED_UPDATED_PRODUCT);
    }

    @Test
    void testSave() throws SQLException {
        productsRepository.save(EXPECTED_SAVED_PRODUCT);
        Assertions.assertEquals(productsRepository.findById(6L).get(), EXPECTED_SAVED_PRODUCT);
    }

    @Test
    void testDelete() throws SQLException {
        productsRepository.delete(1L);
        Assertions.assertThrows(RuntimeException.class, () -> productsRepository.findById(1L));
    }

    @AfterEach
    void close() {
        dataSource.shutdown();
    }
}