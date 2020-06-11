package javaBean;

import java.util.*;

import util.ProductListManager;

public abstract class Order
{
	protected ArrayList<Product> products;
	protected String name;
	protected ProductListManager ListManager;
	
	public Order()
	{
		products = new ArrayList<>();
	}
	
	public ArrayList<Product> getProducts()
	{
		return products;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void addProduct(Product product) 
	{
		ListManager.addProduct(product);
	}
	
	public void removeProduct(String id)
	{
		ListManager.removeProduct(id);
	}
}
