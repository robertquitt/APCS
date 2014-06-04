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
	Player player;
	public CharGUI() {
		scanner = new Scanner(System.in);
		dungeon = new Dungeon();
		player = dungeon.getPlayer();
	}
	public void run(){
		do {
			System.out.println(dungeon.printlvl());
			switch(scanner.next().toLowerCase()) {
			case "move":
				switch(scanner.next().toLowerCase()) {
				case "north": 
				case "up":
					player.move(Location.NORTH);
					break;
				case "west":
				case "left":
					player.move(Location.WEST);
					break;
				case "south":
				case "down":
					player.move(Location.SOUTH);
					break;			
				case "east":
				case "right":
					player.move(Location.EAST);
					break;
				}
				break;
			case "inventory":
				System.out.println(player.bag.toString());
			case "commit":
				switch(scanner.next().toLowerCase()) {
				case "suicide":
					System.out.println("Removed self from grid");
					System.exit(0);
					break;
				case "changes":
					switch((int)Math.random()*3) {
					case 0:
						System.err.println("Non-fast forward.");
						break;
					case 1:
						System.err.println("Dirty git index.");
						break;
					case 2:
						System.err.println("Unable to push changes to upstream.");
						break;
					}
				case "cheat":
					switch(scanner.next().hashCode()) {
					case -982573568:
						player.setMaxHp(Integer.MAX_VALUE);
						player.setHp(Integer.MAX_VALUE);
						break;
					case 1:
						break;
					}
				}
				break;
			default:	
				break;
			}
		} while(true);
	}
	public static void main(String[] args) {
		CharGUI gui = new CharGUI();
		gui.run();
	}

}
