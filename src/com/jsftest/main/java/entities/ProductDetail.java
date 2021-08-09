/**
 *
 */
package com.jsftest.main.java.entities;

/**
 * @author azahar
 *
 */
public class ProductDetail extends AbstractEntity
{

	/**
	 *
	 */
	private static final long serialVersionUID = 6681493385672944386L;

	private String value;

	private Product product;

	/**
	 * default constructor
	 */
	public ProductDetail()
	{
	}

	/**
	 * Constructor
	 *
	 * @param value
	 * @param product
	 */
	public ProductDetail(final String value, final Product product)
	{
		this.value = value;
		this.product = product;
	}

	/**
	 * @param id
	 * @param value
	 * @param product
	 */
	public ProductDetail(final Long id, final String value, final Product product)
	{
		this.id = id;
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue()
	{
		return this.value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(final String value)
	{
		this.value = value;
	}

	public Product getProduct()
	{
		return this.product;
	}

	public void setProduct(final Product product)
	{
		this.product = product;
	}

	@Override
	public String toString()
	{
		return "ProductDetail [id=" + this.id + ", value=" + this.value + ", product=" + this.product + "]";
	}

}
