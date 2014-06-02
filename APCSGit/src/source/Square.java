package source;


public class Square {
	private Character occupant;
	private MapFeature occFeature;
	private Inventory inv;
	
	Square(){
		this(null,null);
	}
	
	Square(Character occ, MapFeature feature){
		occupant = occ;
		occFeature = feature;
		inv = new Inventory();
	}

	public Object getDisplayedObject() { //change to char
		if (occupant!=null) {
			return occupant; //create this
		}else if (occFeature!=null){
			return occFeature;//remove later
		}else{ 
			return inv.getDisplayedObject();//this returns null if inv is empty
		}
	}

	public Character getOccupant() {
		return occupant;
	}

	public void setOccupant(Character occupant) {
		this.occupant = occupant;
	}

	public MapFeature getOccFeature() {
		return occFeature;
	}

	public void setOccFeature(MapFeature occFeature) {
		this.occFeature = occFeature;
	}

	public Inventory getInv() {
		return inv;
	}

	public char getDisplayChar() {
		if (occupant!=null) {
			return occupant.getDisplayChar(); //create this
		}else if (occFeature!=null){
			return occFeature.getDisplayChar();//remove later
		}else{ 
			return '.';
			//return inv.getDisplayChar();
		}
	}
	
}
