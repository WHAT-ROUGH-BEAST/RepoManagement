package javaBean;

public abstract class Product implements Cloneable
{
	protected String id;
	protected int amount;
	protected Location location;
	
	// getter
	public String getId()
	{
		return id;
	}
	
	public int getAmount()
	{
		return amount;
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	// setter
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	
	public void setLocation(Location location)
	{
		this.location = location;
	}
	
	public abstract Product clone();
}