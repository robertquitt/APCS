package source;

import java.io.*;
import java.net.URL;
import javax.swing.*;
public class ImageLoader {
	private ImageIcon wall;
	private ImageIcon floor;
	private ImageIcon player;
	public ImageLoader() {
		ClassLoader cldr = this.getClass().getClassLoader();
		try {
			wall = new ImageIcon(cldr.getResource("otherBlock.png"));
	 		floor = new ImageIcon(cldr.getResource("floorTile.png"));
	 		player = new ImageIcon(cldr.getResource("openDoor.png"));
  		}  	
     	catch (Exception e){
			try{	
				PrintStream p = new PrintStream(
							new FileOutputStream(new File("trace.txt")));
				p.println("got here");	// sample output to file
				e.printStackTrace(p);	// print stack trace to output file
			}
			catch(Exception e1)	// need this empty section for PrintStream
			{
			}
     	}
	}
}
