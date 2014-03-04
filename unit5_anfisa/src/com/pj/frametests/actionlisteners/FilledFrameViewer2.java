package com.pj.frametests.actionlisteners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* Example of main in FilledFrame class?
*
**/

public class FilledFrameViewer2 extends JFrame{
	private JButton button;
	private JLabel label;
	
	public static void main(String[] args) {
		JFrame frame = new FilledFrameViewer2();

		frame.setTitle("Frame sample title");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
	public FilledFrameViewer2() {
		createComponents();
		setSize(300,300);
	}
	
	private void createComponents() {

		JButton button = new JButton("Button text");
		JLabel label = new JLabel("Label text");
		JPanel panel = new JPanel();
		ActionListener listener = new ClickListener();
		button.addActionListener(listener);
		panel.add(button);
		panel.add(label);
		add(panel);

	}
	
}

