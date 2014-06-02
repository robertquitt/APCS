package source;


public class Wall extends MapFeature{
	public Wall() {
		
	}
	public char getDisplayChar() {
		return 'W'; //change later 
	}
	@Override
	public boolean isTraversable() {
		return false;
	}
}
