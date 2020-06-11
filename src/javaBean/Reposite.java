package javaBean;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Reposite
{
	protected String name;
	protected ArrayList<Shelf> shelfs;
	
	public Reposite()
	{
		shelfs = new ArrayList<Shelf>();
		name = null;
	}
	
	public ArrayList<Shelf> getShelfs()
	{
		return shelfs;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void addShelf(Shelf shelf)
	{
		if (null == shelf || null == shelf.getName())
			throw new RuntimeException();
		
		shelfs.add(shelf);
	}
	
	public void removeShelf(String name)
	{
		Iterator<Shelf> iterator = shelfs.iterator();
		while (iterator.hasNext())
		{
			if (iterator.next().getName().equals(name))
			{
				iterator.remove();
				break;
			}
		}
		
		throw new RuntimeException("don't have such shelf");
	}

	public Product search(Object key)
	{
		if (null == key)
			throw new RuntimeException("invalid search key");
		
		Product result = null;
		for (Shelf shelf : shelfs)
		{
			if (null != (result = shelf.search(key)))
			{
				return result;
			}
		}
		
		return null;
	}
}
