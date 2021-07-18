
package main.java.dao;

import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;

import main.java.entities.Company;
import main.java.entities.Product;
import main.java.entities.ProductDetail;

/**
 * @author Azahar Hossain Generic Dao for {@link Product} {@link ProductDetail}
 *         {@link Company}}
 */
public interface GenericDao<T, Long> {
	public void delete(T t);

	public void deleteAll();

	public List<T> findAll();

	public T findById(Long id);

	List<T> findPaged(final int first, final int pageSize, final String sortField, final boolean asc,
			Map<String, FilterMeta> filterBy);

	public void save(T t);

	public void update(T t);
}
