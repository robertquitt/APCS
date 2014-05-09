package guiDemos;
import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent

import javax.swing.*;       // access to JFrame and JComponents
import javax.swing.event.*;

public class ToeTacTic extends JFrame{
	private boolean x;
	public ToeTacTic() {
		super("Title Dingus");
		Container container = getContentPane();
		container.setLayout(new GridLayout(3,3));
		JButton button;
		for (int i = 0; i < 9; i++) {
			button = new JButton();
			container.add(button,i);
			button.addActionListener(new ButtonHandler());
		}
		setSize(300,300);
        setVisible(true);
        x = true;
	}
	public void reset() {
    	Container container = getContentPane();

		JButton button;
		container.removeAll();
		for (int i = 0; i < 9; i++) {
			button = new JButton();
			container.add(button,i);
			button.addActionListener(new ButtonHandler());
		}
    }
	public static void main(String[] args) {
		ToeTacTic test = new ToeTacTic();
		test.isFocusable();
	}
	private class ButtonHandler implements ActionListener {
        public void actionPerformed (ActionEvent event) {
        	AbstractButton button = (AbstractButton) event.getSource();
        	if (button.getText().equals("X wins!")||button.getText().equals("O wins!")) {
        		System.out.println("brhiuhuh");
        		reset();
        	}
        	if (button.getText().equals("")) {
        		((AbstractButton) event.getSource()).setText(x?"x":"o");
        		x = !x;
        		JButton newbutton;
        		switch(check()){
        			case 0:
        				break;
        			case 1:
        				getContentPane().removeAll();
        				newbutton = new JButton("X wins!");
        				newbutton.addActionListener(new ButtonHandler());
        				getContentPane().add(newbutton);
        				break;
        			case -1:
        				getContentPane().removeAll();
        				newbutton = new JButton("O wins!");
        				newbutton.addActionListener(new ButtonHandler());
        				getContentPane().add(newbutton);
        				break;
        		}
        	}
        }
        /**
         * 
         * @return 1 if x wins, 0 if noone has won, -1 if o wins
         */
        public int check() {
        	char[] a = new char[9];
        	Container container = getContentPane();
        	String s;
        	for (int i = 0; i < 9; i++) {
        		s = ((JButton) (container.getComponent(i))).getText();
        		a[i] = s!=null&&s.length()!=0?s.charAt(0):' ';
        	}
        	System.out.println();
        	
        	return
				a[0]==a[1]&&a[1]==a[2]&&a[2]!=' '?a[2]=='x'?1:-1:
				a[3]==a[4]&&a[4]==a[5]&&a[5]!=' '?a[5]=='x'?1:-1:
				a[6]==a[7]&&a[7]==a[8]&&a[8]!=' '?a[8]=='x'?1:-1:
				a[0]==a[3]&&a[3]==a[6]&&a[6]!=' '?a[6]=='x'?1:-1:
				a[1]==a[4]&&a[4]==a[7]&&a[7]!=' '?a[7]=='x'?1:-1:
				a[2]==a[5]&&a[5]==a[8]&&a[8]!=' '?a[8]=='x'?1:-1:
				a[0]==a[4]&&a[4]==a[8]&&a[8]!=' '?a[8]=='x'?1:-1:
				a[2]==a[4]&&a[4]==a[6]&&a[6]!=' '?a[6]=='x'?1:-1:
				0;
        		
        }
    }
}
/*a[0]==a[1]&&a[1]==a[2]&&a[2]!=' '?a[2]=='x'?1:-1:
a[3]==a[4]&&a[4]==a[5]&&a[5]!=' '?a[5]=='x'?1:-1:
a[6]==a[7]&&a[7]==a[8]&&a[8]!=' '?a[8]=='x'?1:-1:
a[0]==a[3]&&a[3]==a[6]&&a[6]!=' '?a[6]=='x'?1:-1:
a[1]==a[4]&&a[4]==a[7]&&a[7]!=' '?a[7]=='x'?1:-1:
a[2]==a[5]&&a[5]==a[8]&&a[8]!=' '?a[8]=='x'?1:-1:
a[0]==a[4]&&a[4]==a[8]&&a[8]!=' '?a[8]=='x'?1:-1:
a[2]==a[4]&&a[4]==a[6]&&a[6]!=' '?a[6]=='x'?1:-1:
0;*/