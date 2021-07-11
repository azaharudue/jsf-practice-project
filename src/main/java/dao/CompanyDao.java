/**
 *
 */
package main.java.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author azahar
 *
 */
public interface CompanyDao<Company, Id extends Serializable> {
	public void delete(Company company);

	public void deleteAll();

	public List<Company> findAll();

	public Company findById(Id id);

	public void save(Company company);

	public void update(Company company);
}
