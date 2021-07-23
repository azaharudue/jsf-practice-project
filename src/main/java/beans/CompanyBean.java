/**
 *
 */
package main.java.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import main.java.daoImpl.CompanyDaoImpl;
import main.java.entities.Company;
import main.java.lazyModels.CompanyLazyModel;

/**
 * @author Azahar Hossain
 *
 */

@Named("companyView")
@ViewScoped
public class CompanyBean implements Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = -4337968391362680453L;

	private List<Company> companies = new ArrayList<Company>();

	final CompanyDaoImpl companyDAO;

	private LazyDataModel<Company> companyLazyModel;

	private Company createdCompany;

	private List<Company> selectedCompanies;

	private Company selectedCompany;

	public CompanyBean()
	{
		this.companyDAO = new CompanyDaoImpl();

	}

	/**
	 * Deletes selected company
	 */
	public void deleteCompany()
	{
		try
		{
			this.companies.remove(this.selectedCompany);
			this.companyDAO.delete(this.selectedCompany);
			this.selectedCompany = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Company removed"));
		}
		catch (final Exception e)
		{
			e.printStackTrace(System.err);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Company can not be removed, while products exists!"));

		}

	}

	/*
	 * Getters and setters
	 */

	public void deleteSelectedCompanies()
	{
		this.companies.removeAll(this.selectedCompanies);

		for (final Company companyToBeDeleted : this.selectedCompanies)
			this.companyDAO.delete(companyToBeDeleted);

		this.selectedCompanies = null;

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Companies Removed"));

	}

	/**
	 * @return the companies
	 */
	public List<Company> getCompanies()
	{
		return this.companies;
	}

	public LazyDataModel<Company> getCompanyLazyModel()
	{
		return this.companyLazyModel;
	}

	public Company getCreatedCompany()
	{
		return this.createdCompany;
	}

	/**
	 * @return the selectedCompanies
	 */
	public List<Company> getSelectedCompanies()
	{
		return this.selectedCompanies;
	}

	/**
	 * @return the selectedCompany
	 */
	public Company getSelectedCompany()
	{
		return this.selectedCompany;
	}

	@PostConstruct
	public void init()
	{
		// this.companies = this.companyDAO.findAll();
		this.companyLazyModel = new CompanyLazyModel();

	}

	/*
	 * Other methods
	 */

	public void openNew()
	{
		this.createdCompany = new Company();

	}

	/**
	 * Saves a company
	 *
	 * @return
	 */

	public String saveCompany()
	{
		try
		{
			this.companyDAO.save(this.selectedCompany);
			this.companies.add(this.selectedCompany);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Company Updated!"));

		}
		catch (final Exception e)
		{

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getLocalizedMessage(), "Company not updated!"));

		}

		return null;
	}

	/**
	 * Saves a company
	 *
	 * @return
	 */

	public void saveNewCompany()
	{
		try
		{
			this.companyDAO.save(this.createdCompany);
			this.companies.add(this.createdCompany);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Company created!", "Company created!"));
			this.createdCompany = new Company();

		}
		catch (final Exception e)
		{

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Company not created!", "Company not created!"));

		}

	}

	/**
	 * @param companies the companies to set
	 */
	public void setCompanies(final List<Company> companies)
	{
		this.companies = companies;
	}

	public void setCompanyLazyModel(final LazyDataModel<Company> companyLazyModel)
	{
		this.companyLazyModel = companyLazyModel;
	}

	public void setCreatedCompany(final Company createdCompany)
	{
		this.createdCompany = createdCompany;
	}

	/**
	 * @param selectedCompanies the selectedCompanies to set
	 */
	public void setSelectedCompanies(final List<Company> selectedCompanies)
	{
		this.selectedCompanies = selectedCompanies;
	}

	/**
	 * @param selectedCompany the selectedCompany to set
	 */
	public void setSelectedCompany(final Company selectedCompany)
	{
		this.selectedCompany = selectedCompany;
	}

}
