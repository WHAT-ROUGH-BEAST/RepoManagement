package util;

import java.util.List;

import javaBean.Product;
import javaBean.ProductListContainer;

public class UnlmtProductNumShelfListManager extends ProductListManager
{
	private static int MAX;

	public UnlmtProductNumShelfListManager(List<Object> attrs)
	{
		super(((ProductListContainer) attrs.get(0)).getProducts());
		UnlmtProductNumShelfListManager.MAX = (int) 
				((ProductListContainer) attrs.get(0)).getAttrs().get("maxShelfNum");
	}

	@Override
	public void addProduct(Product product) throws Exception
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
			throw new Exception("shelf oversize");
		}
		
		// TODO : 数据库
	}
	
	@Override
	public void removeProduct(String id)
	{
		try
		{
			super.removeProduct(id);
			// TODO : 数据库
		}
		catch (Exception e)
		{
			throw e;
		}
	}
}
