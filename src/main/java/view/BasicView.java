package main.java.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import main.java.daoImpl.ProductDaoImpl;
import main.java.entities.Product;

@Named("basicView")
@RequestScoped
public class BasicView implements Serializable
{

	private static final long serialVersionUID = -3816399998127217254L;

	private List<Product> products = new ArrayList<Product>();

	public BasicView()
	{
		// TODO Auto-generated constructor stub
		System.out.println("basicView construct");
	}

	@Inject
	private ProductDaoImpl daoImpl;

	@PostConstruct
	public void populateProductList()
	{
		this.products = this.daoImpl.findAll();
	}

	public List<Product> getProducts()
	{
		return this.products;
	}

}