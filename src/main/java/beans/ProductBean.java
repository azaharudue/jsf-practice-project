package main.java.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import main.java.daoImpl.ProductDaoImpl;
import main.java.entities.Product;

@Named("basicView")
@ViewScoped
public class ProductBean implements Serializable
{

	private static final long serialVersionUID = -3816399998127217254L;

	private final ProductDaoImpl productDAO;

	private List<Product> products = new ArrayList<Product>();

	public ProductBean()
	{
		System.out.println("basicView construct");

		this.productDAO = new ProductDaoImpl();
	}

	@PostConstruct
	public void populateProductList()
	{
		this.products = this.productDAO.findAll();
	}

	public List<Product> getProducts()
	{
		return this.products;
	}

	public void onRowEdit(RowEditEvent<Product> event)
	{
		final FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject().getCode()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<Product> event)
	{
		final FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getCode()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}