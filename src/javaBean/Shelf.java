package javaBean;

import java.util.*;

import util.ProductListManager;
import util.ShelfListManager;

public abstract class Shelf
{
	protected String name;
	protected ArrayList<Product> products;
	protected static final int MAX = 12;
	protected ProductListManager ListManager;
	
	public Shelf()
	{
		products = new ArrayList<>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Product> getProducts()
	{
		return products;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void addProduct(Product product)
	{	
		// TODO : 更改数据库
		ListManager.addProduct(product);
	}
	
	public void removeProduct(String id)
	{
		// TODO : 更改数据库
		ListManager.removeProduct(id);
	}

	public abstract Product search(Object key);
}
