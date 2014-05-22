package src;

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
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new JButton("Submit");
        frame.getContentPane().add(button);
        field = new JTextField(20);
        frame.getContentPane().add(field);
        button.addActionListener(new Listener());
        frame.setSize(400, 90);
        frame.setVisible(true);
	}
	public static void main(String[] args) {
		GUI gui = new GUI();
	}
	private class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button) {
	            String text = field.getText();
	            String xD = "";
	            int dong = (int) (Math.pow(17,text.hashCode())%73);
	            int hue = new Random(text.hashCode()).nextInt();
	            for (char c:text.toCharArray()){
		            int hash = xD.hashCode();
	            	xD+=(c>>dong)^hash^hue;
	            }
	            if (xD.equals("15339895501326031979481851388165400689-1158800379192249064")) {
	            	JOptionPane.showMessageDialog(frame, "You win");
	            } else {
	            	JOptionPane.showMessageDialog(frame, "Naw");
				}
	        }
		}
		
	}
}
