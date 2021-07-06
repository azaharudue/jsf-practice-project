/*
 * package main.java.servicesUnused;
 *
 * import java.util.ArrayList; import java.util.List; import java.util.Random;
 *
 * import javax.annotation.PostConstruct; import
 * javax.enterprise.context.ApplicationScoped; import javax.inject.Named;
 *
 * import main.java.daoImpl.ProductDaoImpl; import main.java.entities.Product;
 *
 *//**
	 * @author Azahar Hossain
	 *
	 *//*
		 *
		 * @Named // To be used as a constant
		 *
		 * @ApplicationScoped public class ProductService extends ProductDaoImpl
		 * { List<Product> products;
		 *
		 * @PostConstruct public void init() { }
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