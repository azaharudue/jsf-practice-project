/**
 *
 */
/*
 * package main.java.services;
 *
 *//**
	 * @author Azahar Hossain
	 *
	 */
/*
*//**
	*
	*/
/*
 * import java.math.BigDecimal; import java.util.ArrayList; import
 * java.util.List; import java.util.Random;
 *
 * import javax.annotation.PostConstruct; import
 * javax.enterprise.context.ApplicationScoped; import javax.inject.Named;
 *
 * import main.java.entities.Product;
 *
 *//**
	 * @author Azahar Hossain
	 *
	 *//*
		 *
		 * @Named
		 *
		 * @ApplicationScoped public class ProductService { List<Product>
		 * products;
		 *
		 * @PostConstruct public void init() { this.products = new
		 * ArrayList<>(); this.products.add(new Product("New Product",
		 * BigDecimal.valueOf(500.00))); this.products.add(new
		 * Product("New Product 2", BigDecimal.valueOf(1000.00)));
		 * this.products.add(new Product("New Product 3",
		 * BigDecimal.valueOf(800.00)));
		 *
		 * }
		 *
		 * public List<Product> getProducts(final int size) { if (size >
		 * this.products.size()) { final Random rand = new Random();
		 *
		 * final List<Product> randomList = new ArrayList<>(); for (int i = 0; i
		 * < size; i++) { final int randomIndex =
		 * rand.nextInt(this.products.size());
		 * randomList.add(this.products.get(randomIndex)); }
		 *
		 * return randomList; }
		 *
		 * else { return new ArrayList<>(this.products.subList(0, size)); }
		 *
		 * }
		 *
		 * public List<Product> getAllProducts() { return new
		 * ArrayList<>(this.products); }
		 *
		 * public List<Product> getClonedProducts(final int size) { final
		 * List<Product> results = new ArrayList<>(); final List<Product>
		 * originals = this.getProducts(size); for (final Product original :
		 * originals) { results.add(original.clone()); } return results; }
		 *
		 * }
		 */