package com.jsftest.main.java.entities;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author Azahar Hossain copyright (c) 2021
 */
public class Product extends AbstractEntity
{

	/**
	 *
	 */
	private static final long serialVersionUID = -583048283974323185L;

	private Company company;

	private ProductDepositData depositData;

	@NotBlank
	@Length(min = 3, max = 255)
	private String name;

	@NotNull
	private BigDecimal price;

	private Set<ProductDetail> productDetails;

	/**
	 * default constructor
	 */
	public Product()
	{
		super();
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
	 * @param price
	 * @param company
	 * @param depositData
	 */
	public Product(final String name, final BigDecimal price, final Company company, final ProductDepositData depositData)
	{
		this.name = name;
		this.price = price;
		this.company = company;
		this.depositData = depositData;
	}

	@Override
	public Product clone()
	{
		return new Product(this.name, this.price, this.company, this.depositData);
	}

	/**
	 * @return the company
	 */
	public Company getCompany()
	{
		return this.company;
	}

	public ProductDepositData getDepositData()
	{
		return this.depositData;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice()
	{
		return this.price;
	}

	public Set<ProductDetail> getProductDetails()
	{
		return this.productDetails;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(final Company company)
	{
		this.company = company;
	}

	public void setDepositData(final ProductDepositData depositData)
	{
		this.depositData = depositData;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
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

	public void setProductDetails(final Set<ProductDetail> productDetails)
	{
		this.productDetails = productDetails;
	}

	public void toggleProductDepositData()
	{

	}

	@Override
	public String toString()
	{
		return "Product :  [id=" + this.id + ", name=" + this.name + ", price=" + this.price + ", " + String.valueOf(this.depositData) + "]";
	}

}
