package com.jsftest.main.java.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import com.jsftest.main.java.dao.AvgSumCount;
import com.jsftest.main.java.dao.ProductsInCompany;
import com.jsftest.main.java.entities.Product;
import com.jsftest.main.java.servicesUnused.ProductDaoImpExtension;

@Named("summaryView")
@ViewScoped
public class SummaryBean implements Serializable
{
	private LazyDataModel<ProductsInCompany> productsInCompanyModel;
	private final ProductDaoImpExtension DAO;
	private final AvgSumCount avgSumCount = null;
	private Product selectedProduct;

	public SummaryBean()
	{
		this.DAO = new ProductDaoImpExtension();

	}

	public String averagePrices()
	{
		return this.DAO.getAvgSumCountOfPrices().getAverage().toString();
	}

	public String getProductDetail()
	{

		return this.DAO.getDetailsByProductId(this.selectedProduct.getId());
	}

	/**
	 * @return the selectedProduct
	 */
	public Product getSelectedProduct()
	{
		return this.selectedProduct;
	}

	/**
	 * @param selectedProduct the selectedProduct to set
	 */
	public void setSelectedProduct(final Product selectedProduct)
	{
		this.selectedProduct = selectedProduct;
	}

}
