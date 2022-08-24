import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product item1 = new Book(1, "Книга1", 500, "Автор1");
    Product item2 = new Book(2, "Книга2", 300, "Автор2");
    Product item3 = new Smartphone(3, "Телефон1", 1500, "Производитель1");
    Product item4 = new Smartphone(4, "Телефон2", 1000, "Производитель2");
    Product item5 = new Book(5, "Книга3", 300, "Автор2");
    Product item6 = new Smartphone(6, "Телефон3", 1500, "Производитель2");

    @BeforeEach
    public void Setup() {
        manager.addNew(item1);
        manager.addNew(item2);
        manager.addNew(item3);
        manager.addNew(item4);
        manager.addNew(item5);
        manager.addNew(item6);
    }

    @Test
    public void testSearchBy1() {


        Product[] expected = {};
        Product[] actual = manager.searchBy("10");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchBy2() {


        Product[] expected = {item5, item6};
        Product[] actual = manager.searchBy("3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByAuthor() {


        Product[] expected = {item2, item5};
        Product[] actual = manager.searchBy("Автор2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByManufacturer() {


        Product[] expected = {item3, item4, item6};
        Product[] actual = manager.searchBy("Прои");

        Assertions.assertArrayEquals(expected, actual);
    }

}
