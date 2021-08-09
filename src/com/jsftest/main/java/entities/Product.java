package com.jsftest.main.java.entities;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author azahar copyright (c) 2021
 */
public class Product extends AbstractEntity
{

	/**
	 *
	 */
	private static final long serialVersionUID = -583048283974323185L;

	@NotBlank
	@Length(min = 3, max = 255)
	private String name;

	@NotNull
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
	 *
	 * @param name
	 * @param price *
	 * @param company
	 */
	public Product(final String name, final BigDecimal price, final Company company)
	{
		this.name = name;
		this.price = price;
		this.company = company;
	}

	@Override
	public Product clone()
	{
		return new Product(this.getName(), this.price, this.getCompany());
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
