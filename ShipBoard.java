import java.util.Scanner;

public class ShipBoard extends Board
{
	private Ship[] ships;
	private int shipsLeft;
	private int[] shipSize = {2, 3 , 4 , 5};
	//345
	public ShipBoard()
	{
		super();
		shipsLeft = shipSize.length;
		ships = new Ship[shipSize.length];
		
		for(int i = 0; i < shipSize.length; i++)
		{
			ships[i] = new Ship(shipSize[i]);
		}
	}
	
	public int[] getSizes()
	{
		return shipSize;
	}
	
	public void setShips(Scanner scan)
	{
		Point p = new Point();
		char d;
		boolean notDone;
		Point[] temp;
		
		for(int i = 0; i < shipSize.length; i++)
		{
			notDone = true;
			while(notDone)
			{
				System.out.println("Set ship size " + shipSize[i]);
				System.out.println("\tStarting X and Y: ");
				p.setRow(scan.nextInt());
				p.setCol(scan.nextInt());
				scan.nextLine();
				
				System.out.println("\tGive Direction (up, down, left or right?)");
				d = scan.nextLine().charAt(0);
				
				notDone = !ships[i].setShip(p, d);
				
				temp = ships[i].getLocation();
				
				if(!notDone)
				{
					for(int k = 0; k < temp.length; k++)
					{
						if(super.getSpot(temp[k]) == 'S')
							notDone = true;
					}
				}
				
				if(notDone)
					System.out.println("Sorry ship was placed in invalid location, try again.");
				else
				{
					for(int k = 0; k < temp.length; k++)
					{
						super.setSpot(temp[k], 'S');
					}
				}
			}		
		}
	}
	
	public boolean shotFired(Point p)
	{
		boolean hit = (super.getSpot(p) == 'S');
		super.shotFired(p, hit);
		return hit;
	}
	
	public boolean hasLost()
	{
		for(int r = 0; r < 10; r++)
		{
			for(int c = 0; c < 10; c++)
			{
				if(super.getSpot(new Point(r, c)) == 'S')
					return false;
			}
		}
		return true;
	}
	
	
}