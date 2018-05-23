import java.util.*;

public class Game {
	private Scanner in = new Scanner(System.in);
	private Player Player1 = new Player();
	private Player Player2 = new Player();
	private int row;
	private int column;
	private int activePlayer;
	private int userOption=1;
	private int opponentOption=1;
	private int PlayOption = 1;
	private boolean CatchError = false;
	private int lives = 1;
	
	
	public Game() {
		activePlayer = 2;
		System.out.println("Welcome to BattleShip!");
		while(PlayOption == 1){

		lives = 1;
		Play();
		if(opponentOption == 2 && userOption == 1) {
			if(activePlayer == 1) {
				activePlayer = 2;
			}else {
				activePlayer = 1;
			}
			PlayerAiTurn();
		}
		if(opponentOption == 2 && userOption == 2) {
			if(activePlayer == 1) {
				activePlayer = 2;
			}else {
				activePlayer = 1;
			}
			AiTurn();
		}
		if(opponentOption == 1 && userOption == 1) {
			if(activePlayer == 1) {
				activePlayer = 2;
			}else {
				activePlayer = 1;
			}
			PlayerTurn();
		}
		System.out.println("The Current Player 1 (" +Player1.name+") wins are:" + Player1.wins);
		System.out.println("The Current Player 2 (" +Player2.name+") wins are:" + Player2.wins);
		System.out.println("Do you want to start another match? (Press 1 for Yes) or (Press 2 for No)");
		PlayOption = in.nextInt();
		
		}
	} 
	public void AiTurn() { //For 2 AIs against each other
		while(lives !=0) {
			if(Player1.lives == 0){
				System.out.println(Player2.name +" Wins");
				Player2.wins++;
				Player2.AiPlays.Ships.Board.printAttackBoard();
				lives = 0;
			}
			if(Player2.lives == 0) {
				System.out.println(Player1.name + " Wins");
				Player1.wins++;
				Player1.AiPlays.Ships.Board.printAttackBoard();
				lives = 0;
			}
			if(Player1.lives != 0 && Player2.lives !=0) {
			switch(activePlayer) {
			case 1:
				System.out.println(Player1.name + "'s (AI) turn");
				Player1.AiPlays.Ships.Board.printAttackBoard();
				row = Player1.AiAttack();
				column = Player1.AiPlays.FirstAttackColumn;
				if(Player2.AiPlays.Ships.Board.isHitAI(column, row)== true) {
					if(Player2.AiPlays.Ships.Board.isDestroyed(column, row) != true) {
						Player1.AiPlays.hitColumn = column;
						Player1.AiPlays.hitRow = row;
					}
					Player1.AiPlays.Ships.Board.attackBoard[row][column] = Constants.Hit_icon;
					Player2.AiPlays.Ships.Board.defenseBoard[row][column] = Constants.Hit_icon;
					Player2.lives--;
				}else {
					if(Player1.AiPlays.Ships.Board.attackBoard[row][column] != Constants.Hit_icon) {
						Player1.AiPlays.Ships.Board.attackBoard[row][column] = Constants.Miss_icon;
						Player2.AiPlays.Ships.Board.defenseBoard[row][column] = Constants.Miss_icon;
					}
					if(Player1.AiOption == 3) {
						Player1.AiPlays.hitColumn = 10;
						Player1.AiPlays.hitRow =10;
					}
				}
				System.out.println("Press 1 to end turn");
				userOption = FindError(userOption);
				activePlayer=2;
				break;
			case 2:
				System.out.println(Player2.name + "'s (AI) turn");
				Player2.AiPlays.Ships.Board.printAttackBoard();
				row = Player2.AiAttack();
				column = Player2.AiPlays.FirstAttackColumn;
				if(Player1.AiPlays.Ships.Board.isHitAI(column, row)== true) {
					if(Player1.AiPlays.Ships.Board.isDestroyed(column, row) != true) {
						Player2.AiPlays.hitColumn = column;
						Player2.AiPlays.hitRow = row;
					}
					Player2.AiPlays.Ships.Board.attackBoard[row][column] = Constants.Hit_icon;
					Player1.AiPlays.Ships.Board.defenseBoard[row][column] = Constants.Hit_icon;
					Player1.lives--;
				}else {
					if(Player2.AiPlays.Ships.Board.attackBoard[row][column] != Constants.Hit_icon) {
						Player2.AiPlays.Ships.Board.attackBoard[row][column] = Constants.Miss_icon;
						Player1.AiPlays.Ships.Board.defenseBoard[row][column] = Constants.Miss_icon;
					}
					if(Player2.AiOption == 3) {
						Player2.AiPlays.hitColumn = 10;
						Player2.AiPlays.hitRow =10;
					}
				}	
				System.out.println("Press 1 to end turn");
				userOption = FindError(userOption);
				activePlayer=1;
				break;
			}
			}
		}
	}
	
	public void PlayerAiTurn() { //For 1 Player vs an AI
		while(lives !=0) {
			if(Player1.lives == 0){
				System.out.println(Player2.name +" Wins");
				Player2.wins++;
				Player2.Ships.Board.printAttackBoard();
				lives = 0;
			}
			if(Player2.lives == 0) {
				System.out.println(Player1.name + " Wins");
				Player1.wins++;
				Player1.Ships.Board.printAttackBoard();
				lives = 0;
			}
			if(Player1.lives != 0 && Player2.lives !=0) {
			switch(activePlayer) {
				case 1:
					System.out.println(Player1.name + "'s turn");
					System.out.println("Press 1 to attack or 2 to view your Defense Board");
					userOption = FindError(userOption);
					if(userOption == 2) {
						System.out.println("Request other person to look away (Press 1 when ready)");
						userOption = FindError(userOption);
						Player1.Ships.Board.printDefenseBoard();
						System.out.println("Press 1 when ready you're ready to attack.");
						userOption = FindError(userOption);
						Player1.Ships.CreateBlankSpace();
					}
					
					System.out.println(Player1.name +" Attacks");
					Player1.Ships.Board.printAttackBoard();
					Attack();
					if(Player2.AiPlays.Ships.Board.isHitPlayer(column, row)== true) {
						Player2.AiPlays.Ships.Board.isDestroyed(column, row);
						Player1.Ships.Board.attackBoard[row][column] = Constants.Hit_icon;

						Player2.AiPlays.Ships.Board.defenseBoard[row][column] = Constants.Hit_icon;
						Player2.lives--;
					}else {
						if(Player1.Ships.Board.attackBoard[row][column] != Constants.Hit_icon) {
							Player1.Ships.Board.attackBoard[row][column] = Constants.Miss_icon;
							Player2.AiPlays.Ships.Board.defenseBoard[row][column] = Constants.Miss_icon; 
						}	
					}
					System.out.println("Press 1 to end turn");
					userOption = FindError(userOption);
					Player1.Ships.CreateBlankSpace();
					activePlayer=2;
					break;
				case 2:
					System.out.println(Player2.name + "'s (AI) turn");
					Player2.AiPlays.Ships.Board.printAttackBoard();
					row = Player2.AiAttack();
					column = Player2.AiPlays.FirstAttackColumn;
					if(Player1.Ships.Board.isHitAI(column, row)== true) {
						Player1.Ships.Board.isDestroyed(column, row);
						Player2.AiPlays.hitColumn = column;
						Player2.AiPlays.hitRow = row;
						Player2.AiPlays.Ships.Board.attackBoard[row][column] = Constants.Hit_icon;
						Player1.Ships.Board.defenseBoard[row][column] = Constants.Hit_icon;
						Player1.lives--;
					}else {
						if(Player2.AiPlays.Ships.Board.attackBoard[row][column] != Constants.Hit_icon) {
							Player2.AiPlays.Ships.Board.attackBoard[row][column] = Constants.Miss_icon;
							Player1.Ships.Board.defenseBoard[row][column] = Constants.Miss_icon;
						}
						if(Player2.AiOption == 3) {
							Player2.AiPlays.hitColumn = 10;
							Player2.AiPlays.hitRow =10;
						}
					}	
					System.out.println("Press 1 to end turn");
					userOption = FindError(userOption);
					Player1.Ships.CreateBlankSpace();
					activePlayer=1;
					break;
			}
		}
		}
	}
	public void PlayerTurn() { //For two players playing against each other
		while(lives !=0) {
			if(Player1.lives == 0){
				System.out.println(Player2.name +" Wins");
				Player2.wins++;
				Player2.Ships.CreateBlankSpace();
				Player2.Ships.Board.printAttackBoard();
				lives = 0;
			}
			if(Player2.lives == 0) {
				System.out.println(Player1.name + " Wins");
				Player1.wins++;
				Player1.Ships.CreateBlankSpace();
				Player1.Ships.Board.printAttackBoard();
				lives = 0;
			}
			
			switch(activePlayer) {
				case 1:
					System.out.println(Player1.name + "'s turn");
					System.out.println("Press 1 to attack or 2 to view your Defense Board");
					userOption = FindError(userOption);
					if(userOption == 2) {
						System.out.println("Request other person to look away (Press 1 when ready)");
						userOption = FindError(userOption);
						Player1.Ships.Board.printDefenseBoard();
						System.out.println("Press 1 when ready you're ready to attack.");
						userOption = FindError(userOption);
						Player1.Ships.CreateBlankSpace();
					}
					
					System.out.println(Player1.name +" Attacks");
					Player1.Ships.Board.printAttackBoard();
					Attack();
					if(Player2.Ships.Board.isHitPlayer(column, row)== true) {
						Player2.Ships.Board.isDestroyed(column, row);
						Player1.Ships.Board.attackBoard[row][column] = Constants.Hit_icon;
						Player2.Ships.Board.defenseBoard[row][column] = Constants.Hit_icon;
						Player2.lives--;
					}else {
						if(Player1.Ships.Board.attackBoard[row][column] != Constants.Hit_icon) {
							Player1.Ships.Board.attackBoard[row][column] = Constants.Miss_icon;
						}	
					}
					System.out.println("Press 1 to end turn");
					userOption = FindError(userOption);
					Player1.Ships.CreateBlankSpace();
					activePlayer=2;
					break;
				case 2:
					System.out.println(Player2.name + "'s turn");
					System.out.println("Press 1 to attack or 2 to view your Defense Board");
					userOption = FindError(userOption);
					if(userOption == 2) {
						System.out.println("Request other person to look away (Press 1 when ready");
						userOption = FindError(userOption);
						Player2.Ships.Board.printDefenseBoard();
						System.out.println("Press 1 when ready you're ready to attack.");
						userOption = FindError(userOption);
						Player2.Ships.CreateBlankSpace();
					}
					System.out.println(Player2.name +" Attacks");
					Player2.Ships.Board.printAttackBoard();
					Attack();
					if(Player1.Ships.Board.isHitPlayer(column, row)== true) {
						System.out.println("Column" + column);
						System.out.println("Row" + row);
						Player1.Ships.Board.isDestroyed(column, row);
						
						Player2.Ships.Board.attackBoard[row][column] = Constants.Hit_icon;
						Player1.Ships.Board.defenseBoard[row][column] = Constants.Hit_icon;
						Player1.lives--;
					}else {
						Player2.Ships.Board.attackBoard[row][column] = Constants.Miss_icon;
					}	
					System.out.println("Press 1 to end turn");
					userOption = FindError(userOption);
					Player1.Ships.CreateBlankSpace();
					activePlayer=1;
					break;
			}
		}
	}
	private void Attack() {
		Scanner in = new Scanner(System.in);
		String columnName = null;
		
		System.out.println("What column do you want to attack? ");
		columnName = in.next();
		columnName = columnName.toUpperCase();
		columnName = columnName.trim();
		column = Board.changeColumn(columnName);
		System.out.println("What row do you want to attack? ");
		row = FindError(row);
		if(row > 10) {
			System.out.println("Please enter a number in the Boundaries");
			Attack();
		}
		row--;

		
	}
	private void Play() {
		
		boolean active = true;
		
		System.out.print("Do you want to play (Press 1) or an AI (Press 2)? ");
			userOption = FindError(userOption);
		switch(userOption) {
			case 1:
				System.out.println("What do you want to name your Player? ");
				Player1.name = in.next();
				break;
			case 2:
				System.out.println("What do you want to name your AI?");
				Player1.name = in.next();
				System.out.println("Generating AI");

				break;
			default:
				System.out.println("You did not enter 1 or 2");
				Play();		
		}
		System.out.print("Do you want to play against another player (Press 1) or an AI (Press 2)? ");
		opponentOption = FindError(opponentOption);
		if(userOption != 1 && opponentOption == 1) {
			System.out.println("Please setup Player 1 as Player");
			Play();
		}
		switch(opponentOption) {
			case 1:
				System.out.println("What do you want to name your Player? ");
				Player2.name = in.next();
				break;
			case 2:
				System.out.println("What do you want to name your AI?");
				Player2.name = in.next();
				System.out.println("Generating AI");
				break;
			default:
				System.out.println("You did not enter 1 or 2");
				Play();	
		}
		if(userOption == 1) {
			System.out.println(Player1.name + "'s turn to place ships.");
			Player1.RealPlayer();
		}else {
			System.out.println( Player1.name +"(AI) is placing Ships.");
			Player1.PlayerAI();
		}
		if(opponentOption == 1) {
			System.out.println(Player2.name + "'s turn to place ships.");
			Player2.RealPlayer();
		}else {
			System.out.println( Player2.name +"(AI) is placing Ships.");
			Player2.PlayerAI();
		}
		

	}
	public int FindError(int option) {
		CatchError = false;
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

}
