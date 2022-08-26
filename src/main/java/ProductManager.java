public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[1]; // тут будем хранить подошедшие запросу продукты
        for (Product product: repo.findAll()) {
            if (matches(product, text)) {

                result[result.length - 1] = product;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.matches(search)) {
            return true;
        } else {
            return false;
        }
    }
}
