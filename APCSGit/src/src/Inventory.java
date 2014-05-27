package src;
import java.util.ArrayList;

//modified by Brandon, 5-22-14
public class Inventory implements CharDisplayable{
	
	private ArrayList<Items> inv;
	public static final int INV_MAX = 26;
	
	public Inventory(){
		inv = new ArrayList<Items>();
	}
	
	public void add(Items added){
		if(added.maxCount!=1){
			for(Items i:inv){
				if(i.id==added.id) {
					i.count+=added.count;
					return;
				}
			}
		}
		if (inv.size()==INV_MAX)
			return;
		else 
			inv.add(added);
	}
	
	public void remove(int rem) {
		inv.remove(rem);
	}
	
	public boolean isEmpty(){
		if (inv.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public Items get(int num) {
		return inv.get(num);
	}
	
	public String toString(){
		String s = "";
		for (int i=0;i<INV_MAX;i++){
			s+=  (i+95) + "/t" + inv.get(i).getName() + "/n";
		}
		return s;
	}

	
	public char getDisplayChar() {
		return inv.size()==0?' ':inv.get(0).getDisplayChar();
	}
}