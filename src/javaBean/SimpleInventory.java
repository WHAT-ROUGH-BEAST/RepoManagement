package javaBean;

import util.Location;
import util.LocationFactory;
import util.XMLUtil;
import java.util.*;

public class SimpleInventory implements Inventory
{
	private HashMap<String, Integer> changeRecord;
	private Product currProduct;
	private Reposite registeredReposite;
	
	public SimpleInventory(Reposite registeredReposite)
	{
		if (null == registeredReposite)
			throw new RuntimeException();
		
		this.registeredReposite = registeredReposite;
		
		changeRecord = new HashMap<>();
	}
	
	private Product getProduct(String repo, String shelf, int loc)
	{
		if (null == repo || null == shelf || loc < 0)
			throw new RuntimeException();
		
		Location l = ((LocationFactory) XMLUtil.
				getBean("LocationFactoryconfig")).getLocation();
		l.setLocation("defaultReposite", shelf, loc);
		
		Product product = registeredReposite.search(l);
		currProduct = product;
		
		return product;
	}
	
	@Override
	public String getId(String repo, String shelf, int loc)
	{
		return getProduct(repo, shelf, loc).getId();
	}

	@Override
	public int getAmount(String repo, String shelf, int loc)
	{
		return getProduct(repo, shelf, loc).getAmount();
	}

	@Override
	public void modifyAmount(int amount)
	{
		if (amount < 0)
			throw new RuntimeException();
		
		changeRecord.put(currProduct.getId(), amount - currProduct.getAmount());
		
		currProduct.setAmount(amount);
	}

	/*
	 * 以printreport作为一次盘点的结束，清空记录列表
	 */
	@Override
	public HashMap<String, Integer> printReport()
	{
		HashMap<String, Integer> map = changeRecord;
		
		// 本次盘点结束
		changeRecord = new HashMap<>();
		
		return map;
	}
}
