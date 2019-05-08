import java.util.Scanner;
public class BattleshipGame 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		CompBoard myBoard = new CompBoard();
		ShipBoard playerBoard = new ShipBoard();
		
		myBoard.output();
		myBoard.setShips();
		playerBoard.setShips(scan);
		//playerBoard.shotFired();
		playerBoard.hasLost();
	}
}
		