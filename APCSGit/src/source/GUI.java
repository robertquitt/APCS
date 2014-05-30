package source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements KeyListener{
	private JFrame frame;
	private Dungeon dungeon;
	public GUI(){
		frame = new JFrame("Rogue-Like");
        frame.setLayout(new GridLayout(30,80));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        frame.setSize(960,2560);
        frame.setVisible(true);
        dungeon = new Dungeon();
        dungeon.getPlayer();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key pressed: " + e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		} else {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				dungeon.getPlayer().move(Location.NORTH);
				break;
			case KeyEvent.VK_LEFT:
				dungeon.getPlayer().move(Location.WEST);
				break;
			case KeyEvent.VK_DOWN:
				dungeon.getPlayer().move(Location.SOUTH);
				break;			
			case KeyEvent.VK_RIGHT:
				dungeon.getPlayer().move(Location.EAST);
				break;
			default:
				break;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.toString();//gtfo, errors
	}
}
