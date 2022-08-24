public class ProductRepository {
    protected Product[] items = new Product[0];

    public ProductRepository(Product[] products) {
        this.items = products;
    }

    public ProductRepository() {
    }

    public Product[] getProducts() {
        return items;
    }

    public void setProducts(Product[] products) {
        this.items = products;
    }

    public void save(Product newProduct) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = newProduct;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        } else {
            Product[] tmp = new Product[items.length - 1];
            int copyToIndex = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[copyToIndex] = item;
                    copyToIndex++;
                }
            }
            items = tmp;
        }
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (id == item.getId()) {
                return item;
            }
        }
        return null;
    }
}

