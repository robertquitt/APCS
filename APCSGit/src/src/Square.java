package src;

public class Square {
	Character occupant;
	Object occFeature;
	Inventory inv;
	
	//modified by Brandon, 5-22-14
	Square(){
		this(null,null);
	}
	
	Square(Character occ, Object feature){
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
}
