import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();

    Product item1 = new Book(1, "Книга1", 500, "Автор1");
    Product item2 = new Book(2, "Книга2", 300, "Автор2");
    Product item3 = new Smartphone(3, "Телефон1", 1500, "Производитель1");
    Product item4 = new Smartphone(4, "Телефон2", 1000, "Производитель2");
    Product item5 = new Book(5, "Книга3", 300, "Автор2");
    Product item6 = new Smartphone(6, "Телефон3", 1500, "Производитель2");

    @Test
    public void testSave() {
        repo.save(item1);
        repo.save(item3);

        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindById() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);

        Product expected = item4;
        Product actual = repo.findById(4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveById() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);

        repo.removeById(3);

        Product[] expected = {item1, item2, item4, item5, item6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveByIdWithException() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-100);
        });
    }
}
