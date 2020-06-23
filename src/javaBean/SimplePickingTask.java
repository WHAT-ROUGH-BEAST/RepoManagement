package javaBean;

import java.util.LinkedList;
import java.util.List;

import util.ProductListManager;

public class SimplePickingTask extends PickingTask
{	
	public SimplePickingTask(List<Object> attr)
	{
		super((LinkedList<Product>) attr.get(0));
	}

	@Override
	public void done(String id)
	{
		if (null == id)
			throw new RuntimeException();
		
		for (Product p : taskItems)
		{
			if (p.getId().equals(id))
			{
				taskItems.remove(p);
				return;
			}
		}
		
		throw new RuntimeException("can't find product id: " + id);
	}
	
}
