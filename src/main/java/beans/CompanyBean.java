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

import org.primefaces.PrimeFaces;

import main.java.daoImpl.CompanyDaoImpl;
import main.java.entities.Company;

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

	final CompanyDaoImpl companyDAO;

	private List<Company> companies = new ArrayList<Company>();

	private Company selectedCompany;

	private List<Company> selectedCompanies;

	public CompanyBean()
	{
		this.companyDAO = new CompanyDaoImpl();

	}

	@PostConstruct
	public void init()
	{
		this.companies = this.companyDAO.findAll();

	}

	/*
	 * Getters and setters
	 */

	/**
	 * @return the companies
	 */
	public List<Company> getCompanies()
	{
		return this.companies;
	}

	/**
	 * @param companies the companies to set
	 */
	public void setCompanies(final List<Company> companies)
	{
		this.companies = companies;
	}

	/**
	 * @return the selectedCompany
	 */
	public Company getSelectedCompany()
	{
		return this.selectedCompany;
	}

	/**
	 * @param selectedCompany the selectedCompany to set
	 */
	public void setSelectedCompany(final Company selectedCompany)
	{
		this.selectedCompany = selectedCompany;
	}

	/**
	 * @return the selectedCompanies
	 */
	public List<Company> getSelectedCompanies()
	{
		return this.selectedCompanies;
	}

	/**
	 * @param selectedCompanies the selectedCompanies to set
	 */
	public void setSelectedCompanies(final List<Company> selectedCompanies)
	{
		this.selectedCompanies = selectedCompanies;
	}

	/*
	 * Other methods
	 */
	public void openNew()
	{
		this.selectedCompany = new Company();
	}

	public void deleteSelectedCompanies()
	{
		this.companies.removeAll(this.selectedCompanies);

		for (final Company companyToBeDeleted : this.selectedCompanies)
			this.companyDAO.delete(companyToBeDeleted);

		this.selectedCompanies = null;

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Companies Removed"));

		PrimeFaces.current().ajax().update("growl", "formCompany:tbl-companies");
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
			PrimeFaces.current().ajax().update("growl", "formCompany:tbl-companies");
			PrimeFaces.current().ajax().update("growl", "formCompany:tbl-companies");
		}
		catch (final Exception e)
		{
			e.printStackTrace(System.err);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Company can not be removed, while products exists!"));

		}

	}

	/**
	 *
	 * @return
	 */
	public String getDeleteButtonMessage()
	{
		if (this.hasSelectedCompanies())
		{
			final int size = this.selectedCompanies.size();
			return size > 1 ? size + " companies selected" : "1 Company selected";
		}

		return "Delete";
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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Company created!"));
			PrimeFaces.current().executeScript("PF('dlgCompanyWidgetVar').hide()");
		}
		catch (final Exception e)
		{

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getLocalizedMessage(), "Company not created!"));

		}

		return null;
	}

	/**
	 *
	 * @return true if companies were selected
	 */
	public boolean hasSelectedCompanies()
	{
		return (this.selectedCompanies != null) && !this.selectedCompanies.isEmpty();
	}

}
