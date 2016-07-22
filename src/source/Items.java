package source;


public class Items implements Named {
	boolean identified = false;
	int count;
	final int maxCount;
	char disp; //char to be displayed when on ground
	final int id; //unique for each type of item
	final String name; //name of item
	
	public Items(Items item) {
		this(item.name,item.count,item.maxCount);
	}
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
		return count+" "+getName();
	}
	public char getDisplayChar() {
		return disp;
	}
	
}
