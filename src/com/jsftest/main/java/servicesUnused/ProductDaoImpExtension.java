
package com.jsftest.main.java.servicesUnused;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.jsftest.main.java.dao.AvgSumCount;
import com.jsftest.main.java.dao.ProductsInCompany;
import com.jsftest.main.java.daoImpl.ProductDaoImpl;
import com.jsftest.main.java.entities.Product;
import com.jsftest.main.java.entities.ProductDetail;
import com.jsftest.main.java.utils.SessionUtils;

public class ProductDaoImpExtension extends ProductDaoImpl
{
	private int sum;
	private ProductDaoImpl daoImpl;
	Session session = null;
	Transaction tx = null;

	public int getSumOfPrices()
	{
		try
		{
			/**
			 * Using named Query
			 */

			this.session = SessionUtils.getSessionFactory().openSession();

			final int sum = (int) this.session.getNamedQuery("getSumOfPrices").getSingleResult();
			System.out.println("Total of all product prices" + sum);

			return sum;
		}
		catch (final Exception e)
		{
			e.getStackTrace();
		}
		finally
		{
			this.session.close();
		}
		return -1;
	}

	public AvgSumCount getAvgSumCountOfPrices()
	{
		try
		{
			/**
			 * Using named Query
			 */

			this.session = SessionUtils.getSessionFactory().openSession();

			final Query<AvgSumCount> query = this.session.getNamedQuery("getAvgSumCountOfPrices");

			query.setResultTransformer(Transformers.aliasToBean(AvgSumCount.class));

			final List<AvgSumCount> results = query.getResultList();
			for (final AvgSumCount result : results)
			{
				System.out.println("Total price: " + result.getSum() + "\nAverage: " + result.getAverage() + "\nTotal products: " + result.getCount());
				return result;
			}

		}
		catch (final Exception e)
		{
			e.getStackTrace();
		}
		finally
		{
			this.session.close();
		}
		return null;
	}

	/**
	 * Get a product with all existing details using criteria restrictions
	 *
	 * @param id {@link Product#getId()}
	 * @return
	 */

	public String getDetailsByProductId(final Long id)
	{
		try
		{

			this.session = SessionUtils.getSessionFactory().openSession();

			// Get the product final ProductDaoImpl daoImpl = new
			// ProductDaoImpl(); final
			final Product product = this.daoImpl.findById(id);

			// StringBuilder object to return product with details final final
			final StringBuilder description = new StringBuilder("");
			final Query<ProductDetail> query = this.session.createNamedQuery("getDetailsByProductId");
			query.setParameter("id", id);
			final List<ProductDetail> details = query.getResultList();
			for (final ProductDetail productDetail : details)
				description.append(productDetail.getValue());

			// Get details where product id is same as in parameter final
			final Criteria criteria = this.session.createCriteria(ProductDetail.class, "pd");
			criteria.add(Restrictions.eq("pd.product.id", product.getId()));
			final List<ProductDetail> listOfPd = criteria.list();

			for (final ProductDetail pd : listOfPd)
			{
				description.append("," + pd.getValue());

			}
			description.append("  has price    " + product.getPrice());

			return description.toString();

		}
		catch (final Exception e)
		{
			e.getStackTrace();
		}
		finally
		{
			this.session.close();
		}

		return null;
	}

	/**
	 * Get Product detail with value/description
	 */

	/**
	 * Get a product with all existing details using criteria restrictions
	 *
	 * @param id {@link ProductDetail#getValue()}
	 * @return
	 */

	/*
	 * public String getProductWithDetailsByValue(final String value) { try {
	 *
	 * this.session = SessionUtils.getSessionFactory().openSession();
	 *
	 * // StringBuilder object to return product with details final
	 *
	 * final Query query =
	 * this.session.createNamedQuery("getProductWithDetailsByValue");
	 * query.setParameter("value", value); final String description =
	 * query.getResultList().toString(); final List<ProductDetail> product =
	 * query.getResultList();
	 *
	 * // Get details where product id is same as in parameter final final
	 * Criteria criteria = this.session.createCriteria(ProductDetail.class,
	 * "pd"); criteria.add(Restrictions.eq("pd.product.id", product.)); final
	 * List<ProductDetail> listOfPd = criteria.list();
	 *
	 * for (final ProductDetail pd : listOfPd) { description.append("," +
	 * pd.getValue());
	 *
	 * } description.append("  has price    " + product.getPrice());
	 * System.out.println(description);
	 *
	 * return description;
	 *
	 * } catch (final Exception e) { e.getStackTrace(); } finally {
	 * this.session.close(); }
	 *
	 * return null; }
	 */

	public String getProductDetailsByAliasToBean()
	{
		try
		{
			this.session = SessionUtils.getSessionFactory().openSession();

			final Query<ProductsInCompany> query = this.session.createNamedQuery("getSummaryPerCompany");

			query.setResultTransformer(Transformers.aliasToBean(ProductsInCompany.class));
			final List<ProductsInCompany> productDetails = query.getResultList();

			final StringBuilder result = new StringBuilder("");
			for (final ProductsInCompany productsInCompany : productDetails)
			{

				result.append(productsInCompany.toString() + "\n");
			}

			return result.toString();
		}
		catch (final Exception e)
		{
			e.getStackTrace();
		}
		finally
		{
			this.session.close();
		}
		return null;
	}

	public String getProductsPerCompany()
	{
		try
		{
			/**
			 * Using named Query
			 */
			this.session = SessionUtils.getSessionFactory().openSession();

			final Query<ProductsInCompany> query = this.session.getNamedQuery("getSummaryPerCompany");

			query.setResultTransformer(Transformers.aliasToBean(ProductsInCompany.class));

			final List<ProductsInCompany> results = query.getResultList();
			for (final ProductsInCompany result : results)
			{
				System.out
					.println("Company: " + result.getCompany().getName() + "\nAverage: " + result.getAverage() + "\nTotal products: " + result.getCount());

			}
			return results.toString();
		}
		catch (final Exception e)
		{
			e.getStackTrace();
		}
		finally
		{
			this.session.close();
		}
		return null;
	}

}
