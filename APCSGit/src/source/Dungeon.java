package source;


import java.util.ArrayList;
import java.util.Iterator;

public class Dungeon implements Iterable<Square>{
	private Square[][] dgrid;
	public static final int ROWS = 50, COLS = 100;
	private Player player;
	public Dungeon(){
		dgrid = new Square[ROWS][COLS];
		for (int r = 0; r < dgrid.length; r++){
			for (int c = 0; c < dgrid[0].length; c++){
				dgrid[r][c] = new Square();
			}
		}
		construct();
	}
	private void construct() {
		/*for(int r = 0; r<ROWS; r++) {
			dgrid[r][0].setOccFeature(new Wall());
			dgrid[r][COLS-1].setOccFeature(new Wall());
		}
		for(int c = 0; c<COLS; c++) {
			dgrid[0][c].setOccFeature(new Wall());
			dgrid[ROWS-1][c].setOccFeature(new Wall());
		}*/
		int rooms = (int)(Math.random()*5)+4;
		for (int i=0;i<rooms;i++){
			generateRoom();
		}
		player = new Player("Dingus", 0);
		player.putSelfInDungeon(this, new Location((int)(Math.random()*(ROWS-2))+1,(int)(Math.random()*(COLS-2))+1));
	}
	
	public void generateRoom() {
		Location center = null;
		boolean oc = false;
		while (!oc){
			center = new Location((int)(Math.random()*47+1),(int)(Math.random()*98+1));
			if (dgrid[center.getRow()][center.getCol()].equals(null)){
				oc=true;
			}
		}
		int radius = (int)(Math.random()*6)+2;
		for (int i=center.getRow()-radius;i<center.getRow()+radius;i++){
			dgrid[i][center.getCol()-radius].setOccFeature(new Wall());
			dgrid[i][center.getCol()+radius].setOccFeature(new Wall());
		}
		for (int j=center.getCol()-radius;j<center.getCol()+radius;j++){
			dgrid[center.getRow()-radius][j].setOccFeature(new Wall());
			dgrid[center.getRow()+radius][j].setOccFeature(new Wall());
		}
	}
	public String printlvl() {
		String s = "";
		for (int x=0; x<ROWS;x++) {
			for (int y=0;y<COLS;y++) {
				s+= dgrid[x][y].getDisplayChar();
			}
			s+="\n";
		}
		return s;
	}
	public String printline(int row) {
		String s = "";
		for (int col = 0; col < COLS; col++) {
			s+=dgrid[row][col].getDisplayChar();
		}
		return s;
	}
	
	public Player getPlayer() {
		return player;
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
	public Items pickupItem(Location loc) {
		return dgrid[loc.getRow()][loc.getCol()].getInv().remove(0);
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
	public Square getSquare(int x, int y) {
		return dgrid[x][y];
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