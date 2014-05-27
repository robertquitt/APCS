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
		String input;
		do {
			input = scanner.nextLine();
			print();
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
