/**
 *
 */
package com.jsftest.main.java.entities;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * @author Azahar Hossain
 *
 */
public class Company extends AbstractEntity
{

	/**
	 *
	 */
	private static final long serialVersionUID = 4293472304170040808L;

	@NotBlank
	@Length(min = 3, max = 255)
	private String name;

	@NotBlank
	@Length(min = 2, max = 255)
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

	/**
	 * @param name
	 */
	public Company(final String name)
	{
		this.name = name;
	}

	/**
	 * @param id
	 * @param name
	 * @param location
	 * @param products
	 */
	public Company(final Long id, final String name, final String location, final List<Product> products)
	{
		this.id = id;
		this.name = name;
		this.location = location;
		this.products = products;
	}

	@Override
	public Company clone()
	{
		return new Company(this.getId(), this.getName(), this.getLocation(), this.getProducts());
	}

	/*
	 * Getters & Setters
	 */

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
