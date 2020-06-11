package javaBean;

import util.OrderListManager;

public class SimpleOrder extends Order
{
	public SimpleOrder()
	{
		super();
		ListManager = new OrderListManager(products);
	}
}
