import java.util.*;
public class AI {
	public Ship Ships = new Ship();
	private int rowStart = 0;
	private int columnStart = 0;
	private int rowEnd = 0;
	private int columnEnd = 0;
	private String currentIcon = Constants.Carrier_icon;
	private double startDoubleRow = 0;
	private double startDoubleColumn = 0;
	boolean fillBoard = false;
	
	private double RandomAttack = 0;
	public int FirstAttackRow = 0;
	public int hitRow = 10;
	public int FirstAttackColumn = 0;
	public int hitColumn = 10;
	private int choice = 0;
	private double direction = 0;
	
	public void AI(){
		Ships.AiStart();
	}
	
	public void Lvl1Place() { //places in a row same every time
		columnStart = 0;
	
		System.out.println("Level 1 AI is placing Ships");
		for(rowStart =0; rowStart < 5; rowStart++) {
		Ships.Board.defenseBoard[rowStart][columnStart] = Constants.Carrier_icon;
		}
		columnStart++;
		for(rowStart=0; rowStart <4; rowStart++) {
			Ships.Board.defenseBoard[rowStart][columnStart] = Constants.BattleShip_icon;
		}
		columnStart++;
		for(rowStart=0; rowStart<3; rowStart++){
			Ships.Board.defenseBoard[rowStart][columnStart] = Constants.Cruiser_icon;
			columnStart++;
			Ships.Board.defenseBoard[rowStart][columnStart] = Constants.Submarine_icon;
			columnStart--;
		}
		columnStart+= 2;
		for(rowStart=0; rowStart<2; rowStart++) {
			Ships.Board.defenseBoard[rowStart][columnStart] = Constants.Destroyer_icon;
		}
	}
	public void Lvl2or3Place() { //places randomly
		direction = 0;
		
		while(fillBoard == false) {
			switch(currentIcon) {
			case Constants.Carrier_icon:
				direction = Math.random();// if > .5 then Horizontal else Vertical
				startDoubleRow = Math.random() * 9;
				startDoubleRow = Math.round(startDoubleRow);
				startDoubleColumn = Math.random() * 9;
				startDoubleColumn = Math.round(startDoubleColumn);
				columnStart = (int) startDoubleColumn;
				rowStart = (int) startDoubleRow; 
				
				if(direction > .5) {
					rowEnd = rowStart + 4;
					columnEnd = (int) startDoubleColumn;
					if(rowEnd > 9) {
						break;
					}
					if(isOverlap(columnStart, columnEnd, rowStart, rowEnd) == true) {
						break;
					}
					while (rowStart <= rowEnd) {
						Ships.Board.defenseBoard[rowStart][columnStart] = Constants.Carrier_icon;
						rowStart++;
					}
					
				}else {
					columnEnd = columnStart + 4;
					rowEnd = (int) startDoubleRow;
					if(columnEnd > 9) {
						break;
					}
					if(isOverlap(columnStart, columnEnd, rowStart, rowEnd) == true) {
						break;
					}
					while(columnStart <= columnEnd) {
						Ships.Board.defenseBoard[rowStart][columnStart] = Constants.Carrier_icon;
						columnStart++;
					}
				}
				currentIcon = Constants.BattleShip_icon;
				break;
			case Constants.BattleShip_icon:
				direction = Math.random();// if > .5 then Horizontal else Vertical
				startDoubleRow = Math.random() * 9;
				startDoubleRow = Math.round(startDoubleRow);
				startDoubleColumn = Math.random() * 9;
				startDoubleColumn = Math.round(startDoubleColumn);
				columnStart = (int) startDoubleColumn;
				rowStart = (int) startDoubleRow; 
				
				if(direction > .5) {
					rowEnd = rowStart + 3;
					columnEnd = (int) startDoubleColumn;
					if(rowEnd > 9) {
						break;
					}
					if(isOverlap(columnStart, columnEnd, rowStart, rowEnd) == true) {
						break;
					}
					while (rowStart <= rowEnd) {
						Ships.Board.defenseBoard[rowStart][columnStart] = Constants.BattleShip_icon;
						rowStart++;
					}
					
				}else {
					columnEnd = columnStart + 3;
					rowEnd = (int) startDoubleRow;
					if(columnEnd > 9) {
						break;
					}
					if(isOverlap(columnStart, columnEnd, rowStart, rowEnd) == true) {
						break;
					}
					while(columnStart <= columnEnd) {
						Ships.Board.defenseBoard[rowStart][columnStart] = Constants.BattleShip_icon;
						columnStart++;
					}
				}
				currentIcon = Constants.Cruiser_icon;
				break;
			case Constants.Cruiser_icon:
				direction = Math.random();// if > .5 then Horizontal else Vertical
				startDoubleRow = Math.random() * 9;
				startDoubleRow = Math.round(startDoubleRow);
				startDoubleColumn = Math.random() * 9;
				startDoubleColumn = Math.round(startDoubleColumn);
				columnStart = (int) startDoubleColumn;
				rowStart = (int) startDoubleRow; 
				
				if(direction > .5) {
					rowEnd = rowStart + 2;
					columnEnd = (int) startDoubleColumn;
					if(rowEnd > 9) {
						break;
					}
					if(isOverlap(columnStart, columnEnd, rowStart, rowEnd) == true) {
						break;
					}
					while (rowStart <= rowEnd) {
						Ships.Board.defenseBoard[rowStart][columnStart] = Constants.Cruiser_icon;
						rowStart++;
					}
					
				}else {
					columnEnd = columnStart + 2;
					rowEnd = (int) startDoubleRow;
					if(columnEnd > 9) {
						break;
					}
					if(isOverlap(columnStart, columnEnd, rowStart, rowEnd) == true) {
						break;
					}
					while(columnStart <= columnEnd) {
						Ships.Board.defenseBoard[rowStart][columnStart] = Constants.Cruiser_icon;
						columnStart++;
					}
				}
				currentIcon = Constants.Submarine_icon;
				break;
			case Constants.Submarine_icon:
				direction = Math.random();// if > .5 then Horizontal else Vertical
				startDoubleRow = Math.random() * 9;
				startDoubleRow = Math.round(startDoubleRow);
				startDoubleColumn = Math.random() * 9;
				startDoubleColumn = Math.round(startDoubleColumn);
				columnStart = (int) startDoubleColumn;
				rowStart = (int) startDoubleRow; 
				
				if(direction > .5) {
					rowEnd = rowStart + 2;
					columnEnd = (int) startDoubleColumn;
					if(rowEnd > 9) {
						break;
					}
					if(isOverlap(columnStart, columnEnd, rowStart, rowEnd) == true) {
						break;
					}
					while (rowStart <= rowEnd) {
						Ships.Board.defenseBoard[rowStart][columnStart] = Constants.Submarine_icon;
						rowStart++;
					}
					
				}else {
					columnEnd = columnStart + 2;
					rowEnd = (int) startDoubleRow;
					if(columnEnd > 9) {
						break;
					}
					if(isOverlap(columnStart, columnEnd, rowStart, rowEnd) == true) {
						break;
					}
					while(columnStart <= columnEnd) {
						Ships.Board.defenseBoard[rowStart][columnStart] = Constants.Submarine_icon;
						columnStart++;
					}
				}
				currentIcon = Constants.Destroyer_icon;
				break;
			case Constants.Destroyer_icon:
				direction = Math.random();// if > .5 then Horizontal else Vertical
				startDoubleRow = Math.random() * 9;
				startDoubleRow = Math.round(startDoubleRow);
				startDoubleColumn = Math.random() * 9;
				startDoubleColumn = Math.round(startDoubleColumn);
				columnStart = (int) startDoubleColumn;
				rowStart = (int) startDoubleRow; 
				
				if(direction > .5) {
					rowEnd = rowStart + 1;
					columnEnd = (int) startDoubleColumn;
					if(rowEnd > 9) {
						break;
					}
					if(isOverlap(columnStart, columnEnd, rowStart, rowEnd) == true) {
						break;
					}
					while (rowStart <= rowEnd) {
						Ships.Board.defenseBoard[rowStart][columnStart] = Constants.Destroyer_icon;
						rowStart++;
					}
					
				}else {
					columnEnd = columnStart + 1;
					rowEnd = (int) startDoubleRow;
					if(columnEnd > 9) {
						break;
					}
					if(isOverlap(columnStart, columnEnd, rowStart, rowEnd) == true) {
						break;
					}
					while(columnStart <= columnEnd) {
						Ships.Board.defenseBoard[rowStart][columnStart] = Constants.Destroyer_icon;
						columnStart++;
					}
				}
				fillBoard = true;
				break;
			default:
				System.out.println("AI encountered a problem, will restart placing ships.");
				Lvl2or3Place();
				break;
			}
		}
	}
	public int Lvl1Attack() {// Just shoots Randomly
		RandomAttack = Math.random() * 9;
		RandomAttack = Math.round(RandomAttack);
		FirstAttackRow = (int) RandomAttack;
		RandomAttack = Math.random() * 9;
		RandomAttack = Math.round(RandomAttack);
		FirstAttackColumn = (int) RandomAttack;
		return FirstAttackRow;
	}
	public int Lvl2Attack() {// Shoots Randomly when hits won't shoot again
		RandomAttack = Math.random() * 9;
		RandomAttack = Math.round(RandomAttack);
		FirstAttackRow = (int) RandomAttack;
		RandomAttack = Math.random() * 9;
		RandomAttack = Math.round(RandomAttack);
		FirstAttackColumn = (int) RandomAttack;
		if(Ships.Board.attackBoard[FirstAttackRow][FirstAttackColumn] == Constants.Hit_icon) {
			Lvl2Attack();
		}
		if( Ships.Board.attackBoard[FirstAttackRow][FirstAttackColumn] == Constants.Miss_icon) {
			Lvl2Attack();
		}
			return FirstAttackRow;
	}
	public int Lvl3Attack() {//Shoots Randomly when hits will check every direction until sunk
		direction = Math.round(Math.random()*4);
		choice = (int) direction;
		if(hitColumn != 10 && hitRow != 10)
		switch(choice){
		case 1: //Check Up
			if(hitRow == 0) {
				Lvl3Attack();
			}else {
				hitRow --;
				FirstAttackRow = hitRow;
				if(Ships.Board.attackBoard[FirstAttackRow][FirstAttackColumn] == Constants.Hit_icon) {
					Lvl3Attack();
				}
				if( Ships.Board.attackBoard[FirstAttackRow][FirstAttackColumn] == Constants.Miss_icon) {
					Lvl3Attack();
				}
			}
			return FirstAttackRow;
		case 2: //Check Down
			if(hitRow == 9) {
				Lvl3Attack();
			}else {
				hitRow++;
				FirstAttackRow = hitRow;
				if(Ships.Board.attackBoard[FirstAttackRow][FirstAttackColumn] == Constants.Hit_icon) {
					Lvl3Attack();
				}
				if( Ships.Board.attackBoard[FirstAttackRow][FirstAttackColumn] == Constants.Miss_icon) {
					Lvl3Attack();
				}
			}
			
			return FirstAttackRow;
		case 3: //Check Left
			if(hitColumn == 0) {
				Lvl3Attack();
			}else {
				hitColumn--;
				FirstAttackColumn = hitColumn;
				if(Ships.Board.attackBoard[FirstAttackRow][FirstAttackColumn] == Constants.Hit_icon) {
					Lvl3Attack();
				}
				if( Ships.Board.attackBoard[FirstAttackRow][FirstAttackColumn] == Constants.Miss_icon) {
					Lvl3Attack();
				}
			}
			return FirstAttackRow;
		case 4: //Check Right
			if(hitColumn == 9) {
				Lvl3Attack();
			}else {
				hitColumn++;
				FirstAttackColumn = hitColumn;
				if(Ships.Board.attackBoard[FirstAttackRow][FirstAttackColumn] == Constants.Hit_icon) {
					Lvl3Attack();
				}
				if( Ships.Board.attackBoard[FirstAttackRow][FirstAttackColumn] == Constants.Miss_icon) {
					Lvl3Attack();
				}
			}
			return FirstAttackRow;
		default: //Catch error
			System.out.println("System did not generate a number in the zone. Will try again");
			Lvl3Attack();
			break;
			
		}
		
		RandomAttack = Math.random() * 9;
		RandomAttack = Math.round(RandomAttack);
		FirstAttackRow = (int) RandomAttack;
		RandomAttack = Math.random() * 9;
		RandomAttack = Math.round(RandomAttack);
		FirstAttackColumn = (int) RandomAttack;
		
		if(Ships.Board.attackBoard[FirstAttackRow][FirstAttackColumn] == Constants.Hit_icon) {
			Lvl3Attack();
		}
		if( Ships.Board.attackBoard[FirstAttackRow][FirstAttackColumn] == Constants.Miss_icon) {
			Lvl3Attack();
		}
		

		return FirstAttackRow;
	}
	public boolean isOverlap(int ColumnStart,int ColumnEnd, int RowStart,int RowEnd) {
		int column = ColumnStart;
		int row = RowStart;
		while(column<ColumnEnd){
			switch(Ships.Board.defenseBoard[row][column]) {
				case Constants.Carrier_icon:
					return true;
				case Constants.BattleShip_icon:
					return true;
				case Constants.Cruiser_icon:
					return true;
				case Constants.Destroyer_icon:
					return true;
				case Constants.Submarine_icon:
					return true;
				default:
					column++;						
					break;
			}
		}
		while(row < RowEnd) {
			switch(Ships.Board.defenseBoard[row][column]) {
			case Constants.Carrier_icon:
				return true;
			case Constants.BattleShip_icon:
				return true;
			case Constants.Cruiser_icon:
				return true;
			case Constants.Destroyer_icon:
				return true;
			case Constants.Submarine_icon:
				return true;
			default:
				row++;
				break;
			}
		}
		if(Ships.Board.defenseBoard[RowEnd][ColumnEnd] != Constants.Board_icon) {
			return true;
		}else {
		return false;
		}
	}
	}
