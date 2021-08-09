package com.jsftest.main.java.utils;

import com.jsftest.main.java.entities.ProductDetail;

public class ProductDetailHql
{

	/*
	 * Hql to get product by id
	 */

	public static String getProductDetailsByIdHql()
	{

		final StringBuilder hql = new StringBuilder(" ");
		hql.append("SELECT p FROM ProductDetail p  WHERE p.id= :id");
		return hql.toString();
	}

	/**
	 * Update product details
	 *
	 * @param productDetail
	 * @return
	 */
	public static String updateProductDetailsHql(final ProductDetail productDetail)
	{
		final StringBuilder hql = new StringBuilder(" ");
		hql.append(
			"Update ProductDetail  pd SET pd.value = value" + ", pd.product = " + productDetail.getProduct() + " WHERE  pd.id= " + productDetail.getId());
		return hql.toString();
	}
}
