package main.java.dao;

import java.math.BigDecimal;

public class AvgSumCount
{
	private BigDecimal sum;

	private Double average;

	private Long count;

	public BigDecimal getSum()
	{
		return this.sum;
	}

	public Double getAverage()
	{
		return this.average;
	}

	public Long getCount()
	{
		return this.count;
	}

	public void setSum(final BigDecimal sum)
	{
		this.sum = sum;
	}

	public void setAverage(final Double average)
	{
		this.average = average;
	}

	public void setCount(final Long count)
	{
		this.count = count;
	}

}
