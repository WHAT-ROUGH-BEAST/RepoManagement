package javaBean;

import util.ShelfListManager;

public class SimpleShelf extends Shelf
{
	public SimpleShelf()
	{
		super();
		ListManager = new ShelfListManager(products, MAX);
	}
	
	@Override
	public Product search(Object key)
	{
		if (null == key)
			throw new RuntimeException("invalid search key");
		
		for (Product product : products)
		{
			if ((key instanceof String && product.getId().equals(key))
					|| (key instanceof Location && product.getLocation().equals(key)))
				return product;
		}
		
		return null;
	}
}
