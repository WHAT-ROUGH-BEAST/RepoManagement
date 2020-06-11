package util;

import java.util.List;

import javaBean.Product;

public class ShelfListManager extends ProductListManager
{
	private static int MAX;

	public ShelfListManager(List<Product> products, final int MAX)
	{
		super(products);
		this.MAX = MAX;
	}

	@Override
	public void addProduct(Product product)
	{
		if (null == product || null == product.getId() 
				|| null == product.getLocation())
			throw new RuntimeException("invalid product");
		
		Product adder = mergeProduct(product);
		
		products.add(adder);
		
		// 超出限制大小
		if (products.size() > MAX)
		{
			products.remove(adder);
			throw new RuntimeException("shelf oversize");
		}
	}
}
