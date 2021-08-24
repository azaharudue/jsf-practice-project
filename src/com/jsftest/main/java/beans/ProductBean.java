package com.jsftest.main.java.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

import com.jsftest.main.java.configs.GenericConverter;
import com.jsftest.main.java.daoImpl.CompanyDaoImpl;
import com.jsftest.main.java.daoImpl.ProductDaoImpl;
import com.jsftest.main.java.entities.Company;
import com.jsftest.main.java.entities.Product;
import com.jsftest.main.java.utils.PrintUtils;

@Named("basicView")
@ViewScoped
public class ProductBean implements Serializable
{

	private static final long serialVersionUID = -3816399998127217254L;

	private Company company;

	private final Converter<Company> companyConverter;

	private final CompanyDaoImpl companyDAO;

	private final ProductDaoImpl productDAO;

	private List<Product> products = new ArrayList<Product>();

	private Product selectedProduct;

	private List<Product> selectedProducts;

	private TimeZone timezone;

	public ProductBean()
	{
		System.out.println("basicView construct");

		this.productDAO = new ProductDaoImpl();
		this.companyDAO = new CompanyDaoImpl();
		this.companyConverter = new GenericConverter<>(this.companyDAO);
	}

	public List<Company> completeCompany(final String userInput)
	{
		// inal List<String> nameList = new ArrayList<>();
		final String userInputLowerCase = userInput.toLowerCase();
		final List<Company> companies = this.companyDAO.findAll();
		final List<Company> foundCompanies = companies.stream().filter(t -> t.getName().toLowerCase().contains(userInputLowerCase))
			.collect(Collectors.toList());

		return foundCompanies;
	}

	public void deleteProduct()
	{
		this.products.remove(this.selectedProduct);
		this.productDAO.delete(this.selectedProduct);
		this.selectedProduct = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
		PrimeFaces.current().ajax().update("growl", "formProduct:tblProduct");

	}

	public void deleteSelectedProducts()
	{
		try
		{

			this.products.removeAll(this.selectedProducts);

			for (final Product productToBeDeleted : this.selectedProducts)
				this.productDAO.delete(productToBeDeleted);

			this.selectedProducts = null;

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));

			PrimeFaces.current().ajax().update("growl", "formProduct:tblProduct");
		}
		catch (final Exception e)
		{
		}
	}

	/**
	 * @return the company
	 */
	public Company getCompany()
	{
		return this.company;
	}

	/**
	 * @return the companyConverter
	 */
	public Converter<Company> getCompanyConverter()
	{
		return this.companyConverter;
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

	public boolean hasSelectedProducts()
	{
		return (this.selectedProducts != null) && !this.selectedProducts.isEmpty();
	}

	@PostConstruct
	public void init()
	{
		this.products = this.productDAO.findAll();

	}

	public void onRowCancel(final RowEditEvent<Product> event)
	{

		final FacesMessage mgs = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject()));
		FacesContext.getCurrentInstance().addMessage(null, mgs);

	}

	public void onRowEdit(final RowEditEvent<Product> event)
	{
		final Product updatedProduct = event.getObject();

		this.productDAO.update(updatedProduct);

		final FacesMessage mgs = new FacesMessage("Product Edited", String.valueOf(event.getObject()));
		FacesContext.getCurrentInstance().addMessage(null, mgs);

	}

	public void openNew()
	{
		this.selectedProduct = new Product();
		this.selectedProduct.setCompany(new Company());
	}

	public void printPdf()
	{
		final Map<String, Object> root = new HashMap<>();
		final List<String> printables = new ArrayList<>();

		printables.add("products");

		root.put("printables", printables);
		root.put("baseURL", "D:\\azahar\\dev\\code\\jsf-practice-project\\WebContent\\resources\\images\\shop.png");

		root.put("products", this.selectedProducts);
		PrintUtils.printToPdf(this.selectedProducts, root, "products");
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
	 * @param company the company to set
	 */
	public void setCompany(final Company company)
	{
		this.company = company;
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

	public TimeZone getTimezone()
	{
		return timezone;
	}

	public void setTimezone(TimeZone timezone)
	{
		this.timezone = timezone;
	}

}