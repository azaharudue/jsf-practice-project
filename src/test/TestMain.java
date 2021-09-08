package test;

import java.util.ArrayList;
import java.util.List;

import com.jsftest.main.java.daoImpl.CompanyDaoImpl;
import com.jsftest.main.java.daoImpl.ProductDaoImpl;
import com.jsftest.main.java.entities.Company;
import com.jsftest.main.java.entities.Product;

public class TestMain
{

	private static List<Company> companies = new ArrayList<Company>();

	final static CompanyDaoImpl companyDAO = new CompanyDaoImpl();

	final static ProductDaoImpl productDAO = new ProductDaoImpl();

	private static List<Product> products = new ArrayList<Product>();

	public static void main(final String[] args)
	{
		// Test companies
		// TestMain.testCompanies();

		// Test products
		TestMain.testProducts();

	}

	/**
	 *
	 */
	public static void testCompanies()
	{

		try
		{
			/*
			 * for (final Product product : TestMain.productDAO.findAll()) if
			 * (product != null) TestMain.products =
			 * TestMain.productDAO.findAll();
			 */
			for (final Company company : TestMain.companyDAO.findAll())
				TestMain.companies.add(company);
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}

		System.out.println(TestMain.companies.size());
	}

	/**
	 *
	 */
	public static void testProducts()
	{

		try
		{

			System.out.println(TestMain.productDAO.findById(Long.valueOf(1628)));

			/*
			 * for (final Product product : TestMain.productDAO.findAll())
			 * TestMain.products.add(product);
			 *
			 * final Company company =
			 * TestMain.companyDAO.findById(Long.valueOf((long) 14.0));
			 *
			 * final Product newProduct = new Product("Product DD",
			 * BigDecimal.valueOf(150.0), company, new
			 * ProductDepositData(BigDecimal.valueOf(150.0),
			 * ProductDepositSystem.REUSE)); //
			 * TestMain.productDAO.save(newProduct);
			 *
			 * System.out.println(newProduct.toString());
			 */
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		// System.out.println(TestMain.products);
		// System.out.println(TestMain.products);
	}

}
