public class Board
{
	private char[][] grid;
	
	//Initializes grid to a 10 x 10 full of ~
	public Board()
	{
		grid = new char[10][10];
		reset();
	}

	//Returns the character located at point
	public char getSpot(Point point)
	{
		return grid[point.getRow()][point.getCol()];
	}

	//Sets the given point to the give character
	public void setSpot(Point point, char c)
	{
		grid[point.getRow()][point.getCol()] = c;
	}

	//Updates grid to show a shot at "point" if hit = true mark with x if it is false mark with o
	public void shotFired(Point point, boolean hit)
	{
		if(hit)
			setSpot(point, 'X');
		else
			setSpot(point, 'O');
	}	

	//Resets all of board to ~
	public void reset()
	{
		for(int r = 0; r < grid.length; r++)
			for(int c = 0; c < grid[r].length; c++)
				grid[r][c] = '~';
	}

	//Outputs current state of grid
	public void output()
	{
		System.out.print("_");
		for(int i = 0; i<10; i++)
		{
			System.out.print("_" + i);
		}
		System.out.println("_");
		
		for(int r = 0; r<10; r++)
		{	
			System.out.print(r);
		
			for(int c = 0; c<10; c++)
			{
				System.out.print("|" + grid[r][c]);
			}
			System.out.println("|");
		}
	}
	
}