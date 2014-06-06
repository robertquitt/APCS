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

	public Named getDisplayedObject() {
		if (occupant!=null) {
			return occupant; 
		}else if (!inv.isEmpty()){
			return inv.getDisplayedObject();
		}else{ 
			return occFeature;
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
	
	public void addItem(Items item) {
		inv.add(item);
	}

	public char getDisplayChar() {
		if (occupant!=null) {
			return occupant.getDisplayChar(); //create this
		}else if (occFeature!=null){
			return occFeature.getDisplayChar();//remove later
		}else{ 
			return '.';
		}
	}
	
}
