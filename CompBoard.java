
public class CompBoard extends ShipBoard
{
	public CompBoard()
     {
       super();
       }
public void setShips()
{
	char[] dir = {'u','d','l','r'};
	int[] sizes = super.getSizes();
	Point[] array;
	Point tempPoint = new Point();
	Ship[] localShips = new Ship[sizes.length];
	int row, column;
	char d;
	boolean notDone;
	
	for(int i = 0; i < sizes.length; i++)
	{
		notDone = true;
		while(notDone)
		{
			row = (int)(Math.random()*10);
			column = (int)(Math.random()*10);
			
			d = dir[(int)(Math.random()*4)];
			
			tempPoint.setRow(row);
			tempPoint.setCol(column);
			localShips[i] = new Ship(sizes[i]);
			
			notDone = !localShips[i].setShip(tempPoint,d);
			
			array = localShips[i].getLocation();
			
			if(!notDone)
			{
				for(int k = 0; k < array.length; k++)
				{
					if(super.getSpot(array[k]) == 'S')
						notDone = true;
				}
			}
			if(!notDone)
			{for(int k = 0; k < array.length; k++)
				super.setSpot(array[k], 'S');
						
				}
			}
			
		}
	}
}
