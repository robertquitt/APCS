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
		inv= new Inventory();
	}
	
	//change chars to objects in final implementation
	char getDisplayChar() { //change to char
		if (occupant!=null)
			return occupant.getDisplayChar(); //create this
		else if (inv!=null) {
			return inv.getDisplayChar();
		}
		else if (occFeature!=null){
			return occFeature.toString().charAt(0);//remove later
		}
		else return ' ';
//		else return null;
	}

	public Character getOccupant() {
		return occupant;
	}

	public void setOccupant(Character occupant) {
		this.occupant = occupant;
	}

	public Object getOccFeature() {
		return occFeature;
	}

	public void setOccFeature(Object occFeature) {
		this.occFeature = occFeature;
	}

	public Inventory getInv() {
		return inv;
	}
	
}
