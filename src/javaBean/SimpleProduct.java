package javaBean;

public class SimpleProduct extends Product
{
	@Override
	public SimpleProduct clone()
	{
		SimpleProduct clone = new SimpleProduct();
		clone.amount = amount;
		clone.id = id;
		clone.location = location;
		return clone;
	}
}
