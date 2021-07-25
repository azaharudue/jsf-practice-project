
package test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import main.java.daoImpl.CompanyDaoImpl;
import main.java.daoImpl.ProductDaoImpl;
import main.java.entities.Company;
import main.java.entities.Product;
import main.java.utils.PrintUtils;

public class TestPdfExport
{

	public static Configuration getConfig() throws Exception
	{
		try
		{
			final Configuration cfg = new Configuration();
			cfg.setDirectoryForTemplateLoading(new File("D:\\azahar\\dev\\code\\jsf-practice-project\\src\\main\\resources\\templates"));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			return cfg;
		}
		catch (final Exception e)
		{
			throw e;
		}

	}

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
