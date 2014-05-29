package source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GUI{
	private JFrame frame;
	public JButton button;
	public JTextField field;
	public GUI() {
		frame = new JFrame("THE GAME");
        frame.setLayout(new GridLayout(30,80));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new JButton("Submit");
        frame.getContentPane().add(button);
        field = new JTextField(20);
        frame.getContentPane().add(field);
        button.addActionListener(new Listener());
        frame.setSize(960,2560);
        frame.setVisible(true);
	}
	public static void main(String[] args) {
		GUI gui = new GUI();
	}
}
