/**
 *
 */

package com.jsftest.main.java.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.jsftest.main.java.daoImpl.ProductDetailDaoImpl;
import com.jsftest.main.java.entities.Product;
import com.jsftest.main.java.entities.ProductDetail;

/**
 * @author Azahar Hossain
 *
 */
@Named("detailView")

@ViewScoped
public class ProductDetailBean implements Serializable
{

	private static final long serialVersionUID = 5426963087067950211L;

	private List<ProductDetail> details = new ArrayList<ProductDetail>();

	private final ProductDetailDaoImpl detailDao;

	public ProductDetailBean()
	{
		System.out.println("Detail View construct");
		this.detailDao = new ProductDetailDaoImpl();
	}

	@PostConstruct
	public void populateProductDetailList()
	{
		this.details = this.detailDao.findAll();
	}

	public List<ProductDetail> getProductDetails()
	{
		return this.details;
	}

	public ProductDetail getSelectedProductDetails(final Product product)
	{
		return this.detailDao.findById(product.getId());
	}

}
