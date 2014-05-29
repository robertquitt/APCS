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
