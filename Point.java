public class Point 
{
	private int rowValue;
	private int colValue;
	
	public Point()
	{
		rowValue = -1;
		colValue = -1;
	}
	
	public Point(int x, int y)
	{
		rowValue = x;
		colValue = y;
	}
	
	public int getRow()
	{
		return rowValue;
	}
	
	public int getCol()
	{
		return colValue;
	}
	
	public void setRowCol(int x, int y)
	{
		rowValue = x;
		colValue = y;
	}
	
	public void setRow (int x)
	{
		rowValue = x;
	}

	public void setCol(int y)
	{
		colValue = y;
	}
}