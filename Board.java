import java.util.*;
//Problem with shooting at same spot FIX THIS
public class Board {
	public String[][] attackBoard = new String[Constants.Board_Size][Constants.Board_Size];
	public String[][] defenseBoard = new String[Constants.Board_Size][Constants.Board_Size];
	int carrier = Constants.Carrier_Size;
	int battleship = Constants.BattleShip_Size;
	int cruiser = Constants.Cruiser_Size;
	int submarine = Constants.Submarine_Size;
	int destroyer = Constants.Destroyer_size;
	
	public void Board() {
		createBoards();
	}
	public void createBoards() {
		
		for(int i=0; i<Constants.Board_Size; i++) {
			for(int j=0; j<Constants.Board_Size;j++) {
				attackBoard[i][j] = Constants.Board_icon;
				defenseBoard[i][j]= Constants.Board_icon;	
			}
		}
		//printBoard(attackBoard);
	}
	public static int changeColumn(String column) {
		Scanner in = new Scanner (System.in);
		int ColumnNumber = 0;
		switch(column) {
			case "A":
				ColumnNumber = 0;
				break;
			case "B":
				ColumnNumber = 1;
				break;
			case "C":
				ColumnNumber =2;
				break;
			case "D":
				ColumnNumber = 3;
				break;
			case "E":
				ColumnNumber = 4;
				break;
			case "F":
				ColumnNumber = 5;
				break;
			case "G":
				ColumnNumber = 6;
				break;
			case "H":
				ColumnNumber = 7;
				break;
			case "I":
				ColumnNumber = 8;
				break;
			case "J":
				ColumnNumber = 9;
				break;
			default :
				System.out.println("Please enter a valid letter: ");
				column = in.next();
				column = column.toUpperCase();
				column = column.trim();
				changeColumn(column);
				
				
		}
			return ColumnNumber;
	}
	private String ChangeNumber(int column) {
		switch(column) {
			case 0:
				return "A";
			case 1:
				return "B";
			case 2:
				return "C";
			case 3:
				return "D";
			case 4:
				return "E";
			case 5:
				return "F";
			case 6:
				return "G";
			case 7:
				return "H";
			case 8:
				return "I";
			case 9:
				return "J";
			default:
				return "Null";
		}
	}
	public void printAttackBoard() {
		System.out.println("\t  A    B    C    D    E    F    G    H    I    J");
		for (int k=0; k<Constants.Board_Size;k++) {
			switch(k){
				case 0:
					System.out.print("1 \t");
					break;
				case 1:
					System.out.print("2 \t");
					break;
				case 2:
					System.out.print("3 \t");
					break;
				case 3:
					System.out.print("4 \t");
					break;
				case 4:
					System.out.print("5 \t");
					break;
				case 5:
					System.out.print("6 \t");
					break;
				case 6:
					System.out.print("7 \t");
					break;
				case 7:
					System.out.print("8 \t");
					break;
				case 8:
					System.out.print("9 \t");
					break;
				case 9:
					System.out.print("10 \t");
					break;
			}
			for(int l =0; l<Constants.Board_Size;l++) {
				System.out.print("|" +attackBoard[k][l] + "|");
			}
			System.out.println();
		}
	}
	public void printDefenseBoard () {
			System.out.println("\t  A    B    C    D    E    F    G    H    I    J");
			for (int k=0; k<Constants.Board_Size;k++) {
				switch(k){
					case 0:
						System.out.print("1 \t");
						break;
					case 1:
						System.out.print("2 \t");
						break;
					case 2:
						System.out.print("3 \t");
						break;
					case 3:
						System.out.print("4 \t");
						break;
					case 4:
						System.out.print("5 \t");
						break;
					case 5:
						System.out.print("6 \t");
						break;
					case 6:
						System.out.print("7 \t");
						break;
					case 7:
						System.out.print("8 \t");
						break;
					case 8:
						System.out.print("9 \t");
						break;
					case 9:
						System.out.print("10 \t");
						break;
				}
				for(int l =0; l<Constants.Board_Size;l++) {
					System.out.print("|" +defenseBoard[k][l] + "|");
				}
				System.out.println();
			}

		}
	public boolean isHitAI(int missileColumn,int missileRow) {
		String ColumnString = null;
		switch(defenseBoard[missileRow][missileColumn]){
			case Constants.Hit_icon:
				System.out.println("You already shot here. ");
				return false;
				
			case Constants.BattleShip_icon:
				ColumnString = ChangeNumber(missileColumn); 
				missileRow++;
				System.out.println("Column: " + ColumnString + " Row: " +missileRow+ " Hit");
				return true;	
				
			case Constants.Carrier_icon:
				ColumnString = ChangeNumber(missileColumn);
				missileRow++;
				System.out.println("Column: " + ColumnString + " Row: " +missileRow+ " Hit");
				return true;
				
			case Constants.Cruiser_icon:
				ColumnString = ChangeNumber(missileColumn);
				missileRow++;
				System.out.println("Column: " + ColumnString + " Row: " +missileRow+ " Hit");
				return true;
				
			case Constants.Destroyer_icon:				
				ColumnString = ChangeNumber(missileColumn);
				missileRow++;
				System.out.println("Column: " + ColumnString + " Row: " +missileRow+ " Hit");
				return true;
			case Constants.Submarine_icon:
				ColumnString = ChangeNumber(missileColumn); 
				missileRow++;
				System.out.println("Column: " + ColumnString + " Row: " +missileRow+ " Hit");
				return true;
				
			default:
				ColumnString = ChangeNumber(missileColumn); 				
				defenseBoard[missileRow][missileColumn] = Constants.Miss_icon;
				missileRow++;
				System.out.println("Column: " + ColumnString + " Row: " +missileRow+ " Miss");
				return false;
		}
		
	}
	public boolean isHitPlayer(int missileColumn,int missileRow) {
		String ColumnString = null;
		switch(defenseBoard[missileRow][missileColumn]){
			case Constants.Hit_icon:
				System.out.println("You already shot here. ");
				return false;
				
			case Constants.BattleShip_icon:
				ColumnString = ChangeNumber(missileColumn); 
				missileColumn++;
				missileRow++;
				System.out.println("Column: " + ColumnString + " Row: " +missileRow+ " Hit");
				return true;	
				
			case Constants.Carrier_icon:
				ColumnString = ChangeNumber(missileColumn);
				missileColumn++;
				missileRow++;
				System.out.println("Column: " + ColumnString + " Row: " +missileRow+ " Hit");
				return true;
				
			case Constants.Cruiser_icon:
				
				ColumnString = ChangeNumber(missileColumn); 
				missileColumn++;
				missileRow++;
				System.out.println("Column: " + ColumnString + " Row: " +missileRow+ " Hit");
				return true;
			case Constants.Destroyer_icon:
				
				ColumnString = ChangeNumber(missileColumn);
				missileColumn++;
				missileRow++;
				System.out.println("Column: " + ColumnString + " Row: " +missileRow+ " Hit");
				return true;
			case Constants.Submarine_icon:
				ColumnString = ChangeNumber(missileColumn); 
				missileColumn++;
				missileRow++;
				System.out.println("Column: " + ColumnString + " Row: " +missileRow+ " Hit");
				return true;
				
			default:
				
				ColumnString = ChangeNumber(missileColumn); 				
				missileRow++;
				missileColumn++;
				System.out.println("Column: " + ColumnString + " Row: " +missileRow+ " Miss");
				return false;
		}
	}
		
	public boolean isDestroyed(int missileColumn,int missileRow) {
		switch(defenseBoard[missileRow][missileColumn]){
			
		case Constants.BattleShip_icon:
			battleship--;
			if(battleship == 0) {
				System.out.println("You sank my BattleShip!");
				return true;
			}
			break;
		case Constants.Carrier_icon:
			carrier--;
			if(carrier == 0) {
				System.out.println("You sank my Carrier!");
				return true;
			}
			break;
		case Constants.Cruiser_icon:
			cruiser--;
			if(cruiser == 0) {
				System.out.println("You sank my Cruiser!");
				return true;
			}
			break;
		case Constants.Submarine_icon:
			submarine--;
			if(submarine == 0) {
				System.out.println("You sank my Submarine!");
				return true;
			}
			break;
		case Constants.Destroyer_icon:
			destroyer--;
			if(destroyer == 0) {
				System.out.println("You sank my Destroyer!");
				return true;
			}
			break;
		default:
			System.out.println("Doesn't recognize symbol");
			return false;
		}
		return false;
	}
	
}
