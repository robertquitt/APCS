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
			print();
			input = scanner.nextLine();
			switch(input.length()==0?' ':input.charAt(0)) {
			case 'n':
				player.move(Location.NORTH);
				break;
			case 'w':
				player.move(Location.WEST);
				break;
			case 's':
				player.move(Location.SOUTH);
				break;
			case 'e':
				player.move(Location.EAST);
				break;
			default:
				break;
			}
		} while(true);
	}
	public void print() {
		System.out.println(dungeon.printlvl());
	}
	public static void main(String[] args) {
		CharGUI gui = new CharGUI();
		gui.run();
	}

}
