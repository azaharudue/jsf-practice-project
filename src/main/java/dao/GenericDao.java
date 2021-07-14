
package main.java.dao;

import java.util.List;

import main.java.entities.Company;
import main.java.entities.Product;
import main.java.entities.ProductDetail;

/**
 * @author Azahar Hossain Generic Dao for {@link Product} {@link ProductDetail}
 *         {@link Company}}
 */
public interface GenericDao<T, Long>
{
	public void save(T t);

	public void update(T t);

	public T findById(Long id);

	public void delete(T t);

	public List<T> findAll();

	public void deleteAll();
}
