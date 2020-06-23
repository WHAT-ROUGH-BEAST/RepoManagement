package javaBean;

import java.util.LinkedList;

public abstract class PickingTask
{
	protected LinkedList<Product> taskItems;
	
	public PickingTask(LinkedList<Product> products)
	{
		this.taskItems = products;
	}
	
	abstract void done(String id);
	
	public LinkedList<Product> getTaskItems()
	{
		return taskItems;
	}
}
