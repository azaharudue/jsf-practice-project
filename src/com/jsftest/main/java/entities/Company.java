/**
 *
 */
package com.jsftest.main.java.entities;

import java.util.List;

import javax.validation.constraints.Email;
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
	@Email
	private String email;

	@NotBlank
	@Length(min = 2, max = 255)
	private String location;

	@NotBlank
	@Length(min = 3, max = 255)
	private String name;

	private List<Product> products;

	/**
	 *
	 */
	public Company()
	{
	}

	/**
	 * @param id
	 * @param name
	 * @param location
	 *
	 */
	public Company(final Long id, final String name, final String location)
	{
		this.id = id;
		this.name = name;
		this.location = location;
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

	/**
	 * @param name
	 */
	public Company(final String name)
	{
		this.name = name;
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
	 *
	 * @param email
	 * @param location
	 * @param name
	 */
	public Company(final String email, final String location, final String name)
	{
		super();
		this.email = email;
		this.location = location;
		this.name = name;
	}

	@Override
	public Company clone()
	{
		return new Company(this.getId(), this.getName(), this.getLocation(), this.getProducts());
	}

	/*
	 * Getters & Setters
	 */

	public String getEmail()
	{
		return this.email;
	}

	public String getLocation()
	{
		return this.location;
	}

	public String getName()
	{
		return this.name;
	}

	public List<Product> getProducts()
	{
		return this.products;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public void setLocation(final String location)
	{
		this.location = location;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setProducts(final List<Product> products)
	{
		this.products = products;
	}

	@Override
	public String toString()
	{
		return "Company [id=" + this.id + ", name=" + this.name + ",email=" + this.email + ", location=" + this.location + ", products=" + this.products + "]";
	}

}
