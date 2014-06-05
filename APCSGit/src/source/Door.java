package source;

public class Door extends MapFeature{
	public Door(){}
	
	public char getDisplayChar() {
		return 'D';
	}
	public boolean isTraversable(){
		return true;
	}

	@Override
	public String getName() {
		return "Door";
	}
}
