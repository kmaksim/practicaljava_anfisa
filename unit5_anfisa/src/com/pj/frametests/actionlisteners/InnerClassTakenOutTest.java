package com.pj.frametests.actionlisteners;
import javax.swing.BoxLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* Example of main in FilledFrame class
* and inner class (click listener)
**/

public class InnerClassTakenOutTest extends JFrame{
	private JButton button;
	public static JLabel label;
	
	/*
	 * Inner class for click listener:
	 */
	
//	public class ClickListener implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("clicked");
//			label.setText("test" + r.nextInt());
//		}
//	}
	
	public static void main(String[] args) {
		JFrame frame = new InnerClassTakenOutTest();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),
				BoxLayout.Y_AXIS));
		frame.setTitle("Frame sample title");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public InnerClassTakenOutTest() {
		createComponents();
		setSize(300,300);
	}
	
	private void createComponents() {
		button = new JButton("Click me to generate random number");
		label = new JLabel("Sample Label text");
		JPanel panel = new JPanel();
		ActionListener listener = new ClickListener1();
		button.addActionListener(listener);
		panel.add(button);
		panel.add(label);
		add(panel);
	}
}

