package main.java.entities;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @author azahar copyright (c) 2021
 */
public class Product
{
	private Integer id;

	private String name;

	private BigDecimal price;

	private Set<ProductDetail> productDetails;

	private Company company;

	/**
	 * default constructor
	 */
	public Product()
	{

	}

	/**
	 * Constructor with 2 @param
	 *
	 * @param name
	 * @param price
	 */
	public Product(final String name, final BigDecimal price)
	{
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public Integer getId()
	{
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Integer id)
	{
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice()
	{
		return this.price;
	}

	/**
	 * the price to set
	 *
	 * @param price
	 *
	 */
	public void setPrice(final BigDecimal price)
	{
		this.price = price;
	}

	public Set<ProductDetail> getProductDetails()
	{
		return this.productDetails;
	}

	public void setProductDetails(final Set<ProductDetail> productDetails)
	{
		this.productDetails = productDetails;
	}

	/**
	 * @return the company
	 */
	public Company getCompany()
	{
		return this.company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(final Company company)
	{
		this.company = company;
	}

	@Override
	public String toString()
	{
		return "Product :  [id=" + this.id + ", name=" + this.name + ", price=" + this.price + "]";
	}

}
