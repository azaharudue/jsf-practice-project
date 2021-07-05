/**
 *
 */
package main.java.entities;

import java.util.List;

/**
 * @author Azahar Hossain
 *
 */
public class Company
{
	private int id;

	private String name;

	private String location;

	private List<Product> products;

	/**
	 *
	 */
	public Company()
	{
	}

	/**
	 * @param name
	 * @param location
	 * @param products
	 */
	public Company(final String name, final String location, final List<Product> products)
	{
		this.name = name;
		this.location = location;
		this.products = products;
	}

	public int getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public String getLocation()
	{
		return this.location;
	}

	public List<Product> getProducts()
	{
		return this.products;
	}

	public void setId(final int id)
	{
		this.id = id;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setLocation(final String location)
	{
		this.location = location;
	}

	public void setProducts(final List<Product> products)
	{
		this.products = products;
	}

	@Override
	public String toString()
	{
		return "Company [id=" + this.id + ", name=" + this.name + ", location=" + this.location + ", products=" + this.products + "]";
	}

}
