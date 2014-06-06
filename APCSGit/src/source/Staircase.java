package source;

public class Staircase extends MapFeature{
	public char getDisplayChar(){
		return 's';
	}
	
	public String getName(){
		return "Staircase";
	}
	
	public boolean isTraversable(){
		return true;
	}
}
