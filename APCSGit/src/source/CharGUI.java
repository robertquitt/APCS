package source;

import java.util.Scanner;

/**
 * Text-based GUI for debugging purposes
 * @author Robert
 *
 */
public class CharGUI {
	Dungeon dungeon;
	Scanner scanner;
	public CharGUI() {
		scanner = new Scanner(System.in);
		dungeon = new Dungeon();
	}
	public void run(){
		Player player = new Player("dingus", Integer.MAX_VALUE);
		player.putSelfInDungeon(dungeon, new Location(20,20));
		for (int i = 0; i < Dungeon.ROWS; i++) {
			dungeon.setFeature(new Wall(), new Location(i,0));
			dungeon.setFeature(new Wall(), new Location(i,Dungeon.COLS-1));
		}
		for (int i = 0; i < Dungeon.COLS; i++) {
			dungeon.setFeature(new Wall(), new Location(0,i));
			dungeon.setFeature(new Wall(), new Location(Dungeon.ROWS-1,i));
		}
		String input;
		do {
			System.out.println(dungeon.printlvl());
			input = scanner.nextLine();
			player.parse(input);
		} while(true);
	}
	public static void main(String[] args) {
		CharGUI gui = new CharGUI();
		gui.run();
	}

}
