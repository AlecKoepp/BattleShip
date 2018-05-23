import java.util.InputMismatchException;
import java.util.Scanner;

public class Ship {
	private Scanner in = new Scanner(System.in);
	public Board Board = new Board();
	private int ColumnStart = 0;
	private int RowStart = 0;
	private int ColumnDistance = 0;
	private int RowDistance = 0;
	private int ColumnEnd = 0;
	private int RowEnd = 0;
	private String ColumnName = null;
	private boolean size = false;
	private boolean CatchError = false;
	
	
	public void PlayerStart() {
		Board.createBoards();
		createShips();
	}
	public void AiStart() {
		Board.createBoards();
	}
	
	private void createShips() { //Allows Player to Select Ship Locations
		Board.printDefenseBoard();
		System.out.println("Board is above for reference.");
		placeCarrier();
		Board.printDefenseBoard();
		System.out.println("Board is above for reference.");
		placeBattleship();
		Board.printDefenseBoard();
		System.out.println("Board is above for reference.");
		placeCruiser();
		Board.printDefenseBoard();
		System.out.println("Board is above for reference.");
		placeSubmarine();
		Board.printDefenseBoard();
		System.out.println("Board is above for reference.");
		placeDestroyer();
		Board.printDefenseBoard();
		CreateBlankSpace();
		System.out.println("Congrats you finished your Board");
		CreateBlankSpace() ;
		
	}
	private void placeCarrier() { //Asks Questions to place Carrier
		size = false;
		
		
		while(size == false){	//Make sure that the size is as labeled
			size = true;
			System.out.println("What Column do you want to start your Carrier? (5 Spaces long) ");
				BeginColumn();
			System.out.println("What Row do you want to start? ");
				BeginRow();
			System.out.println("What Column do you want to End your Carrier? ");
				FinishColumn();
			System.out.println("What Row do you want to End? ");
				FinishRow();
			
			
			if(isDiagonal(ColumnDistance,RowDistance) == true) {
				size = false;
			}

			if(size == true) {
				if(RowDistance == 0 ) {
					if(ColumnDistance == 4) {
						while(true){
							Board.defenseBoard[RowStart][ColumnStart] = Constants.Carrier_icon;
							if(ColumnStart == ColumnEnd) {
								break;
							}
							if(ColumnStart > ColumnEnd) {
								ColumnStart--;
							}else {
							ColumnStart++;
							}
						}
					
						while(true) {
							Board.defenseBoard[RowStart][ColumnStart]= Constants.Carrier_icon;
							
							if(RowStart == RowEnd) {
								break;
							}
							if(RowStart > RowEnd) {
								RowStart--;
							}else{
								RowStart++;
							}
						}
						size = true;
					}else{
						System.out.println("The Size you entered horizontally wasn't 5 spaces, please try again.");
						size = false;	
					}
				}
				if(ColumnDistance == 0) {
					if(RowDistance == 4) {
						while(true){
							Board.defenseBoard[RowStart][ColumnStart] = Constants.Carrier_icon;
							if(ColumnStart == ColumnEnd) {
								break;
							}
							if(ColumnStart > ColumnEnd) {
								ColumnStart--;
							}else{
							ColumnStart++;
							}
						}
					
						while(true) {
							Board.defenseBoard[RowStart][ColumnStart]= Constants.Carrier_icon;
							
							if(RowStart == RowEnd) {
								break;
							}
							if(RowStart > RowEnd) {
								RowStart--;
							}else{
								RowStart++;
							}
						}
						size = true;
					}else{
						System.out.println("The Size you entered vertically wasn't 5 spaces, please try again.");
						size = false;	
					}				
				}
			}
		}
	}
	private void placeBattleship()  { //Asks Questions to place Battleship
		 size = false;
		
		
		while(size == false){	//Make sure that the size is as labeled
			size = true;
			System.out.println("What Column do you want to start your Battleship? (4 Spaces long) ");
				BeginColumn();
			System.out.println("What Row do you want to start? ");
				BeginRow();
			System.out.println("What Column do you want to End your Batlleship? ");
				FinishColumn();
			System.out.println("What Row do you want to End? ");
				FinishRow();
			
			if(isDiagonal(ColumnDistance,RowDistance) == true) {
				size = false;
			}
			if(isOverlap(ColumnStart,ColumnEnd,RowStart,RowEnd) == true) {
				size = false;	
			}
			if(size == true) {
				if(RowDistance == 0 ) {
					if(ColumnDistance == 3) {
						while(true){
							Board.defenseBoard[RowStart][ColumnStart] = Constants.BattleShip_icon;
							if(ColumnStart == ColumnEnd) {
								break;
							}
							if(ColumnStart > ColumnEnd) {
								ColumnStart--;
							}else{
							ColumnStart++;
							}
						}
					
						while(true) {
							Board.defenseBoard[RowStart][ColumnStart]= Constants.BattleShip_icon;
							
							if(RowStart == RowEnd) {
								break;
							}
							if(RowStart > RowEnd) {
								RowStart--;
							}else{
								RowStart++;
							}
						}
						size = true;
					}else{
						System.out.println("The Size you entered wasn't 4 spaces, please try again.");
						size = false;						}
					}
				if(ColumnDistance == 0) {
					if(RowDistance == 3) {
						while(true){
							Board.defenseBoard[RowStart][ColumnStart] = Constants.BattleShip_icon;
							if(ColumnStart == ColumnEnd) {
								break;
							}	
							if(ColumnStart > ColumnEnd) {
								ColumnStart--;
							}else {
								ColumnStart++;
							}
						}
					
						while(true) {
							Board.defenseBoard[RowStart][ColumnStart]= Constants.BattleShip_icon;
							
							if(RowStart == RowEnd) {
								break;
							}
							if(RowStart > RowEnd) {
								RowStart--;
							}else{
								RowStart++;
							}
						}
						size = true;
					}else{
						System.out.println("The Size you entered wasn't 4 spaces, please try again.");
						size = false;						}
					}
				}
			}
		}
	private void placeCruiser() { //Asks Questions to place Cruiser
		size = false;
		
		
		while(size == false){	//Make sure that the size is as labeled
			size = true;
			System.out.println("What Column do you want to start your Cruiser? (3 Spaces long) ");
				BeginColumn();
			System.out.println("What Row do you want to start? ");
				BeginRow();
			System.out.println("What Column do you want to End your Cruiser? ");
				FinishColumn();
			System.out.println("What Row do you want to End? ");
				FinishRow();
				
			if(isDiagonal(ColumnDistance,RowDistance) == true) {
				size = false;
			}			
			if(isOverlap(ColumnStart,ColumnEnd,RowStart,RowEnd) == true) {
				size = false;	
			}
			if(size == true) {
				if(RowDistance == 0 ) {
					if(ColumnDistance == 2) {
						while(true){
							Board.defenseBoard[RowStart][ColumnStart] = Constants.Cruiser_icon;
							if(ColumnStart == ColumnEnd) {
								break;
							}
							if(ColumnStart > ColumnEnd) {
								ColumnStart--;
							}else {
								ColumnStart++;
							}
						}
					
						while(true) {
							Board.defenseBoard[RowStart][ColumnStart]= Constants.Cruiser_icon;
							
							if(RowStart == RowEnd) {
								break;
							}
							if(RowStart > RowEnd) {
								RowStart--;
							}else{
								RowStart++;
							}
						}
						size = true;
					}else{
						System.out.println("The Size you entered wasn't 3 spaces, please try again.");
						size = false;					
					}
				}
				if(ColumnDistance == 0) {
					if(RowDistance == 2) {
						while(true){
							Board.defenseBoard[RowStart][ColumnStart] = Constants.Cruiser_icon;
							if(ColumnStart == ColumnEnd) {
								break;
							}
							if(ColumnStart > ColumnEnd) {
								ColumnStart--;
							}else {
								ColumnStart++;
							}
						}
					
						while(true) {
							Board.defenseBoard[RowStart][ColumnStart]= Constants.Cruiser_icon;
							if(RowStart == RowEnd) {
								break;
							}
							if(RowStart > RowEnd) {
								RowStart--;
							}else{
								RowStart++;
							}
						}
						size = true;
				}else {
					System.out.println("The Size you entered wasn't 4 spaces, please try again.");
					size = false;	
				}
			}
			}	
		}
	}	
	private void placeSubmarine() { //Asks Questions to place Submarine
		size = false;
		
		
		while(size == false){	//Make sure that the size is as labeled
			size = true;
			System.out.println("What Column do you want to start your Submarine? (3 Spaces long) ");
				BeginColumn();
			System.out.println("What Row do you want to start? ");
				BeginRow();
			System.out.println("What Column do you want to End your Submarine? ");
				FinishColumn();
			System.out.println("What Row do you want to End? ");
				FinishRow();
			
			if(isDiagonal(ColumnDistance,RowDistance) == true) {
				size = false;
			}
			if(isOverlap(ColumnStart,ColumnEnd,RowStart,RowEnd) == true) {
				size = false;	
			}
			if(size == true) {
				if(RowDistance == 0 ) {
					if(ColumnDistance == 2) {
						while(true){
							Board.defenseBoard[RowStart][ColumnStart] = Constants.Submarine_icon;
							if(ColumnStart == ColumnEnd) {
								break;
							}
							if(ColumnStart > ColumnEnd) {
								ColumnStart--;
							}else {
								ColumnStart++;
							}
						}
					
						while(true) {
							Board.defenseBoard[RowStart][ColumnStart]= Constants.Submarine_icon;
							
							if(RowStart == RowEnd) {
								break;
							}
							if(RowStart > RowEnd) {
								RowStart--;
							}else{
								RowStart++;
							}
						}
						size = true;
					}else{
						System.out.println("The Size you entered wasn't 3 spaces, please try again.");
						size = false;						}
					}
				if(ColumnDistance == 0) {
					if(RowDistance == 2) {
						while(true){
							Board.defenseBoard[RowStart][ColumnStart] = Constants.Submarine_icon;
							if(ColumnStart == ColumnEnd) {
								break;
							}
							if(ColumnStart > ColumnEnd) {
								ColumnStart--;
							}else {
								ColumnStart++;
							}						}
					
						while(true) {
							Board.defenseBoard[RowStart][ColumnStart]= Constants.Submarine_icon;
							
							if(RowStart == RowEnd) {
								break;
							}
							if(RowStart > RowEnd) {
								RowStart--;
							}else{
								RowStart++;
							}
						}
					}
				}	
			}
		}
	}
	private void placeDestroyer() { //Asks Questions to place Destroyer
		size = false;
		
		
		while(size == false){	//Make sure that the size is as labeled
			size = true;
			System.out.println("What Column do you want to start your Destroyer? (2 Spaces long) ");
				BeginColumn();
			System.out.println("What Row do you want to start? ");
				BeginRow();
			System.out.println("What Column do you want to End your Destroyer? ");
				FinishColumn();
			System.out.println("What Row do you want to End? ");
				FinishRow();
			
			
			if(isDiagonal(ColumnDistance,RowDistance) == true) {
				size = false;
			}
			if(isOverlap(ColumnStart,ColumnEnd,RowStart,RowEnd) == true) {
				size = false;	
			}
			if(size == true) {
				if(RowDistance == 0 ) {
					if(ColumnDistance == 1) {
						while(true){
							Board.defenseBoard[RowStart][ColumnStart] = Constants.Destroyer_icon;
							if(ColumnStart == ColumnEnd) {
								break;
							}
							if(ColumnStart > ColumnEnd) {
								ColumnStart--;
							}else {
								ColumnStart++;
							}
						}
					
						while(true) {
							Board.defenseBoard[RowStart][ColumnStart]= Constants.Destroyer_icon;
							
							if(RowStart == RowEnd) {
								break;
							}
							if(RowStart > RowEnd) {
								RowStart--;
							}else{
								RowStart++;
							}
						}
						size = true;
					}else{
						System.out.println("The Size you entered wasn't 2 spaces, please try again.");
						size = false;						}
					}
				
				if(ColumnDistance == 0) {
					if(RowDistance == 1) {
						while(true){
							Board.defenseBoard[RowStart][ColumnStart] = Constants.Destroyer_icon;
							if(ColumnStart == ColumnEnd) {
								break;
							}
							if(ColumnStart > ColumnEnd) {
								ColumnStart--;
							}else {
								ColumnStart++;
							}
						}
					
						while(true) {
							Board.defenseBoard[RowStart][ColumnStart]= Constants.Destroyer_icon;
							
							if(RowStart == RowEnd) {
								break;
							}
							if(RowStart > RowEnd) {
								RowStart--;
							}else{
								RowStart++;
							}
						}
					}
				}
				}
			}
	}
	private boolean isDiagonal (int ColumnDistance, int RowDistance) {
		if(ColumnDistance != 0) {
			if(RowDistance !=0) {
				System.out.println("You can't place pieces diagonally, Try again.");
				return true;
			}else {
				return false;
			}
		}
		return false;
			
		
	}
	private boolean isOverlap(int ColumnStart,int ColumnEnd, int RowStart,int RowEnd) {
		int column = ColumnStart;
		int row = RowStart;
		ColumnEnd--;
		while(column<=ColumnEnd){
			switch(Board.defenseBoard[row][column]) {
				case Constants.Carrier_icon:
					System.out.println("There is Overlap that is not allowed");
					return true;
				case Constants.BattleShip_icon:
					System.out.println("There is Overlap that is not allowed");
					return true;
				case Constants.Cruiser_icon:
					System.out.println("There is Overlap that is not allowed");
					return true;
				case Constants.Destroyer_icon:
					System.out.println("There is Overlap that is not allowed");
					return true;
				case Constants.Submarine_icon:
					System.out.println("There is Overlap that is not allowed");
					return true;
				default:
					column++;
					break;
			}
		}
		while(row <= RowEnd) {
			switch(Board.defenseBoard[row][column]) {
			case Constants.Carrier_icon:
				System.out.println("There is Overlap that is not allowed");
				return true;
			case Constants.BattleShip_icon:
				System.out.println("There is Overlap that is not allowed");
				return true;
			case Constants.Cruiser_icon:
				System.out.println("There is Overlap that is not allowed");
				return true;
			case Constants.Destroyer_icon:
				System.out.println("There is Overlap that is not allowed");
				return true;
			case Constants.Submarine_icon:
				System.out.println("There is Overlap that is not allowed");
				return true;
			default:
				row++;
				break;
			}
		}
		return false;
	}
	private void BeginColumn() {

		ColumnName = in.next();
		ColumnName = ColumnName.toUpperCase();
		ColumnName = ColumnName.trim();
		ColumnStart = Board.changeColumn(ColumnName);
		if(ColumnStart >= 10) {
			System.out.println("Please Enter a letter in the boundaries: ");
				BeginColumn();
		}
	}
	private void FinishColumn() {
		ColumnName = in.next();
		ColumnName = ColumnName.toUpperCase();
		ColumnName = ColumnName.trim();
		ColumnEnd = Board.changeColumn(ColumnName);
		
		if(ColumnEnd >= 10) {
			System.out.println("Please Enter a Letter in the Boundaries: ");
			FinishColumn();
		}
	}
	private void BeginRow() {
		RowStart = FindError(RowStart);
		if(RowStart > 10) {
					System.out.println("Please enter a number in the Boundaries");
					BeginRow();
				}
				RowStart--;
	}
	private void FinishRow() {
		CatchError = false;
		RowEnd = FindError(RowEnd);
		if(RowEnd > 10) {
			System.out.println("Please enter a number in the Boundaries");
			FinishRow();
		}
		RowEnd--;
		RowDistance = Math.abs(RowEnd - RowStart);
		ColumnDistance = Math.abs(ColumnEnd - ColumnStart);
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
	public void CreateBlankSpace() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();		
		System.out.println();		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

}
