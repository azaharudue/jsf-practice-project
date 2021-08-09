/**
 *
 */
package com.jsftest.main.java.dao;

import java.math.BigDecimal;

import com.jsftest.main.java.entities.Company;

/**
 * @author azahar
 *
 */
public class ProductsInCompany
{

	private Company company;

	private BigDecimal totalPrice;

	private Double average;

	private Long count;

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

	/**
	 * @return the totalPrice
	 */
	public BigDecimal getTotalPrice()
	{
		return this.totalPrice;
	}

	/**
	 * @return the average
	 */
	public Double getAverage()
	{
		return this.average;
	}

	/**
	 * @return the count
	 */
	public Long getCount()
	{
		return this.count;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(final BigDecimal totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	/**
	 * @param average the average to set
	 */
	public void setAverage(final Double average)
	{
		this.average = average;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(final Long count)
	{
		this.count = count;
	}

	@Override
	public String toString()
	{
		final String companyName = this.company == null ? "" : this.company.getName();

		return "ProductsInCompany [company=" + companyName + ", totalPrice=" + this.totalPrice + ", average=" + this.average + ", count=" + this.count + "]";
	}

}
