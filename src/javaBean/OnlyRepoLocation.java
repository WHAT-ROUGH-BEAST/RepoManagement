package javaBean;

// Location
public class OnlyRepoLocation extends Location
{
	@Override
	public void setLocation(String r, String s, int p)
	{
		shelf = s;
		pos = p;
		repo = null;
	}
	
	@Override
	public String getRepo()
	{
		throw new RuntimeException("OnlyRepoLocation doesn't support this feature");
	}
	
	@Override
	public String toString()
	{
		return shelf + "-" + pos;
	}
}
