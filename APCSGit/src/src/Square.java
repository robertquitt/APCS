package src;

public class Square {
	Object occupant;
	Object occFeature;
	Inventory inv;
	
	Square(Object occ, Object feature){
		occupant = occ;
		occFeature = feature;
		inv= new Inventory();
	}
	
	Object getChar() { //change to char
		if (occupant!=null)
			return occupant; //create this
		else if (inv!=null) {
			return inv.get(0).getID();
		}
		else if (occFeature!=null){
			return occFeature;
		}
		else return ' ';
	}
}
