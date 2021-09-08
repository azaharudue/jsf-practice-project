/**
 *
 */
package com.jsftest.main.java.daoImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import com.jsftest.main.java.dao.GenericDao;
import com.jsftest.main.java.entities.Company;
import com.jsftest.main.java.utils.SessionUtils;

/**
 * @author azahar
 *
 */
public class CompanyDaoImpl implements GenericDao<Company, Long>
{
	private Session session = null;
	private Transaction tx = null;

	@Override
	public void delete(final Company company)
	{

		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();
			// Uses session.delete()
			this.session.delete(company);

			// // Uses HQL queries // Gets the hql string and use Hql final
			// String hql = ProductHql.deleteProductHql(product);
			// this.session.createQuery(hql).executeUpdate();

			final Query query = this.session.createNamedQuery("deleteCompanyById");
			query.setParameter("id", company.getId());
			query.executeUpdate();
			this.tx.commit();

		}
		catch (final Exception ex)
		{
			ex.printStackTrace();
			this.tx.rollback();
		}
		finally
		{
			this.session.close();
		}

	}

	/**
	 * Deletes all products from the database
	 *
	 */
	@Override
	public void deleteAll()
	{
		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();
			// Gets the hql string and use Hql
			// final String hql = ProductHql.deleteAllProductsHql();
			// this.session.createQuery(hql).executeUpdate();
			this.session.createNamedQuery("deleteAllCompanies").executeUpdate();
			this.tx.commit();

		}
		catch (final Exception ex)
		{
			ex.printStackTrace();
			this.tx.rollback();
		}
		finally
		{
			this.session.close();
		}

	}

	@Override
	public List<Company> findAll()
	{

		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();

			/*
			 * Uses Hql hardcoded query
			 */

			// Gets the hql string
			// final String hql = ProductHql.getAllProductHql();
			// final List<Product> products =
			// this.session.createQuery(hql).getResultList();

			/**
			 * Uses named query
			 */
			@SuppressWarnings("unchecked")
			final List<Company> companies = this.session.createNamedQuery("getAllCompanies").getResultList();

			for (final Company company : companies)
				System.out.println(company.toString());;

			return companies;
		}
		catch (final Exception ex)
		{
			ex.printStackTrace();
			this.tx.rollback();
		}
		finally
		{
			this.session.close();
		}
		return null;
	}

	/**
	 * Gets a company by Id
	 *
	 * Uses HQL
	 */
	@Override
	public Company findById(final Long id)
	{
		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();

			/**
			 * Uses named query
			 */
			final Query<Company> query = this.session.createNamedQuery("getCompanyById");
			query.setParameter("id", id);
			final Company company = query.getSingleResult();

			this.tx.commit();
			System.out.println(company);
			return company;

		}
		catch (final Exception ex)
		{
			System.out.println("Company  with the id " + id + " not found!");
			ex.printStackTrace();

			this.tx.rollback();
		}
		finally
		{
			this.session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findPaged(final int first, final int pageSize, final Map<String, SortMeta> sortBy, final Map<String, FilterMeta> filterBy)
	{
		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();

			@SuppressWarnings("deprecation")
			final Criteria cr = this.session.createCriteria(Company.class);
			cr.setFirstResult(first);
			cr.setMaxResults(pageSize);

			for (final Map.Entry<String, SortMeta> entrySort : sortBy.entrySet())
				if (entrySort.getValue().getSortOrder() == SortOrder.ASCENDING)
					cr.addOrder(Order.asc(entrySort.getValue().getSortField()));
				else
					cr.addOrder(Order.desc(entrySort.getValue().getSortField()));

			for (final Map.Entry<String, FilterMeta> entryFilter : filterBy.entrySet())
				if ((entryFilter.getValue().getFilterField() != null) && (entryFilter.getValue().getFilterValue() != null))
					cr.add(Restrictions.ilike(entryFilter.getValue().getFilterField(),
						"%" + entryFilter.getValue().getFilterValue().toString().toLowerCase() + "%"));

			return cr.list();

		}
		catch (final Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			this.session.close();
		}
		return null;
	}

	@Override
	public int getRowCount()
	{

		return this.findAll().size();
	}

	/**
	 * Persist an Object
	 */
	@Override
	public void save(final Company company)
	{
		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();
			// We can use sssion.evict() for a detcahed instance.
			// this.session.persist(product);
			this.session.saveOrUpdate(company);
			this.tx.commit();

		}
		catch (final Exception ex)
		{
			this.tx.rollback();
			throw ex;
		}
		finally
		{
			this.session.close();
		}

	}

	/**
	 * updates a product using HQL
	 *
	 */
	@Override
	public void update(final Company company)
	{
		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();
			// Gets the hql string
			// final String hql = ProductHql.updateProductHql(product);
			// this.session.createQuery(hql).executeUpdate();
			// this.findAll();
			this.session.saveOrUpdate(company);
			this.tx.commit();

		}
		catch (final Exception ex)
		{
			ex.printStackTrace();
			this.tx.rollback();
		}
		finally
		{
			this.session.close();
		}

	}

}
