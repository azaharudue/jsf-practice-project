package main.java.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

import main.java.daoImpl.CompanyDaoImpl;
import main.java.daoImpl.ProductDaoImpl;
import main.java.entities.Company;
import main.java.entities.Product;

@Named("basicView")
@ViewScoped
public class ProductBean implements Serializable
{

	private static final long serialVersionUID = -3816399998127217254L;

	private final CompanyDaoImpl companyDAO;

	private final ProductDaoImpl productDAO;

	private List<Product> products = new ArrayList<Product>();

	private Product selectedProduct;

	private List<Product> selectedProducts;

	public ProductBean()
	{
		System.out.println("basicView construct");

		this.productDAO = new ProductDaoImpl();
		this.companyDAO = new CompanyDaoImpl();
	}

	public void clearForm()
	{

		this.selectedProduct = null;
	}

	public List<Product> getProducts()
	{
		return this.products;
	}

	/**
	 * @return the selectedProduct
	 */
	public Product getSelectedProduct()
	{
		return this.selectedProduct;
	}

	/**
	 * @return the selectedProducts
	 */
	public List<Product> getSelectedProducts()
	{
		return this.selectedProducts;
	}

	public void onRowCancel(final RowEditEvent<Product> event)
	{

		final FacesMessage mgs = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject()));
		FacesContext.getCurrentInstance().addMessage(null, mgs);
		this.clearForm();
	}

	public void onRowEdit(final RowEditEvent<Product> event)
	{
		final Product updatedProduct = (Product) event.getObject();

		this.productDAO.update(updatedProduct);

		final FacesMessage mgs = new FacesMessage("Product Edited", String.valueOf(event.getObject()));
		FacesContext.getCurrentInstance().addMessage(null, mgs);

	}

	public void openNew()
	{
		this.selectedProduct = new Product();
		this.selectedProduct.setCompany(new Company());
	}

	@PostConstruct
	public void populateProductList()
	{
		this.products = this.productDAO.findAll();

	}

	public String saveProduct()
	{
		try
		{

			this.companyDAO.save(this.selectedProduct.getCompany());
			this.productDAO.save(this.selectedProduct);

			this.products.add(this.selectedProduct);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product created!"));

		}
		catch (final Exception e)
		{

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getLocalizedMessage(), "Product not created!"));

		}

		return null;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(final List<Product> products)
	{
		this.products = products;
	}

	/**
	 * @param selectedProduct the selectedProduct to set
	 */
	public void setSelectedProduct(final Product selectedProduct)
	{
		this.selectedProduct = selectedProduct;
	}

	/**
	 * @param selectedProducts the selectedProducts to set
	 */
	public void setSelectedProducts(final List<Product> selectedProducts)
	{
		this.selectedProducts = selectedProducts;
	}

	public String getDeleteButtonMessage()
	{
		if (this.hasSelectedProducts())
		{
			final int size = this.selectedProducts.size();
			return size > 1 ? size + " products selected" : "1 product selected";
		}

		return "Delete";
	}

	public boolean hasSelectedProducts()
	{
		return (this.selectedProducts != null) && !this.selectedProducts.isEmpty();
	}

	public void deleteSelectedProducts()
	{
		this.products.removeAll(this.selectedProducts);
		this.selectedProducts = null;

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));

		PrimeFaces.current().ajax().update("growl", "formProduct:tblProduct");
		// PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
	}

	public void deleteProduct()
	{
		this.products.remove(this.selectedProduct);
		this.selectedProduct = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
		PrimeFaces.current().ajax().update("growl", "formProduct:tblProduct");

	}

}