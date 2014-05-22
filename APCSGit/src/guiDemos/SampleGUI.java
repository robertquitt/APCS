package guiDemos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SampleGUI {
		private static class HelloWorldDisplay extends JPanel {
		      public void paintComponent(Graphics g) {
		         super.paintComponent(g);
		         g.drawString( "Hello World!", 20, 30 );
		      }
		   }
		   
		   private static class ButtonHandler implements ActionListener {
		      public void actionPerformed(ActionEvent e) {
		         System.exit(0);
		      }
		   }
		   
		   public static void main(String[] args) {
		      
		      HelloWorldDisplay displayPanel = new HelloWorldDisplay();
		      ButtonHandler listener = new ButtonHandler();

		      JPanel content = new JPanel();
		      content.setLayout(new BorderLayout());
		      content.add(displayPanel, BorderLayout.CENTER);
		      displayPanel.setLayout(new BorderLayout(0, 0));
		      
		      JLabel lblVociferousMouse = new JLabel("vociferous mouse");
		      lblVociferousMouse.setVerticalAlignment(SwingConstants.BOTTOM);
		      lblVociferousMouse.setHorizontalAlignment(SwingConstants.LEFT);
		      displayPanel.add(lblVociferousMouse);
		      
		      JPanel panel_1 = new JPanel();
		      panel_1.setBorder(new TitledBorder(null, "dur", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		      displayPanel.add(panel_1);
		      
		      JPanel panel = new JPanel();
		      panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		      
		      JPanel panel_2 = new JPanel();
		      GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		      gl_panel_1.setHorizontalGroup(
		      	gl_panel_1.createParallelGroup(Alignment.LEADING)
		      		.addGroup(gl_panel_1.createSequentialGroup()
		      			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
		      				.addGroup(gl_panel_1.createSequentialGroup()
		      					.addGap(57)
		      					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE))
		      				.addGroup(gl_panel_1.createSequentialGroup()
		      					.addGap(104)
		      					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		      			.addContainerGap(80, Short.MAX_VALUE))
		      );
		      gl_panel_1.setVerticalGroup(
		      	gl_panel_1.createParallelGroup(Alignment.LEADING)
		      		.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
		      			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		      			.addGap(44)
		      			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
		      			.addGap(64))
		      );
		      JButton okButton = new JButton("OK");
		      
		      JButton btnNewButton = new JButton("click me");
		      btnNewButton.addActionListener(new ActionListener() {
		      	public void actionPerformed(ActionEvent e) {
		      		JFrame hi = new JFrame("POPUP TEST");
		      		JPanel hi2 = new JPanel();
		      		hi2.setLayout(new BorderLayout());
		      		hi2.add(new HelloWorldDisplay());
		      		hi.setContentPane(hi2);
		      		hi.setSize(100, 100);
		      		hi.setLocation(200, 200);
		      		hi.setVisible(true);
		      	}
		      });
		      btnNewButton.setToolTipText("what");
		      btnNewButton.setIcon(null);
		      
		      JProgressBar progressBar = new JProgressBar();
		      GroupLayout gl_panel = new GroupLayout(panel);
		      gl_panel.setHorizontalGroup(
		      	gl_panel.createParallelGroup(Alignment.LEADING)
		      		.addGroup(gl_panel.createSequentialGroup()
		      			.addGap(99)
		      			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
		      				.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		      				.addGroup(gl_panel.createSequentialGroup()
		      					.addComponent(okButton)
		      					.addGap(5)
		      					.addComponent(btnNewButton)))
		      			.addContainerGap(125, Short.MAX_VALUE))
		      );
		      gl_panel.setVerticalGroup(
		      	gl_panel.createParallelGroup(Alignment.LEADING)
		      		.addGroup(gl_panel.createSequentialGroup()
		      			.addGap(5)
		      			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
		      				.addComponent(okButton)
		      				.addComponent(btnNewButton))
		      			.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
		      			.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		      			.addGap(66))
		      );
		      panel.setLayout(gl_panel);
		      okButton.addMouseListener(new MouseAdapter() {
		      	@Override
		      	public void mouseClicked(MouseEvent e) {
		      		System.out.println("wut");
		      	}
		      });
		      okButton.addActionListener(listener);
		      panel_1.setLayout(gl_panel_1);

		      JFrame window = new JFrame("GUI Test");
		      window.setContentPane(content);
		      window.setSize(547,379);
		      window.setLocation(100,100);
		      window.setVisible(true);

		   }
	}
