package com.pj.lesson9.examples;
import javax.swing.BoxLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.pj.frametests.actionlisteners.ClickListener;

import java.util.Random;;

/**
* Example of main in FilledFrame class
* and inner class (click listener)
**/

public class BoxLayoutTest extends JFrame{
	private JButton button;
	public JLabel label;
	private Random r = new Random();
	/*
	 * Inner class for click listener:
	 */
	
	
	public static void main(String[] args) {
		JFrame frame = new BoxLayoutTest();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
		frame.setTitle("Frame sample title");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public BoxLayoutTest() {
		createComponents();
		setSize(300,300);
	}
	
	private void createComponents() {
		button = new JButton("Click me to generate random number");
		label = new JLabel("Sample Label text");
		JPanel panel = new JPanel();
		ActionListener listener = new ClickListener();
		button.addActionListener(listener);
		panel.add(button);
		panel.add(label);
		add(panel);
	}
}

