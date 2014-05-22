package src;

public class Square {
	Character occupant;
	Object occFeature;
	Inventory inv;
	
	//modified by Brandon, 5-22-14
	Square(){
		occupant = null;
		occFeature = null;
		inv = new Inventory();
	}
	
	Square(Character occ, Object feature){
		occupant = occ;
		occFeature = feature;
		inv= new Inventory();
	}
	
	//change chars to objects in final implementation
	Object getTopLayer() { //change to char
		if (occupant!=null)
			return occupant; //create this
		else if (inv!=null) {
			return inv.get(0).getID();
		}
		else if (occFeature!=null){
			return occFeature;
		}
		else return ' ';
//		else return null;
	}
	
	Character getChar(){
		return occupant;
	}
	
}
