package main.java.dao;

import java.io.Serializable;
import java.util.List;

public interface ProductDao<Product, Id extends Serializable>
{
	public void save(Product product);

	public void update(Product product);

	public Product findById(Id id);

	public void delete(Product product);

	public List<Product> findAll();

	public void deleteAll();

}
