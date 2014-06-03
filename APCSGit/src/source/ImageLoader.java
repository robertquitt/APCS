package source;


import java.awt.Image;
import java.io.*;
import java.util.HashMap;

import javax.swing.*;
public class ImageLoader {
	private ClassLoader cldr;
	@SuppressWarnings("rawtypes")
	private HashMap<Class,Image> images;
	@SuppressWarnings("rawtypes")
	public ImageLoader() {
		images = new HashMap<Class,Image>();
		cldr = this.getClass().getClassLoader();
		try {
			images.put(Wall.class, new ImageIcon(cldr.getResource("images\\normalBlock.png")).getImage());
			images.put(Square.class, new ImageIcon(cldr.getResource("images\\floor1.png")).getImage());
			images.put(Player.class, new ImageIcon(cldr.getResource("images\\player.png")).getImage());
			images.put(Items.Coin.class, new ImageIcon(cldr.getResource("images\\coins.png")).getImage());
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
	public Image getImage(Object obj) {
		return obj==null?images.get(Square.class):images.get(obj.getClass());
	}
}
