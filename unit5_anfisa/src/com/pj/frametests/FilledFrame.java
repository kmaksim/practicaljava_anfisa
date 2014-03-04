package com.pj.frametests;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FilledFrame extends JFrame{
	private JButton button;
	private JLabel label;
	
	public FilledFrame() {
		createComponents();
		setSize(300,300);
	}
	
	private void createComponents() {

		JButton button = new JButton("Button text");
		JLabel label = new JLabel("Label text");
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(label);
		add(panel);

	}
}
