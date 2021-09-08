package com.jsftest.main.java.entities;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.jsftest.main.java.enums.ProductDepositSystem;

public class ProductDepositData extends AbstractEntity
{
	/**
	 * Product deposit data
	 */
	private static final long serialVersionUID = 4489973497898580682L;

	@NotNull
	private ProductDepositSystem sytem;

	@NotNull
	private BigDecimal value;

	public ProductDepositData()
	{

	}

	public ProductDepositData(final BigDecimal value, final ProductDepositSystem sytem)
	{
		super();
		this.value = value;

		this.sytem = sytem;
	}

	public ProductDepositSystem getSytem()
	{
		return this.sytem;
	}

	public BigDecimal getValue()
	{
		return this.value;
	}

	public void setSytem(final ProductDepositSystem sytem)
	{
		this.sytem = sytem;
	}

	public void setValue(final BigDecimal value)
	{

		this.value = value;

	}

	@Override
	public String toString()
	{
		return "ProductDepositData [deposit=" + this.value + ",  sytem=" + this.sytem + "]";
	}

}
