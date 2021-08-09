/**
 *
 */
package com.jsftest.main.java.lazyModels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import com.jsftest.main.java.daoImpl.CompanyDaoImpl;
import com.jsftest.main.java.entities.Company;

/**
 * @author Azahar Hossain
 *
 */
public class CompanyLazyModel extends LazyDataModel<Company>
{

	private static final long serialVersionUID = -8791763741504790746L;

	private final CompanyDaoImpl companyDAO;

	public CompanyLazyModel()
	{
		this.companyDAO = new CompanyDaoImpl();
	}

	@Override
	public List<Company> load(final int offset, final int pageSize, final String sortField, final SortOrder sortOrder, final Map<String, FilterMeta> filterBy)
	{
		final Map<String, SortMeta> sortBy = new HashMap<>();
		if ((sortField != null) && (sortOrder != null))
			sortBy.put(sortField, new SortMeta(null, sortField, sortOrder, null));

		return this.load(offset, pageSize, sortBy, filterBy);

	}

	@Override
	public List<Company> load(final int offset, final int pageSize, final Map<String, SortMeta> sortBy, final Map<String, FilterMeta> filterBy)
	{
		// get row count
		// super.setRowCount(rowCount);
		return this.companyDAO.findPaged(offset, pageSize, sortBy, filterBy);
	}

	@Override
	public int getRowCount()
	{
		super.getRowCount();
		return (int) this.companyDAO.findAll().size();
	}

	@Override
	public Company getRowData(final String rowKey)
	{
		final Long id = Long.valueOf(rowKey);
		return this.companyDAO.findById(id);
	}

}
