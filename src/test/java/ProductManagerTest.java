import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ProductManagerTest {
    ProductRepository repo = Mockito.mock(ProductRepository.class);
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(11, "Book 1", 100, "Author 1");
    Product product2 = new Smartphone(22, "Smartphone 1", 200, "Manufacture 1");
    Product product3 = new Book(33, "Book 2", 300, "Author 2");
    Product product4 = new Smartphone(44, "Smartphone 2", 400, "Manufacture 2");

    @Test
    public void shouldSearchBy() {
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("Book 2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByRichModel() {
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("Manufacture 2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByRichModel2() {
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("Author 2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByRichModel3() {
        Product[] products = {product1, product2, product3, product4};
        doReturn(products).when(repo).findAll();

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Smartphone 1");

        Assertions.assertArrayEquals(expected, actual);
    }


}
