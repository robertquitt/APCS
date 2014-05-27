package source;

import java.util.ArrayList;

public class Dungeon {
	Square[][] dgrid;
	
	public static final int ROWS = 100, COLS = 50;
	
	//modified by Brandon, 5-22-14
	public Dungeon(){
		dgrid = new Square[ROWS][COLS];
		
		for (int r = 0; r < dgrid.length; r++){
			for (int c = 0; c < dgrid[0].length; c++){
				dgrid[r][c] = new Square();
			}
		}
	}

	public String printlvl() {
		String s = "";
		for (int x=0; x<ROWS;x++) {
			for (int y=0;y<COLS;y++) {
				s+= dgrid[x][y].getChar();
			}
		}
		return s;
	}
	
	
	public boolean isValid(Location l){
		return (0<= l.getRow() && l.getRow() < dgrid.length) && (0<= l.getCol() && l.getCol() < dgrid[0].length);
	}
	
	public Square getSquare(Location l){
		return dgrid[l.getRow()][l.getCol()];
	}
	
	public ArrayList<Location> getAdjacentLocations(Location l){
		ArrayList<Location> list = new ArrayList<Location>();
		for (int r = l.getRow()-1; r <= l.getRow()+1; r++){
			for (int c = l.getCol()-1; c<= l.getCol(); c++){
				if (this.isValid(l)){
					list.add(new Location(r, c));
				}
			}
		}
		list.remove(l);
		return list;
	}
}