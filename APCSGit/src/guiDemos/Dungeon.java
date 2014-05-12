package guiDemos;
public class Dungeon {
	Square[][] dgrid = new Square[100][50];
	
	public String printlvl() {
		String s = "";
		for (int x=0; x<100;x++) {
			for (int y=0;y<50;y++) {
				s+= dgrid[x][y].getChar();
			}
		}
		return s;
	}
}