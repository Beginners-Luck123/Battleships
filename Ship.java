public class Ship 
{
	//Variables
	private int size;
	private int hitsLeft;
	private Point[] points;
	
	//Constructors
	//Set size and hits left to -1 DO NOT create an array
	public Ship()
	{
		size = -1;
		hitsLeft = -1;
	}
	
	//Set size and hitsLeft to s and then create new array of size s
	public Ship(int s)
	{
		size = s;
		hitsLeft = s;
		points = new Point[s];
	}
	
	//Methods
	//Take 1 away from hitsLeft
	public void getHit()
	{
		hitsLeft--;
	}
	
	//Return points array
	public Point[] getLocation()
	{
		return points;
	}
	
	//checks to see if hits left is <= 0
	public boolean isSunk()
	{
		if(hitsLeft <= 0)
			return true;
		else
			return false;
	}
	
	//Set hits left back to size
	public void reset()
	{
		hitsLeft = size;
	}

	public String toString()
	{
		String out = "";
		
		for(int i = 0; i < size; i++)
		{
			out += "(" + points[i].getRow() + ", " + points[i].getCol() + ") ";
		}
		
		return out;
	}
	
	//Preconditions: Start should be point whose x and y values are between	0 and 9
	//				 Dir is the direction of ship values should be: u, d, r or l
	//					stands for up, down, right, or left
	public boolean setShip(Point start, char dir)
	{
		int change;
		
		if((dir == 'u') && (start.getRow() - (size -1) < 0))
			return false;
		else if ((dir == 'd') && (start.getRow() + (size-1) > 9))
			return false;
		else if ((dir == 'r') && (start.getCol() + (size-1) > 9))
			return false;
		else if ((dir == 'l') && (start.getCol() - (size -1) < 0))
			return false;
		
		if((dir == 'u') || (dir == 'l'))
			change = -1;
		else 
			change = 1;
		
		for(int i = 0; i < size; i++)
		{
			if(dir == 'u' || dir == 'd')
				points[i] = new Point(start.getRow() + (change*i), start.getCol());
			else
				points[i] = new Point(start.getRow(), start.getCol() + (change*i));
		}
					
		return true;
	}

}