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
		for(int r = 0; r<ROWS; r++) {
			dgrid[r][0].setOccFeature(new Wall());
			dgrid[r][COLS-1].setOccFeature(new Wall());
		}
		for(int c = 0; c<COLS; c++) {
			dgrid[0][c].setOccFeature(new Wall());
			dgrid[ROWS-1][c].setOccFeature(new Wall());
		}
		int rooms = (int)(Math.random()*5)+4;
		for (int i=0;i<rooms;i++){
			generateRoom();
		}
		int monsters = (int) (Math.random()*10+10);
		for (int i=0;i<monsters;i++){
			spawn();
		}
		
		int items = (int) (Math.random()*8+8);
		for (int i=0;i<monsters;i++){
			genItem();
		}
		player = new Player("Dingus", 69);
		player.putSelfInDungeon(this,new Location(1,1));
		for (Square sq:this) {
			sq.addItem(new Items("coins",1));
		}
	}
	
	public void regenerate(){
		//needs to basically call construct again
	}
	
	public void generateRoom() {
		Location center = null;
		boolean oc = false;
		while (!oc){
			center = new Location((int)(Math.random()*(ROWS-2)+1),(int)(Math.random()*(COLS-2)+1));
			if (dgrid[center.getRow()][center.getCol()].getOccFeature()==null){
				oc=true;
			}
		}
		oc = false;
		int radius=0;
		while (!oc){
			radius = (int)(Math.random()*6)+2;
			if (center.getCol()-radius>=0 && center.getCol()+radius<COLS && center.getRow()-radius >=0 && center.getRow()+radius <ROWS){
				oc = true;
			}
		}
		for (int i=center.getRow()-radius;i<center.getRow()+radius;i++){
			for (int j=center.getCol()-radius;j<=center.getCol()+radius;j++){
				if (i==center.getRow()-radius || i==center.getRow()+radius || j==center.getRow()-radius || j==center.getRow()+radius) {
					dgrid[i][j].setOccFeature(new Wall());
				}
				else {
					dgrid[i][j].setOccFeature(new FloorTile());
				}
			}
		}
		oc=false;
		Location exit;
		while(!oc) {
			exit = new Location ((int)Math.random()*ROWS,(int)Math.random()*COLS);
			if (dgrid[exit.getRow()][exit.getCol()].getOccFeature() instanceof FloorTile){
				oc = true;
				dgrid[exit.getRow()][exit.getCol()].setOccFeature(new Staircase());
			}
		}
		
	}
	
	public void spawn(){
		boolean oc = false;
		Location loc;
		while(!oc) {
			loc = new Location ((int)Math.random()*ROWS,(int)Math.random()*COLS);
			if (dgrid[loc.getRow()][loc.getCol()].getOccFeature() instanceof FloorTile){
				oc = true;
				//dgrid[loc.getRow()][loc.getCol()].setOccupant(new Monster()); randomly select monster to spawn
			}
		}
	}
	
	public void genItem(){
		boolean oc = false;
		Location loc;
		while(!oc) {
			loc = new Location ((int)Math.random()*ROWS,(int)Math.random()*COLS);
			if (dgrid[loc.getRow()][loc.getCol()].getOccFeature() instanceof FloorTile){
				oc = true;
				//dgrid[loc.getRow()][loc.getCol()].setOccupant(new ItemEquipable()); randomly select monster to spawn
			}
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

	public Square getSquare(Location loc) {
		return dgrid[loc.getRow()][loc.getCol()];
	}
	private class DungeonIterator implements Iterator<Square> {
		private int row,col;
		public DungeonIterator() {
			row = 0;
			col = 0;
		}
		@Override
		public boolean hasNext() {
			return row < ROWS-1 || col < COLS-1;
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