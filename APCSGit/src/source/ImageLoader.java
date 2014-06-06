package source;


import java.awt.Image;
import java.io.*;
import java.util.HashMap;

import javax.swing.*;
public class ImageLoader {
	private ClassLoader cldr;
	private HashMap<String,Image> images;
	public ImageLoader() {
		images = new HashMap<String,Image>();
		cldr = this.getClass().getClassLoader();
		try {
			images.put("blank", new ImageIcon(cldr.getResource("images\\blank.png")).getImage());
			images.put("wall", new ImageIcon(cldr.getResource("images\\normalBlock.png")).getImage());
			images.put("floor", new ImageIcon(cldr.getResource("images\\floor1.png")).getImage());
			images.put("player", new ImageIcon(cldr.getResource("images\\player.png")).getImage());
			images.put("coins", new ImageIcon(cldr.getResource("images\\coin.png")).getImage());
			images.put("Staircase", new ImageIcon(cldr.getResource("images\\stone_stairs_down.png")).getImage());
			images.put("door", new ImageIcon(cldr.getResource("images\\openDoor.png")).getImage());
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
	public Image getImage(Named obj) {
		return obj==null?images.get("blank"):images.containsKey(obj.getName())?images.get(obj.getName()):images.get("blank");
	}
}
