import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
	private Scanner in = new Scanner(System.in);
	public String name = "Player";
	public int lives;
	public Ship Ships;
	public int wins = 0;
	public int AiOption = 0;
	public AI AiPlays = new AI();
	
	public void RealPlayer() {
		// TODO Auto-generated method stub
		lives = Constants.Lives;
		Ships = new Ship();
		Ships.PlayerStart();
	}
	public void PlayerAI() {
		// TODO Auto-generated method stub
		Ships = new Ship();
		lives = Constants.Lives;
		System.out.println("Chose your Difficulty for " +name+ ": (1 for easy) (2 for Medium) (3 for Hard)");
		AiOption = FindError(AiOption);
		
		switch(AiOption) {
			case 1:
				System.out.println("Starting level 1 AI");
				AiPlays.AI();
				AiPlays.Lvl1Place();
				break;
			case 2:
				System.out.println("Starting level 2 AI");
				AiPlays.AI();
				AiPlays.Lvl2or3Place();
				break;
			case 3:
				System.out.println("Starting level 3 AI");
				AiPlays.AI();
				AiPlays.Lvl2or3Place();
				break;
			default:	
				System.out.println("Please Select a valid difficulty");
				PlayerAI();
				break;
		}
		
	}
	public int FindError(int option) {
		boolean CatchError = false;
		do {
			try {
				option = in.nextInt();
				CatchError = true;
			}catch(InputMismatchException ex) {
				CatchError = false;
				System.out.println("You have entered a letter when you need to enter a number");
				System.out.println("Please try again");
				in.nextLine();
			}
		}while(CatchError == false);
		return option;
	}
	public int AiAttack() {
		switch(AiOption) {
		case 1:
			return AiPlays.Lvl1Attack();
		case 2:
			return AiPlays.Lvl2Attack();
		case 3:
			return AiPlays.Lvl3Attack();

		default:
			System.out.println("Your AI has failed, the match will start over.");
			PlayerAI();
			return 0;
		}
	}
}
