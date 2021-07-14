/**
 *
 */
package main.java.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.dao.GenericDao;
import main.java.entities.Company;
import main.java.utils.SessionUtils;

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

			System.out.println("\t--------Product name------|\t costs------------------\n");
			for (final Company company : companies)
				System.out.println("\t|" + company.getName() + "\t\t" + company.getLocation() + "|");

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
			ex.printStackTrace();
			this.tx.rollback();
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
