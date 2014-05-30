package source;

public class Square {
	private Character occupant;
	private MapFeature occFeature;
	private Inventory inv;
	
	public Square(){
		this(null,null);
	}
	
	public Square(Character occ, MapFeature feature){
		occupant = occ;
		occFeature = feature;
		inv = new Inventory();
	}
	
	//change chars to objects in final implementation
	char getDisplayChar() { //change to char
		if (occupant!=null) {
			return occupant.getDisplayChar(); //create this
		}else if (occFeature!=null){
			return occFeature.toString().charAt(0);//remove later
		}else{ 
			return inv.getDisplayChar();
		}
//		else return null;
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
	
	public void addItem(Items i){
		inv.add(i);
	}
}
