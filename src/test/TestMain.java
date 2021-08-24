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

		TestMain.testProductsAndCompanies();
		/*
		 * for (final TimeZone t : TimeZoneConverter.getAvailableTimeZones())
		 * System.out.println(t); System.out.println("Total size: " +
		 * TimeZoneConverter.getAvailableTimeZones().size());
		 */

	}

	/**
	 *
	 */
	public static void testProductsAndCompanies()
	{
		// Add new product
		// final Product newproduct = new Product();
		// newproduct.setName("Demo Product 2");
		// newproduct.setPrice(BigDecimal.valueOf(200.00));
		//
		// // Add new company
		// final Company newCompany = new Company();
		// newCompany.setName("Another company");
		// newCompany.setLocation("Another location");
		//
		// // first save the company
		// TestMain.companyDAO.save(newCompany);
		//
		// // Set the company into the product
		// newproduct.setCompany(newCompany);
		//
		// TestMain.productDAO.save(newproduct);

		try
		{
			/*
			 * for (final Product product : TestMain.productDAO.findAll()) if
			 * (product != null) TestMain.products =
			 * TestMain.productDAO.findAll();
			 */
			for (final Company company : TestMain.companyDAO.findAll())
				if (company != null)
					TestMain.companies = TestMain.companyDAO.findAll();

		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		// System.out.println(TestMain.products);
		System.out.println(TestMain.companies);
	}

}
