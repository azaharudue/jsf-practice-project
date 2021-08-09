package com.jsftest.main.jsf;

import java.util.List;

import com.jsftest.main.java.daoImpl.CompanyDaoImpl;
import com.jsftest.main.java.entities.Company;
import com.jsftest.main.java.entities.Product;

public class ELFunctions
{

	static CompanyDaoImpl DAO;

	/**
	 *
	 */
	static
	{
		ELFunctions.DAO = new CompanyDaoImpl();
	}

	public static boolean hasProduct(final List<Company> company, final String productName)
	{

		for (final Company selectedCompany : company)
		{
			for (final Product p : selectedCompany.getProducts())
			{
				if (productName.equals(p.getName()))
				{
					return true;
				}
			}
		}
		return false;

	}

	public static String numberOfCompanies()
	{

		final int number = 10;
		return new StringBuilder().append(number).toString();
	}

}
