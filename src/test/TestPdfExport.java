
package test;

import java.util.ArrayList;
import java.util.List;

import com.jsftest.main.java.daoImpl.CompanyDaoImpl;
import com.jsftest.main.java.daoImpl.ProductDaoImpl;
import com.jsftest.main.java.entities.Company;
import com.jsftest.main.java.entities.Product;

public class TestPdfExport
{

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String[] args) throws Exception
	{
		final CompanyDaoImpl companyDAO = new CompanyDaoImpl();
		final ProductDaoImpl productDAO = new ProductDaoImpl();
		List<Company> companies = new ArrayList<Company>();
		List<Product> products = new ArrayList<Product>();
		try
		{
			for (final Product product : productDAO.findAll())
				if (product != null)
					products = productDAO.findAll();

			for (final Company company : companyDAO.findAll())
				if (company != null)
					companies = companyDAO.findAll();

		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}

	}

}
