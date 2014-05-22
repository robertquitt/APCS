package src;
import java.util.ArrayList;

//modified by Brandon, 5-22-14
public class Inventory {
	
	private ArrayList<Items> inv;
	public static final int INV_MAX = 26;
	
	public Inventory(){
		inv = new ArrayList<Items>();
	}
	
	public void add(Items added){
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
}