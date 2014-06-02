package source;

public class Items {
	boolean identified = false;
	int count;
	final int maxCount;
	char disp; //char to be displayed when on ground
	final int id; //unique for each type of item
	final String name; //name of item
	
	public Items(String name){
		this(name,1);
	}
	public Items(String name,int count){
		this(name,count,Integer.MAX_VALUE);
	}
	public Items(String name,int count,int maxCount){
		this.name = name;
		this.count = count;
		this.maxCount = maxCount;
		this.id = name.hashCode();
	}
	
	public String getName(){
		return name;
	}
	//change chars to objects in final implementation
	public char getID() {
		return disp;
	}	
	public String toString(){
		return (count==1?"":count)+" "+getName();
	}
	public char getDisplayChar() {
		return disp;
	}
	//Example:
	// Items coins = new Items.Coin(100);
	public static class Coin extends Items{public Coin(int count){super("Coins",count);disp='$';}}
	public static class FoodRation extends Items{public FoodRation(){super("Food Ration",1,1);disp='%';}}
}
