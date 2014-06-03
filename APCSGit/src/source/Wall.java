package source;



public class Wall extends MapFeature{
	public Wall() {
		
	}
	public char getDisplayChar() {
		return 'W'; //change later 
	}
	public String getName() {
		return "wall";
	}
	@Override
	public boolean isTraversable() {
		return false;
	}
}
