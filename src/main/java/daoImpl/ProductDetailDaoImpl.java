/**
 *
 */
package main.java.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import main.java.dao.ProductDetailDao;
import main.java.entities.ProductDetail;
import main.java.utils.SessionUtils;

/**
 * @author azahar
 *
 */
public class ProductDetailDaoImpl implements ProductDetailDao<ProductDetail, Serializable>
{
	private Session session = null;
	private Transaction tx = null;

	@Override
	public void persist(final ProductDetail productDetaill)
	{
		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();
			// We can use sssion.evict() for a detcahed instance.
			this.session.persist(productDetaill);
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
	public void update(final ProductDetail productDetail)
	{
		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();

			/*
			 * // Gets the hql string final String hql =
			 * ProductDetailHql.updateProductDetailsHql(productDetail);
			 * this.session.createQuery(hql).executeUpdate();
			 */
			final Query query = this.session.createNamedQuery("updateProductDetail");
			query.setParameter("id", productDetail.getId());
			query.setParameter("value", productDetail.getValue());
			query.setParameter("product_id", productDetail.getProduct().getId());
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

	@Override
	public ProductDetail findById(final Serializable id)
	{
		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();
			this.tx = this.session.beginTransaction();

			// final ProductDaoImpl daoImpl = new ProductDaoImpl();
			// // Gets the Hql String
			// final String hql = ProductDetailHql.getProductDetailsByIdHql();
			// System.out.println(hql);
			// final Query<ProductDetail> query = this.session.createQuery(hql);
			// query.setParameter("id", id);
			// final ProductDetail productDetails = query.getSingleResult();
			final Query query = this.session.createNamedQuery("findById");
			query.setParameter("id", id);
			final ProductDetail productDetail = (ProductDetail) query.getSingleResult();
			System.out.println(productDetail);
			return productDetail;

		}
		catch (final Exception ex)
		{
			System.out.println("Productdetails  with the id " + id + " not found!");
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
	public void delete(final ProductDetail productDetail)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductDetail> findAll()
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
			final List<ProductDetail> details = this.session.createNamedQuery("getAllProductDetails").getResultList();

			System.out.println("\t--------Product name------|\t costs------------------\n");
			for (final ProductDetail productDetail : details)
				System.out.println("\t|" + productDetail.getId() + "\t\t" + productDetail.getValue() + "|");

			return details;
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

	@Override
	public void deleteAll()
	{
		// TODO Auto-generated method stub

	}

}
