package source;

import java.util.ArrayList;
import java.util.Iterator;

public class Dungeon implements Iterable<Square>{
	private Square[][] dgrid;
	public static final int ROWS = 100, COLS = 50;
	
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
				s+= dgrid[x][y].getDisplayChar();
			}
		}
		return s;
	}
	
	
	public boolean isValid(Location l){
		return (0<= l.getRow() && l.getRow() < dgrid.length) && (0<= l.getCol() && l.getCol() < dgrid[0].length);
	}
	public Character getCharacter(Location l){
		return dgrid[l.getRow()][l.getCol()].getOccupant();
	}
	public MapFeature getFeature(Location loc){
		return dgrid[loc.getRow()][loc.getCol()].getOccFeature();
	}
	public void setCharacter(Character occupant,Location loc) {
		dgrid[loc.getRow()][loc.getCol()].setOccupant(occupant);
	}
	public void setFeature(MapFeature feature,Location loc) {
		dgrid[loc.getRow()][loc.getCol()].setOccFeature(feature);
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

	private class DungeonIterator implements Iterator<Square> {
		private int row,col;
		public DungeonIterator() {
			row = 0;
			col = -1;
		}
		@Override
		public boolean hasNext() {
			return row < ROWS || col < COLS;
		}

		@Override
		public Square next() {
			col++;
			if (col==Dungeon.COLS){
				col = 0;
				row++;
			}
			return dgrid[row][col];
		}

		@Override
		public void remove() {
			dgrid[row][col].setOccupant(null);
			dgrid[row][col].setOccFeature(null);
		}	
	}
	@Override
	public Iterator<Square> iterator() {
		return new DungeonIterator();
	}
}