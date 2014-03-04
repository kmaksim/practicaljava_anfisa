package com.pj.frametests;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameTest1 {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button = new JButton("Button text");
		JLabel label = new JLabel("Label text");
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(label);
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setTitle("Frame sample title");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
