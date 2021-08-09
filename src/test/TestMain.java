package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.jsftest.main.java.daoImpl.CompanyDaoImpl;
import com.jsftest.main.java.daoImpl.ProductDaoImpl;
import com.jsftest.main.java.entities.Company;
import com.jsftest.main.java.entities.Product;

public class TestMain
{

	private static List<Company> companies = new ArrayList<Company>();

	private static List<Product> products = new ArrayList<Product>();

	public static void main(final String[] args)
	{
		// TODO Auto-generated method stub
		final ProductDaoImpl productDAO = new ProductDaoImpl();

		final CompanyDaoImpl companyDAO = new CompanyDaoImpl();

		// Add new product
		final Product newproduct = new Product();
		newproduct.setName("Demo Product 2");
		newproduct.setPrice(BigDecimal.valueOf(200.00));

		// Add new company
		final Company newCompany = new Company();
		newCompany.setName("Another company");
		newCompany.setLocation("Another location");

		// first save the company
		companyDAO.save(newCompany);

		// Set the company into the product
		newproduct.setCompany(newCompany);

		productDAO.save(newproduct);

		try
		{
			for (final Product product : productDAO.findAll())
				if (product != null)
					TestMain.products = productDAO.findAll();

			for (final Company company : companyDAO.findAll())
				if (company != null)
					TestMain.companies = companyDAO.findAll();

		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(TestMain.products);
		System.out.println(TestMain.companies);
	}

}
