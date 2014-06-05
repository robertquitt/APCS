package source;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GUI extends JFrame implements KeyListener{
	private Dungeon dungeon;
	private Player player;
	private ImageLoader il;
	JScrollPane scrollPane; 
	JTextArea textArea;
	@SuppressWarnings("static-access")
	public GUI(){
		super("Rogue-Like");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setSize(400,400);
        this.setResizable(true);
        setVisible(true);
        dungeon = new Dungeon();
        player = dungeon.getPlayer();
        il = new ImageLoader();
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setLocation(100, 100);
        repaint();
        printConsole("lol");
	}
	@SuppressWarnings("static-access")
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		for (int r = 0; r<dungeon.ROWS; r++) {
			for (int c = 0; c<dungeon.COLS; c++) {
				g.drawImage(il.getImage(dungeon.getSquare(r, c).getDisplayedObject()), 32*c+32, 32*r+32, this);
			}
		}
		drawString(g,player.toString(), 100, 350);
		drawString(g,player.getMyInv().toString(), 0, 0);
		System.out.println(player.getMyInv().toString());
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("Key pressed: " + e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		} else {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				player.move(Location.NORTH);
				break;
			case KeyEvent.VK_LEFT:
				player.move(Location.WEST);
				break;
			case KeyEvent.VK_DOWN:
				player.move(Location.SOUTH);
				break;			
			case KeyEvent.VK_RIGHT:
				player.move(Location.EAST);
				break;
			default:
				break;
			}
		}
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	public void printConsole(String str) {
		textArea.append(str);
		repaint();
	}
	public void drawString(Graphics g, String str, int x, int y) {
		int i = 0;
		while(str.indexOf('\n', i)!=-1) {
			g.drawString(str.substring(i,str.indexOf('\n', i)+1), x, y);
			i = str.indexOf('\n',i)+1;
			y+=10;
		}
	}
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.toString();
	}
}
