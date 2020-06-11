package javaBean;

public class OnlyReposite extends Reposite
{
	@Override
	public String getName()
	{
		throw new RuntimeException("OnlyReposite doesn't support this feature");
	}
	
	@Override
	public void setName(String name)
	{
		throw new RuntimeException("OnlyReposite doesn't support this feature");
	}
}
