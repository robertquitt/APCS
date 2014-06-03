package source;

public class FloorTile extends MapFeature{

	@Override
	public String getName() {
		return "floor";
	}

	@Override
	public boolean isTraversable() {
		return true;
	}
	public char getDisplayChar() {
		return '.';
	}

}
