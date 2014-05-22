package src;
import java.util.ArrayList;


public class Inventory {
	private ArrayList<Items> inv = new ArrayList<Items>();
	
	public void add(Items added){
		if (inv.size()==26)
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
		for (int i=0;i<26;i++){
			s+=  (i+95) + "/t" + inv.get(i).getName() + "/n";
		}
		return s;
	}
}