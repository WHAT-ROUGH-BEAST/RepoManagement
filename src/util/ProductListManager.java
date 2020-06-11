package util;

import java.util.Iterator;
import java.util.List;

import javaBean.Product;

public abstract class ProductListManager
{
	protected List<Product> products;
	
	public ProductListManager(final List<Product> products)
	{
		this.products = products;
	}
	
	public abstract void addProduct(Product product);
	
	public void removeProduct(String id)
	{
		if (null == id)
			throw new RuntimeException("invalid id");
		
		Iterator<Product> iterator = products.iterator();
		
		while (iterator.hasNext())
		{
			if (iterator.next().getId().equals(id))
			{
				iterator.remove();
				return;
			}
		}
	}
	
	protected Product mergeProduct(Product product)
	{
		for (Product p : products)
		{
			if (p.getId().equals(product))
			{
				products.remove(p);
				p.setAmount(p.getAmount() + product.getAmount());
				return p;
			}
		}
		
		return product;
	}
}
