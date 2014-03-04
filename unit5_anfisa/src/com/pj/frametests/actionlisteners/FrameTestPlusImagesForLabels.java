package com.pj.frametests.actionlisteners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Random;;

/**
* Example of main in FilledFrame class
* and inner class (click listener)
**/

public class FrameTestPlusImagesForLabels extends JFrame{
	private JButton button;
	public JLabel label;
	public JLabel label1;
	public JLabel label2;
	private Random r = new Random();
	/*
	 * Inner class for click listener:
	 */
	
	public class ClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("clicked");
			label.setText("test" + r.nextInt());
			//JOptionPane.showInputDialog("Test");
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new FrameTestPlusImagesForLabels();
		frame.setTitle("Frame sample title");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public FrameTestPlusImagesForLabels() {
		createComponents();
		setSize(400,500);
	}
	
	private void createComponents() {
		button = new JButton("Click me to generate random number");
		label = new JLabel("Sample Label text");
		label.setToolTipText( "This is label");
		Icon pic = new ImageIcon( getClass().getResource( "pic.png" ));
		label1 = new JLabel("Sample Label1 text");
		//label1.setText("testtext");
		label1.setToolTipText( "This is label");
		label1.setIcon(pic);
		label2 = new JLabel("Sample Label2 text");
		label2.setToolTipText( "This is label");
		label2.setIcon(pic);
		label2.setHorizontalTextPosition( SwingConstants.CENTER );
		label2.setVerticalTextPosition( SwingConstants.BOTTOM );
		JPanel panel = new JPanel();
		ActionListener listener = new ClickListener();
		button.addActionListener(listener);
		panel.add(button);
		panel.add(label);
		panel.add(label1);
		panel.add(label2);
		add(panel);
	}
}

