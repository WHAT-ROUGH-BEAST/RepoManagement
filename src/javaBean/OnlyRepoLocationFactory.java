package javaBean;

public class OnlyRepoLocationFactory implements LocationFactory
{
	@Override
	public OnlyRepoLocation getLocation()
	{
		return new OnlyRepoLocation();
	}
}
