
package main.java.daoImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;

import main.java.dao.GenericDao;
import main.java.entities.Product;
import main.java.utils.SessionUtils;

public class ProductDaoImpl implements GenericDao<Product, Long>
{
	private Session session = null;
	private Transaction tx = null;

	@Override
	public void delete(final Product product)
	{

		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();
			// Uses session.delete()
			this.session.delete(product);

			// // Uses HQL queries // Gets the hql string and use Hql final
			// String hql = ProductHql.deleteProductHql(product);
			// this.session.createQuery(hql).executeUpdate();

			final Query query = this.session.createNamedQuery("deleteProductById");
			query.setParameter("id", product.getId());
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
			this.session.createNamedQuery("deleteAllProducts").executeUpdate();
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
	public List<Product> findAll()
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
			final List<Product> products = this.session.createNamedQuery("getAllProducts").getResultList();

			System.out.println("\t--------Product name------|\t costs------------------\n");
			for (final Product product : products)
				System.out.println("\t|" + product.getName() + "\t\t" + product.getPrice() + "|");

			return products;
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
	 * Gets a product by Id
	 *
	 * Uses HQL
	 */
	@Override
	public Product findById(final Long id)
	{
		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();
			/**
			 * Uses hard coded hql
			 */
			// // Gets the Hql String
			// final String hql = ProductHql.getProductByIdHql();
			// System.out.println(hql);
			// final Query<Product> query = this.session.createQuery(hql);
			/**
			 * Uses named query
			 */
			final Query<Product> query = this.session.createNamedQuery("getProductById");
			query.setParameter("id", id);
			final Product product = query.getSingleResult();

			this.tx.commit();
			System.out.println(product);
			return product;

		}
		catch (final Exception ex)
		{
			System.out.println("Product  with the id " + id + " not found!");
			ex.printStackTrace();

			this.tx.rollback();
		}
		finally
		{
			this.session.close();
		}
		return null;
	}

	@Override
	public List<Product> findPaged(final int first, final int pageSize, final Map<String, SortMeta> sortBy, final Map<String, FilterMeta> filterBy)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Persist an Object
	 */
	@Override
	public void save(final Product product)
	{
		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();
			// We can use sssion.evict() for a detcahed instance.
			// this.session.persist(product);
			this.session.saveOrUpdate(product);

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
	public void update(final Product product)
	{
		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();
			// Gets the hql string
			// final String hql = ProductHql.updateProductHql(product);
			// this.session.createQuery(hql).executeUpdate();
			// this.findAll();
			this.session.saveOrUpdate(product);
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
