/**
 *
 */
package com.jsftest.main.java.utils;

import com.jsftest.main.java.entities.Product;

/**
 * @author azahar
 *
 *         ALL methods return a String of HQL Query.
 */
public class ProductHql
{
	/**
	 * GET ALL PRODUCT
	 *
	 * @return query String
	 */
	public static String getAllProductHql()
	{
		final StringBuilder hql = new StringBuilder(" ");
		hql.append("SELECT p FROM Product p");
		return hql.toString();
	}

	/**
	 * GET PRODUCT BY ID HQL QUERY
	 *
	 * @return query String
	 */

	public static String getProductByIdHql()
	{
		// Hql to get product by id
		final StringBuilder hql = new StringBuilder(" ");
		hql.append("SELECT p FROM Product p WHERE p.id= :id");
		return hql.toString();
	}

	/**
	 * DELETE A PRODUCT HQL QUERY
	 */
	public static String deleteProductHql(final Product product)
	{
		final StringBuilder hql = new StringBuilder(" ");
		hql.append("DELETE p FROM Product p WHERE p.id = " + product.getId());
		return hql.toString();
	}

	/**
	 * DELETE ALL HQL QUERY
	 */

	public static String deleteAllProductsHql()
	{
		final StringBuilder hql = new StringBuilder(" ");
		hql.append("DELETE p FROM Product p ");
		return hql.toString();
	}

	/**
	 * UPDATE PRODUCT HQL QUERY
	 */
	public static String updateProductHql(final Product product)
	{
		// update
		// Hql
		final StringBuilder hql = new StringBuilder(" ");
		hql.append("Update Product p SET p.name = name" + ", p.price = price" + " WHERE  p.id= " + product.getId());
		return hql.toString();
	}

	/**
	 * GET AVERAGE OF PRICES
	 *
	 */

	public static String getSumOfPrices()
	{
		final StringBuilder hql = new StringBuilder(" ");
		hql.append("SELECT sum(p.price) FROM Product p");
		return hql.toString();
	}

	public static String getSumCountOfPrices()
	{
		final StringBuilder hql = new StringBuilder(" ");
		hql.append("SELECT sum(p.price), count(p.id) FROM Product p");
		return hql.toString();
	}
}
