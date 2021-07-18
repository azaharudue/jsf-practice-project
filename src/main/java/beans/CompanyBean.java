/**
 *
 */
package main.java.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import main.java.daoImpl.CompanyDaoImpl;
import main.java.entities.Company;

/**
 * @author Azahar Hossain
 *
 */

@Named("companyView")
@ViewScoped
public class CompanyBean implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -4337968391362680453L;

	private List<Company> companies = new ArrayList<Company>();

	final CompanyDaoImpl companyDAO;

	private LazyDataModel<Company> companyLazyModel;

	private List<Company> selectedCompanies;

	private Company selectedCompany;

	public CompanyBean() {
		this.companyDAO = new CompanyDaoImpl();

	}

	/**
	 * Deletes selected company
	 */
	public void deleteCompany() {
		try {
			this.companies.remove(this.selectedCompany);
			this.companyDAO.delete(this.selectedCompany);
			this.selectedCompany = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Company removed"));
			PrimeFaces.current().ajax().update("growl", "formCompany:tbl-companies");
			PrimeFaces.current().ajax().update("growl", "formCompany:tbl-companies");
		} catch (final Exception e) {
			e.printStackTrace(System.err);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Company can not be removed, while products exists!"));

		}

	}

	/*
	 * Getters and setters
	 */

	public void deleteSelectedCompanies() {
		this.companies.removeAll(this.selectedCompanies);

		for (final Company companyToBeDeleted : this.selectedCompanies)
			this.companyDAO.delete(companyToBeDeleted);

		this.selectedCompanies = null;

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Companies Removed"));

		PrimeFaces.current().ajax().update("growl", "formCompany:tbl-companies");
	}

	/**
	 * @return the companies
	 */
	public List<Company> getCompanies() {
		return this.companies;
	}

	public LazyDataModel<Company> getCompanyLazyModel() {
		return this.companyLazyModel;
	}

	/**
	 *
	 * @return
	 */
	public String getDeleteButtonMessage() {
		if (this.hasSelectedCompanies()) {
			final int size = this.selectedCompanies.size();
			return size > 1 ? size + " companies selected" : "1 Company selected";
		}

		return "Delete";
	}

	/**
	 * @return the selectedCompanies
	 */
	public List<Company> getSelectedCompanies() {
		return this.selectedCompanies;
	}

	/**
	 * @return the selectedCompany
	 */
	public Company getSelectedCompany() {
		return this.selectedCompany;
	}

	/**
	 *
	 * @return true if companies were selected
	 */
	public boolean hasSelectedCompanies() {
		return (this.selectedCompanies != null) && !this.selectedCompanies.isEmpty();
	}

	@PostConstruct
	public void init() {
		// this.companies = this.companyDAO.findAll();
		this.companyLazyModel = new LazyDataModel<Company>() {

			/**
			 *
			 */
			private static final long serialVersionUID = -1105344323215332439L;

			@Override
			public int getRowCount() {

				return CompanyBean.this.companyDAO.findAll().size();
			}

			@Override
			public Company getRowData(final String rowKey) {
				// TODO Auto-generated method stub
				for (final Company c : CompanyBean.this.companies)
					if (c.getId() == Long.valueOf(rowKey))
						return c;
				return null;
			}

			@Override
			public Long getRowKey(final Company company) {
				// TODO Auto-generated method stub
				return company.getId();
			}

			@Override
			public List<Company> load(final int first, final int pageSize, final String sortField,
					final SortOrder sortOrder, final Map<String, FilterMeta> filterBy) {
				this.setRowCount(this.getRowCount());
				return CompanyBean.this.companyDAO.findPaged(first, pageSize, sortField,
						SortOrder.ASCENDING.equals(sortOrder), filterBy);
			}

		};

	}

	/*
	 * Other methods
	 */
	public void openNew() {
		this.selectedCompany = new Company();
	}

	/**
	 * Saves a company
	 *
	 * @return
	 */

	public String saveCompany() {
		try {
			this.companyDAO.save(this.selectedCompany);
			this.companies.add(this.selectedCompany);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Company created!"));
			PrimeFaces.current().executeScript("PF('dlgCompanyWidgetVar').hide()");
		} catch (final Exception e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(e.getLocalizedMessage(), "Company not created!"));

		}

		return null;
	}

	/**
	 * @param companies
	 *            the companies to set
	 */
	public void setCompanies(final List<Company> companies) {
		this.companies = companies;
	}

	public void setCompanyLazyModel(final LazyDataModel<Company> companyLazyModel) {
		this.companyLazyModel = companyLazyModel;
	}

	/**
	 * @param selectedCompanies
	 *            the selectedCompanies to set
	 */
	public void setSelectedCompanies(final List<Company> selectedCompanies) {
		this.selectedCompanies = selectedCompanies;
	}

	/**
	 * @param selectedCompany
	 *            the selectedCompany to set
	 */
	public void setSelectedCompany(final Company selectedCompany) {
		this.selectedCompany = selectedCompany;
	}

}
