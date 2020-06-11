package util;

import java.util.List;

import javaBean.Product;

public class OrderListManager extends ProductListManager
{
	public OrderListManager(List<Product> products)
	{
		super(products);
	}

	@Override
	public void addProduct(Product product)
	{
		if (null == product || null == product.getId() 
				|| null == product.getLocation())
			throw new RuntimeException("invalid product");
		
		Product adder = mergeProduct(product);
		
		// 检查是否超过库存
		// TODO : 访问数据库  
		
		products.add(adder);
	}
}
